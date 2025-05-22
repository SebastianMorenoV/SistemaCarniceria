package Implementacion;

import DTOs.EmpleadoCargadoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.NuevoProductoVentaDTO;
import DTOs.PagoNuevoDTO;
import DTOs.PagoViejoDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import EstrategiaPago.IProcesadorPago;
import EstrategiaPago.PagoEfectivo;
import EstrategiaPago.PagoTarjeta;
import EstrategiaPago.Pago;
import EstrategiaReporte.ReporteService;
import Exception.NegocioException;
import Exception.VentaException;
import Interfaces.IEmpleadoBO;
import Interfaces.IProductoBO;
import Interfaces.IVentaBO;
import excepciones.ProcesadorPagoException;
import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Esta clase representa el subsistema de caso de uso (REALIZAR UNA VENTA).
 * Utiliza BOS para la conversion de tipos, tambien para la llamada a las DAO  y almacena variables temporales 
 * para acceder a ellas por el mediador cuando se requieran.
 * @author sebastian Moreno
 */
public class RealizarVenta implements IRealizarVenta {

    private IProductoBO productoBO = manejadoresBO.ManejadorObjetosNegocio.crearProductoBO();
    private IEmpleadoBO empleadoBO = manejadoresBO.ManejadorObjetosNegocio.crearEmpleadoBO();
    private IVentaBO ventaBO = manejadoresBO.ManejadorObjetosNegocio.crearVentasBO();

    //variables temporales
    private double total = 0.0;
    private double iva = 0.0;
    private double subtotal = 0.0;
    private double pagaraCon = 0.0; // probablemente deba de ir en subsitema.
    private VentaDTO ventaTemporal = null;
    //////////////////////////////////////

    private static Pago procesarPago = new Pago();
    private static IProcesadorPago estrategia;
    
    //Ponerle la interfaz por si algun dia se necesita cambiar.
    //INTERFAZ DE REPORTE FALTANTE...
    private static ReporteService realizarReporte = new ReporteService();
    
    /**
     * Metodo para cargar un empleado desde la base de datos mockeada.
     * Esto si el sistema crece usara la base de datos real, donde si existan los empleados.
     * @return un EmpleadoCargadoDTO si lo encuentra.
     * @throws NegocioException si no encuentra el empleado
     */
    @Override
    public EmpleadoCargadoDTO cargarEmpleado() throws VentaException {
        try {
            return empleadoBO.consultarEmpleado();
        } catch (NegocioException ex) {
            throw new VentaException("No se encontro al empleado" + ex.getMessage());
        }
    }
    
    /**
     * Metodo para cargar los productos desde la base de datos.
     * @return Lista de productos consultados.
     * @throws VentaException si no hay productos que consultar.
     */
    @Override
    public List<ProductoCargadoDTO> cargarProductos() throws VentaException {
        try {
            return productoBO.cargarProductos();
        } catch (NegocioException ex) {
            throw new VentaException("No hay productos" + ex.getMessage());
        }
    }
    /**
     * Metodo para registrar una venta.
     * @param venta la VentaDTO pasada desde presentacion para registrar.
     * @return la venta Persistida de la base de datos.
     * @throws VentaException si no se puede registrar la venta.
     */
    @Override
    public VentaDTO registrarVenta(VentaDTO venta) throws VentaException {
        try {
            return ventaBO.registrarVenta(venta);
        } catch (NegocioException ex) {
            throw new VentaException("No se pudo registrar la venta" + ex.getLocalizedMessage());
        }
    }
    /**
     * Metodo para agregar un nuevo producto venta.
     * Aclaracion: el producto Venta no se persiste en la base de datos como un objeto individual
     * Este metodo nos ayuda en la creacion de un productoVentaDTO para utilizarlo en la presentacion.
     * @param productoCargado El ProductoCargadoDTO sin los parametros de un productoVentaDTO
     * @param cantidad la cantidad de un Producto en especifico.
     * @return Un nuevo ProductoVentaDTO.
     */
    @Override
    public ProductoVentaDTO agregarProductoVenta(ProductoCargadoDTO productoCargado, double cantidad) {

        double importe = productoCargado.getPrecio() * cantidad;
        return new ProductoVentaDTO(productoCargado, cantidad, productoCargado.getPrecio(), importe);

    }

    @Override
    public double calcularSubtotal(List<NuevoProductoVentaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (NuevoProductoVentaDTO nuevoProductoVentaDTO : productosEnTabla) {
            double precioConIva = nuevoProductoVentaDTO.getImporte();
            subtotal += precioConIva / 1.16; // Quitar el IVA para obtener el subtotal
        }
        return subtotal;
    }

