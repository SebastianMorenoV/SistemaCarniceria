
package Implementacion;

import BO.ProductoBO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.MetodoPagoDTO;
import DTOs.NuevoProductoVentaDTO;
import DTOs.PagoNuevoDTO;
//import DTOs.PagoNuevoDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.ProductosVentaDTO;
import DTOs.VentaDTO;
import EstrategiaPago.IProcesadorPago;
import EstrategiaPago.PagoEfectivo;
import EstrategiaPago.PagoTarjeta;
import EstrategiaPago.Pago;
import Exception.NegocioException;
import Interfaces.IEmpleadoBO;
import Interfaces.IProductoBO;
import Interfaces.IVentaBO;
import excepciones.ProcesadorPagoException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
//import excepciones.ProcesadorPagoException;
import java.util.List;

/**
 * Esta clase representa el subsistema de caso de uso. (REALIZAR UNA VENTA)
 *
 * @author Lap-064
 */
public class RealizarVenta implements IRealizarVenta {

    //  private Pago proce; //Encontrar la forma de como hacer para llamarle al prductoBO
    private IProductoBO productoBO = manejadoresBO.ManejadorObjetosNegocio.crearProductoBO();// esto es tamal
    private IEmpleadoBO empleadoBO = manejadoresBO.ManejadorObjetosNegocio.crearEmpleadoBO();
    private IVentaBO ventaBO = manejadoresBO.ManejadorObjetosNegocio.crearVentasBO();
    private Double total = 0.0;
    private VentaDTO ventaTemporal = null;
    private static Pago procesarPago = new Pago();
    private static IProcesadorPago estrategia;

    @Override
    public EmpleadoCargadoDTO cargarEmpleado() throws NegocioException{
        try {
            return empleadoBO.consultarEmpleado();
        } catch (NegocioException ex) {
            throw new NegocioException("No se encontro al empleado");  
           
        }
    }

    @Override
    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException{
        try {
            return  productoBO.cargarProductos();
            
        } catch (NegocioException ex) {
            throw new NegocioException("No hay productos");    
        }
    }
    
    public VentaDTO registrarVentaBO() throws NegocioException{
        return ventaBO.registrarVenta(ventaTemporal);
    }
    
    // en donde esta su uso?
    public ProductosVentaDTO ConsultarProductosVenta()throws NegocioException{
        return ventaBO.obtenerProductosVenta();
    }
    //
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

    @Override
    public double calcularIva(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }

    @Override
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }

    /**
     * Metodo para procesar un pago , si el metodo de pago es una tarjeta,
     * cambiamos la estrategia a tarjeta, si no a efectivo.
     * Retorna el valor doble que proceso, si no logra procesar retorna 0.
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

    @Override
    public boolean validarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        boolean validado = false;
        if (pago.getMetodoPago().getNuevaTarjeta() != null) {
            estrategia = new PagoTarjeta();
        } else {
            estrategia = new PagoEfectivo();
        }
        
        try {
            PagoNuevoDTO p = new PagoNuevoDTO(LocalDateTime.now(), pago.getMetodoPago(), pago.getMonto());
            validado =  procesarPago.validarPago(estrategia, p);
        } catch (ProcesadorPagoException ex) {
            ex.getLocalizedMessage();
        }
        
        return validado;
    }

}