    /**
     * Metodo para procesar un pago , si el metodo de pago es una tarjeta,
     * cambiamos la estrategia a tarjeta, si no a efectivo. Retorna el valor
     * doble que proceso, si no logra procesar retorna 0.
     *
     * @param pago es la manera de pagar de un cliente
     * @return el valor doble que proceso , si no procesa retorna 0.
     */
    @Override
    public double procesarPago(PagoNuevoDTO pago) {

        if (pago.getMetodoPago().getNuevaTarjeta() != null) {
            estrategia = new PagoTarjeta();
        } else {
            estrategia = new PagoEfectivo();
        }

        try {
            PagoNuevoDTO p = new PagoNuevoDTO(LocalDateTime.now(), pago.getMetodoPago(), pago.getMonto());
            return procesarPago.procesarPago(estrategia, p);
        } catch (ProcesadorPagoException ex) {
            ex.getLocalizedMessage();
            return 0;
        }

    }
    /**
     * Metodo para validar un pago, utilizando el sistema externo dependiendo de la estrategia.
     * @param pago un PagoViejo dto con los detalles de el pago.
     * @return true si el pago es valido , false si no.
     * @throws ProcesadorPagoException si existe un error con el pago.
     */
    @Override
    public boolean validarPago(PagoViejoDTO pago) throws ProcesadorPagoException {
        boolean validado = false;
        if (pago.getMetodoPago().getNuevaTarjeta() != null) {
            estrategia = new PagoTarjeta();
        } else {
            estrategia = new PagoEfectivo();
        }

        try {
            PagoNuevoDTO p = new PagoNuevoDTO(LocalDateTime.now(), pago.getMetodoPago(), pago.getMonto());
            validado = procesarPago.validarPago(estrategia, p);
        } catch (ProcesadorPagoException ex) {
            throw new ProcesadorPagoException("Existio un error validando el pago: " + ex.getMessage());
        }

        return validado;
    }
    /**
     * Metodo que utiliza el modulo ProcesadorPago , busca coincidencias en las tarjetas.
     * Obtiene una tarjeta mockeada.
     * @param titular el titular de la tarjeta
     * @param numeroTarjeta el numero de la tarjeta
     * @param fechaVencimiento la fecha vencimiento pasada desde la presentacion con formato nn/nn
     * @param cvv numero de 3 digitos de la tarjeta
     * @return una NuevaTarjetaDTO si la encuentra
     * @throws VentaException si existe un error buscando la tarjeta o llega nula.
     */
    @Override
    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws VentaException {

        try {
            IProcesadorPago estrategia = new PagoTarjeta();
            return procesarPago.buscarTarjeta(estrategia, titular, numeroTarjeta, fechaVencimiento, cvv);
        } catch (ProcesadorPagoException e) {
            throw new VentaException("Error al encontrar tarjeta" + e.getLocalizedMessage());
        }
    }
    
    
    /**
     * Metodo para generar y mostrar un PDF de el ticket de la venta.
     * Este metodo doblega la responsabilidad de creacion de el ticket a el subsitema Externo.
     * Tambien genera un PDF recibido y le habla a el sistema local para abrirlo en el navegador automaticamente.
     * @param venta recibe una ventaDTO con los datos necesarios para crear el ticket.
     */
    @Override
    public void generarYMostrarPDFVenta(VentaDTO venta) {
        byte[] pdfBytes = realizarReporte.generarPDFVenta(venta);
        try {
            Path tempFile = Files.createTempFile("ticket_venta_", ".pdf");
            Files.write(tempFile, pdfBytes);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(tempFile.toFile());
            } else {
                System.out.println("No se puede abrir el PDF automáticamente");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error al guardar o abrir el PDF de la venta", ex);
        }
    }
    /**
     * Metodo para buscar los productos por un texto similar al ingresado.
     * @param textoBusqueda es el texto que recibimos de presentacion por el cual se buscara un producto.
     * @return una lista de uno o mas productosCargadosDTO.
     * @throws VentaException Si existe un error buscando por el nombre.
     */
    @Override
    public List<ProductoCargadoDTO> buscaProductosPorTexto(String textoBusqueda) throws VentaException {
        try {
            return productoBO.buscaPorNombre(textoBusqueda);
        } catch (NegocioException ex) {
            throw new VentaException("Error al buscar por nombre: " + ex.getLocalizedMessage());
        }
    }
    /**
     * Metodo para calcular el iva.
     * @param subtotal el subtotal de la venta
     * @return un iva double
     */
    @Override
    public double calcularIva(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }
    /**
     * Metodo para cargar el Total de una venta.
     * @param subtotal el subtotal de la venta.
     * @param iva el iva de la venta
     * @return el total
     */
    @Override
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }

    @Override
    public double obtenerTotal() {
        return total;
    }

    @Override
    public void setearTotal(Double total) {
        this.total = total;
    }

    @Override
    public void setearVenta(VentaDTO ventaNueva) {
        this.ventaTemporal = ventaNueva;
    }

    @Override
    public VentaDTO obtenerVenta() {
        return ventaTemporal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPagaraCon() {
        return pagaraCon;
    }

    public void setPagaraCon(double pagaraCon) {
        this.pagaraCon = pagaraCon;
    }

   

}
