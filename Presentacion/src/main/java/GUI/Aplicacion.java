package GUI;

/**
 * Esta clase representa el control de navegacion en la aplicacion.
 *
 * @author Sebastian Moreno
 */
import DTOs.ProductoEntradaDTO;
import EstrategiaPago.Pago;
import GUI.ModuloRealizarVenta.VentanaExitoProcesandoPago;
import GUI.ModuloRealizarVenta.VentanaProcesandoPago;
import GUI.ModuloRealizarVenta.MenuOpciones;
import GUI.ModuloRealizarVenta.FormularioMostrarCambio;
import GUI.ModuloRealizarVenta.FormularioEfectivo;
import GUI.ModuloRealizarVenta.FormularioTarjeta;
import GUI.ModuloRealizarVenta.RegistrarVenta;
import GUI.ModuloRealizarVenta.VentanaErrorProcesandoPago;
import DTOs.*;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import Devolucion.RealizarDevolucion;
import Exception.DevolucionException;
import Exception.GastoException;
import Exception.InventarioException;
import Exception.NegocioException;
import Exception.VentaException;
import GUI.ModuloGastos.FormularioAgregarProveedor;
import GUI.ModuloGastos.FormularioEditarGasto;
import GUI.ModuloGastos.FormularioRegistrarGasto;
import GUI.ModuloGastos.MenuGastos;
import GUI.ModuloGastos.TablaHistorialGastos;
import GUI.ModuloRealizarDevolucion.PantallaDetallesHistorialDevolucion;
import GUI.ModuloRealizarDevolucion.PantallaDevolucion;
import GUI.ModuloRealizarDevolucion.PantallaHistorialDevoluciones;
import GUI.ModuloRealizarDevolucion.PantallaMenuDevolucion;
import GUI.ModuloRealizarDevolucion.PantallaTicket;
import GUI.ModuloRealizarVenta.GenerarTicketVenta;
import GUI.ModuloRegistrarEntrada.FormularioDatosEntrada;
import GUI.ModuloRegistrarEntrada.FormularioProductoNuevo;
import GUI.ModuloRegistrarEntrada.InformacionRegistrarEntrada;
import GUI.ModuloRegistrarEntrada.OpcionesInventario;
import GUI.ModuloRegistrarEntrada.SeleccionarProducto;
import GUI.ModuloRegistrarEntrada.SeleccionarProveedor;
import GUI.ModuloRegistrarSalida.DialogoRegistrarSalida;
import GUI.ModuloRegistrarSalida.VentanaHistorialSalidas;
import Gasto.RegistrarGasto;
import Implementacion.RealizarVenta;
import Implementacion.RegistrarEntrada;
import Proveedor.RegistrarProveedor;
import excepciones.ProcesadorPagoException;
import exception.SalidaException;
import java.time.LocalDate;
import java.awt.Frame;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import observerVentas.IObservable;
import observerVentas.Observable;
import salidas.IRealizarSalida;
import salidas.RealizarSalida;

public class Aplicacion {

    private JFrame framePrincipal; // Ventana principal
    private RegistrarVenta registrarVenta;
    private FormularioTarjeta formularioTarjeta;
    private FormularioEfectivo formularioEfectivo;
    private FormularioMostrarCambio mostrarCambio;
    private MenuOpciones menuOpciones;

    private GenerarTicketVenta ticket;
    private RealizarVenta realizarVenta;
    private Pago procesadorPago;

    //Caso de uso devolucion.
    private RealizarDevolucion realizarDevolucion;
    private PantallaMenuDevolucion menuDevolucion;
    private PantallaDevolucion pantallaDevolucion;
    private PantallaDetallesHistorialDevolucion pantallaDetallesHistorialDevolucion;
    private PantallaTicket pantallaTicketDevolucion;
    private PantallaHistorialDevoluciones pantallaHistorialDevoluciones;

    //Caso de uso Gastos
    private RegistrarGasto registrarGasto;
    private FormularioAgregarProveedor formularioAgregarProveedor;
    private FormularioEditarGasto formularioEditarGasto;
    private FormularioRegistrarGasto formularioRegistrarGasto;
    private MenuGastos menuGastos;
    private TablaHistorialGastos tablaHistorialGastos;

    //Proveedor
    private RegistrarProveedor registrarProveedor;

    //caso registrarEntrada
    private RegistrarEntrada registrarEntrada;
    private InformacionRegistrarEntrada panelResumenEntrada;
    private SeleccionarProducto seleccionarProducto;
    private SeleccionarProveedor seleccionarProveedor;
    private OpcionesInventario menuInventario;
    private FormularioProductoNuevo formularioProducto;

    //Caso de Uso Registrar Salidas
    private VentanaHistorialSalidas ventanaHistorialSalidas;
    private IRealizarSalida realizarSalida;

    //Pago con Efectivo
    private FormularioMostrarCambio fomularioMostrarCambio;

    //OBSERVABLE
    IObservable observable;
    
    public Aplicacion() {
        framePrincipal = new JFrame("Sistema Carnicería");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(1150, 700);
        framePrincipal.setLocationRelativeTo(null);

        // Incializar implementaciones
        this.realizarVenta = new RealizarVenta();
        this.procesadorPago = new Pago();
        this.realizarDevolucion = new RealizarDevolucion();
        this.registrarGasto = new RegistrarGasto();
        this.registrarProveedor = new RegistrarProveedor();
        this.registrarEntrada = new RegistrarEntrada();
        this.realizarSalida = new RealizarSalida();

        // Inicializar pantallas Caso de uso Principal (Venta)
        registrarVenta = new RegistrarVenta(this);
        formularioTarjeta = new FormularioTarjeta(this);
        menuOpciones = new MenuOpciones(this);

        //Inicializar Pantallas de Devolucion
        menuDevolucion = new PantallaMenuDevolucion(this);
        pantallaTicketDevolucion = new PantallaTicket(this);
        pantallaDevolucion = new PantallaDevolucion(this);

        //Pantallas de caso gastos inicializadas
        //formularioAgregarProveedor = new FormularioAgregarProveedor(this);
        menuGastos = new MenuGastos(this);

        formularioRegistrarGasto = new FormularioRegistrarGasto(this);
        menuGastos = new MenuGastos(this);
        tablaHistorialGastos = new TablaHistorialGastos(this);

        //Caso de Uso Registrar Salidas
        ventanaHistorialSalidas = new VentanaHistorialSalidas(this);
        
        //OBSERVABLE
        observable = new Observable(); 
        observable.addObserver(realizarSalida.getObserver());

    }

    // Método para mostrar RegistrarVenta (Pantalla Principal)
    // Método para mostrar FormularioTarjeta
    public void mostrarFormularioTarjeta() {

        abrirDialogo(formularioTarjeta, "Formulario Tarjeta", 800, 500);
    }

    public void mostrarTicketPDF() {
        ticket = new GenerarTicketVenta(this);
        abrirDialogo(ticket, "Ticket Venta", 500, 700);
    }

    // Método para mostrar FormularioEfectivo
    public void mostrarFormularioEfectivo() {
        formularioEfectivo = new FormularioEfectivo(this);
        abrirDialogo(formularioEfectivo, "Formulario de Efectivo", 620, 320);

    }

    public void abrirDialogo(JPanel formulario, String titulo, int ancho, int alto) {
        JDialog dialogo = new JDialog((Frame) null, titulo, true); // true = modal

        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogo.setSize(ancho, alto);
        dialogo.setLocationRelativeTo(null); // Centrar la ventana
        dialogo.setResizable(false);
        dialogo.setContentPane(formulario);
        dialogo.setVisible(true);
    }

    public void mostrarFormularioCambio() {
        fomularioMostrarCambio = new FormularioMostrarCambio(this);
        abrirDialogo(fomularioMostrarCambio, "Mostrar el cambio", 620, 320);
    }

    // Mostrar un mensaje de error si no hay productos
    public void mostrarErrorVentaSinProductos() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: No hay productos en la venta.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMenuOpciones() {
        cambiarPantalla(menuOpciones);
    }

    public void mostrarRegistrarVenta() {
        cambiarPantalla(registrarVenta);
    }
    
    public void reconstruirDefaultVenta(){
     registrarVenta = new RegistrarVenta(this);
        cambiarPantalla(registrarVenta);
    }
    public void reconstruirRegistrarVenta() {

        registrarVenta.reiniciarVenta();
        cambiarPantalla(registrarVenta);
    }

    //Gastos
    public void mostrarRegistrarGasto() {
        formularioRegistrarGasto = new FormularioRegistrarGasto(this);
        cambiarPantalla(formularioRegistrarGasto);
    }

    public void mostrarAgregarProveedor() {
        formularioAgregarProveedor = new FormularioAgregarProveedor(this);
        cambiarPantalla(formularioAgregarProveedor);
    }

    public void mostrarVentanaProcesandoPago() {
        VentanaProcesandoPago cargando = new VentanaProcesandoPago();
        cargando.setVisible(true);
    }

    public void mostrarVentanaErrorProcesandoPago() {
        VentanaErrorProcesandoPago error = new VentanaErrorProcesandoPago();
        error.setVisible(true);
    }

    public void mostrarVentanaExitoProcesandoPago() {
        VentanaExitoProcesandoPago exito = new VentanaExitoProcesandoPago();
        exito.setVisible(true);
    }

    public void mostrarErrorEmpleadoNoCargado() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: Empleado no cargado correctamente.");
    }

    public void mostrarErrorTarjetaNoEncontrada() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: Tarjeta no encontrada o datos invalidos.");
    }

    public void mostrarErrorVentaSinProducto() {
        JOptionPane.showMessageDialog(framePrincipal, "No hay productos para finalizar la venta.");
    }

    public void mostrarVentaCancelada() {
        JOptionPane.showMessageDialog(framePrincipal, "La venta aun no ha sido pagada.");
    }

    public void mostrarVentaYaPagada() {
        JOptionPane.showMessageDialog(framePrincipal, "La venta ya ha sido pagada, porfavor finaliza la venta.");
    }

    public String mostrarIngresarCantidad() {
        return (String) JOptionPane.showInputDialog(framePrincipal, "Ingresa la cantidad del producto:", "Cantidad", JOptionPane.QUESTION_MESSAGE, null, null, "1.0");
    }

    public int mostrarPreguntaEliminarProducto() {
        return JOptionPane.showConfirmDialog(framePrincipal, "¿Deseas eliminar el producto?", "Eliminar producto", JOptionPane.YES_NO_OPTION);
    }

    public int mostrarPreguntaReiniciarVenta() {
        return JOptionPane.showConfirmDialog(framePrincipal, "¿Estás seguro de que deseas reiniciar la venta?", "Confirmar Reinicio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int mostrarPreguntaFinalizarVenta() {
        return JOptionPane.showConfirmDialog(framePrincipal, "¿Desea finalizar la venta?", "Confirmar Venta", JOptionPane.YES_NO_OPTION);
    }

    public void mostrarErrorCantidadMayor0() {
        JOptionPane.showMessageDialog(framePrincipal, "La cantidad debe ser mayor que 0.");
    }

    public void mostrarErrorValorNumericoValido() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: Ingresa un valor numérico válido.");
    }

    public void mostrarErrorConvertirProducto() {
        JOptionPane.showMessageDialog(framePrincipal, "Error al convertir el producto.");
    }

    public void mostrarErrorSeleccionaProductoValido() {
        JOptionPane.showMessageDialog(framePrincipal, "Selecciona un producto válido.");
    }

    public void mostrarErrorCvvNecesario() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: El campo CVV es requerido.");
    }

    /////////////////////////////METODOS PARA EL CASO DE USO DE HACER UNA DEVOLUCION//////////////////////////////////////////////////////////////
    public void mostrarPantallaTicketDevolucion() {
        cambiarPantalla(pantallaTicketDevolucion);
    }

    public void mostrarPantallaMenuDevolucion() {
        cambiarPantalla(menuDevolucion);
    }

    public void mostrarPantallaDevolucion() {
        pantallaDevolucion = new PantallaDevolucion(this);
        cambiarPantalla(pantallaDevolucion);
    }

    public void mostrarPantallaDetallesHistorialDevolucion() {
        pantallaDetallesHistorialDevolucion = new PantallaDetallesHistorialDevolucion(this);
        cambiarPantalla(pantallaDetallesHistorialDevolucion);
    }

    public void mostrarPantallaHistorialDevolucion() {
        pantallaHistorialDevoluciones = new PantallaHistorialDevoluciones(this);
        cambiarPantalla(pantallaHistorialDevoluciones);
    }

    public void mostrarPantallaMenuGastos() {
        cambiarPantalla(menuGastos);
    }

    public void mostrarPantallaHistorialGastos() {
        tablaHistorialGastos = new TablaHistorialGastos(this);
        cambiarPantalla(tablaHistorialGastos);
    }

    public void mostrarPantallaEditarGasto() {
        formularioEditarGasto = new FormularioEditarGasto(this);
        cambiarPantalla(formularioEditarGasto);
    }

    public int mostrarPreguntaAñadirProducto() {
        return JOptionPane.showConfirmDialog(framePrincipal, "¿Deseas devolver este producto?", "Seleccionar producto", JOptionPane.YES_NO_OPTION);
    }

    public VentaDTO validarTicket(String ticket) throws DevolucionException {
        try {
            return realizarDevolucion.validarTicket(ticket);
        } catch (DevolucionException ex) {
            throw new DevolucionException("Error al consultar un ticket : " + ex.getLocalizedMessage());
        }
    }

    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucion) throws DevolucionException {
        try {
            return realizarDevolucion.registrarDevolucion(devolucion);
        } catch (DevolucionException ex) {
            throw new DevolucionException("Error al registrar una devolucion : " + ex.getLocalizedMessage());
        }
    }

    public void setVentaEncontradaTicket(VentaDTO venta) {
        realizarDevolucion.setVentaTemporal(venta);
    }

    public VentaDTO getVentaEncontradaTicket() {
        return realizarDevolucion.getVentaTemporal();

    }

    public List<DevolucionDTO> buscarDevolucionPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws DevolucionException {
        try {
            return realizarDevolucion.consultarDevolucionesPorFiltro(devolucionDTO);
        } catch (DevolucionException ex) {
            throw new DevolucionException("Error al consultar una devolucion : " + ex.getLocalizedMessage());
        }
    }

    public void setDevolucionTemporal(DevolucionDTO devolucion) {
        realizarDevolucion.setDevolucionTemporal(devolucion);
    }

    public DevolucionDTO getDevolucionTemporal() {
        return realizarDevolucion.getDevolucionTemporal();
    }

    public DevolucionDTO buscarDevolucionPorID(String id) throws DevolucionException {
        return realizarDevolucion.consultarDevolucionPorID(id);

    }

    public List<DevolucionDTO> obtenerDevoluciones() throws DevolucionException {
        return realizarDevolucion.consultarDevoluciones();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Cambiar de pantalla dentro del frame principal

    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }

    public void agregarProductoNuevo(ProductoCargadoDTO producto) throws NegocioException {
        registrarEntrada.agregarProducto(producto);
    }

    public EmpleadoCargadoDTO cargarEmpleado() throws NegocioException {
        return realizarVenta.cargarEmpleado();
    }

    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException {
        return realizarVenta.cargarProductos();
    }

    public boolean verificarPago(PagoViejoDTO pago) throws ProcesadorPagoException {
        return realizarVenta.validarPago(pago);
    }

    // que pedo aqui 
    public ProductoVentaDTO agregarProducto(ProductoCargadoDTO productoCargado, double cantidad) {
        return realizarVenta.agregarProductoVenta(productoCargado, cantidad);
    }

    public double calcularTotal(double subtotalCalculado, double iva) {
        double total = realizarVenta.calcularTotal(subtotalCalculado, iva);
        setTotalTemporal(total);

        return total;
    }

    public double calcularSubTotal(List<NuevoProductoVentaDTO> productosVenta) {
        return realizarVenta.calcularSubtotal(productosVenta);
    }

    public double calcularIVA(double subtotalCalculado) {
        return realizarVenta.calcularIva(subtotalCalculado);
    }

    //Getters and Setters
    public double getTotalTemporal() {
        return realizarVenta.obtenerTotal();
    }

    public void setTotalTemporal(double totalTemporal) {
        realizarVenta.setearTotal(totalTemporal);
    }

    public boolean validarPago(PagoViejoDTO pago) throws NegocioException {
        try {
            return realizarVenta.validarPago(pago);
        } catch (ProcesadorPagoException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    public double procesarPagoEfectivo(PagoNuevoDTO pago) {
        return realizarVenta.procesarPago(pago);
    }

    public void setearVenta(VentaDTO ventaNueva) {
        realizarVenta.setearVenta(ventaNueva);
    }

    public VentaDTO obtenerVenta() {
        return realizarVenta.obtenerVenta();
    }

//    public TicketDTO crearTicket(VentaDTO venta) {
//        TicketDTO ticketNuevo = new TicketDTO(venta.getListadoProductosVenta(),
//                venta.getFechaHora(),
//                venta.getIva(),
//                venta.getEmpleado(),
//                venta.getSubtotal(),
//                venta.getTotal());
//        return ticketNuevo;
//    }
//    Caso gastos
    public GastoDTO registrarGasto(CrearGastoDTO gasto) throws GastoException {
        try {
            return registrarGasto.agregarGasto(gasto);

        } catch (GastoException ex) {
            throw new GastoException("Error al registrar el gasto" + ex.getLocalizedMessage());
        }
    }

    public GastoDTO modificarGasto(GastoDTO gastoDTO) throws GastoException {
        try {
            return registrarGasto.modificarGasto(gastoDTO);

        } catch (GastoException ex) {
            throw new GastoException("Error al modificar el gasto" + ex.getLocalizedMessage());
        }
    }

    public ProveedorDTO buscarPorNombre(String nombre) throws GastoException {
        try {
            return registrarProveedor.buscarPorNombre(nombre);

        } catch (GastoException ex) {
            throw new GastoException("Error al encontrar proveedor" + ex.getLocalizedMessage());
        }
    }

    public void eliminarGasto(String folio) throws GastoException {
        try {
            registrarGasto.eliminarGasto(folio);

        } catch (GastoException ex) {
            throw new GastoException("Error al encontrar gasto" + ex.getLocalizedMessage());
        }
    }

    public GastoDTO buscarPorFolio(String folio) throws GastoException {
        try {
            return registrarGasto.buscarPorFolio(folio);

        } catch (GastoException ex) {
            throw new GastoException("Error al encontrar gasto" + ex.getLocalizedMessage());
        }
    }

    public List<GastoDTO> consultarGastos() throws GastoException {
        return registrarGasto.consultarGastos();
    }

    public List<GastoDTO> consultarGastosFiltrados(CrearGastoDTO gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws GastoException {
        return registrarGasto.consultarGastosFiltrados(gastoFiltro, fechaInicio, fechaFin);
    }

    public void setCrearGastoDTO(CrearGastoDTO gasto) {
        registrarGasto.setGastoPasable(gasto);
    }

    public CrearGastoDTO getCrearGastoDTO() {
        return registrarGasto.getGastoPasable();
    }

    //Proveedor
    public ProveedorDTO registrarProveedor(CrearProveedorDTO proveedor) throws GastoException {
        try {
            return registrarProveedor.agregarProveedor(proveedor);
        } catch (GastoException ex) {
            throw new GastoException("Error al registrar el proveedor" + ex.getLocalizedMessage());
        }
    }

    public List<ProveedorDTO> consultarProveedores() throws GastoException {
        return registrarProveedor.consultarProveedores();
    }

    //Caso Registrar entrada ----------------------------------------
        public void MostrarErrorNumeroInvalido() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: Ingresa un valor numérico válido.");
    }

    public void MostrarErrorUsarioCancelo() {
        JOptionPane.showMessageDialog(framePrincipal, "El Usuario cancelo la operacion");
    }

    public void mostrarVentanaOpcionesInventario() {
        menuInventario = new OpcionesInventario(this);
        cambiarPantalla(menuInventario);
    }

    public void mostrarVentanaProductoNuevo() {
        formularioProducto = new FormularioProductoNuevo(this);
        cambiarPantalla(formularioProducto);
    }

    public void mostrarVentanaSeleccionarProveedor() throws InventarioException {
        seleccionarProveedor = new SeleccionarProveedor(this);
        cambiarPantalla(seleccionarProveedor);
    }

    public void mostrarVentanaSeleccionarProductosEntrada() throws NegocioException {
        seleccionarProducto = new SeleccionarProducto(this);
        cambiarPantalla(seleccionarProducto);
    }

    public void mostrarVentanaInformacionEntrada() throws InventarioException {
        panelResumenEntrada = new InformacionRegistrarEntrada(this);
        cambiarPantalla(panelResumenEntrada);
    }

    public void mostrarVentanaDatosEntrada() {
        FormularioDatosEntrada ventanaDatos = new FormularioDatosEntrada(this);
    }


    public void setProveedor(ProveedorDTO proveedor) {
        registrarEntrada.setProveedor(proveedor);
    }

    public void setPrecioCompra(double precioCompra) {
        registrarEntrada.setPrecioCompra(precioCompra);
    }

    public void setUnidades(double Unidades) {
        registrarEntrada.setUnidades(Unidades);
    }

    public void setProducto(ProductoCargadoDTO producto) {
        registrarEntrada.setProductoEntrada(producto);
    }

    public List<ProveedorDTO> cargarProveedores() throws InventarioException {
        return registrarEntrada.cargarProveedores();
    }

    public List<ProductoEntradaDTO> cargarProductosEntrada() {
        return registrarEntrada.cargarProductosEntrada();
    }

    public List<ProductoCargadoDTO> cargarProductosCE() throws InventarioException {
        return registrarEntrada.cargarProductos();
    }


    public void agregarProductoEntrada() throws InventarioException {
        registrarEntrada.agregarProductoEntrada();
    }

    public void setEntradaTemporal(EntradaDTO entrada) {
        registrarEntrada.setEntradaTemporal(entrada);
    }

    public EntradaDTO getEntradaTemporal() {
        return registrarEntrada.getEntradaTemporal();
    }

    public void registrarEntrada(EntradaDTO entrada) throws InventarioException {
        registrarEntrada.registrarEntrada(entrada);
    }
    //metodos para seTear los atributos de la entrada temporal
    
    public double calcularIVAEntrada(double subtotal) {
        return registrarEntrada.calcularIVA(subtotal);
    }
    public double calcularSubtotalEntrada(List<ProductoEntradaDTO> productosEnTabla) {
        return registrarEntrada.calcularSubtotal(productosEnTabla);
    }
    public double calcularTotalEntrada(double iva, double subtotal) {
        return registrarEntrada.calcularTotal(iva, subtotal);
    }
    public void setIVATemporalEntrada(double iva) {
        registrarEntrada.setIva(iva);
    }
    public void setTotalTemporalTemporalEntrada(double total) {
        registrarEntrada.setTotal(total);
    }
    public void setSubtotalTemporalEntrada(double subtotal) {
        registrarEntrada.setSubtotal(subtotal);
    }
    public double getIVATemporalEntrada() {
        return registrarEntrada.getIva();
    }
    public double getTotalTemporalEntrada() {
        return registrarEntrada.getTotal();
    }
    public double getSubtotalTemporalEntrada() {
        return registrarEntrada.getSubtotal();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////METODOS NUEVOS PARA CASOVENTA///////////////////////////////////////
    public void setTotalVenta(double totalTemporal) {
        realizarVenta.setearTotal(totalTemporal);
    }

    public double getTotalVenta() {
        return realizarVenta.obtenerTotal();
    }

    public void setIvaVenta(double ivaTemporal) {
        realizarVenta.setIva(ivaTemporal);
    }

    public double getIvaVenta() {
        return realizarVenta.getIva();
    }

    public void setSubtotalVenta(double subtotal) {
        realizarVenta.setSubtotal(subtotal);
    }

    public double getSubtotalVenta() {
        return realizarVenta.getSubtotal();
    }

    public void setPagaraCon(double cantidadDineroEfectivo) {
        realizarVenta.setPagaraCon(cantidadDineroEfectivo);
    }

    public double getPagaraCon() {
        return realizarVenta.getPagaraCon();
    }

    public VentaDTO registrarVenta(VentaDTO venta) throws VentaException, SalidaException {
        try {
            VentaDTO ventaDTO = realizarVenta.registrarVenta(venta);
            observable.notifyObservers(venta, realizarSalida);
            return ventaDTO;
        } catch (VentaException ex) {
            throw new VentaException("Ocurrio un error registrando la venta" + ex.getMessage());
        }
    }

    public List<ProductoCargadoDTO> buscaPorNombre(String textoBusqueda) throws VentaException{
        try {
            return realizarVenta.buscaPorNombre(textoBusqueda);
        } catch (VentaException ex) {
            throw new VentaException("Ocurrio un error al buscar los productos por nombre" + ex.getMessage());
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////METODOS PARA EL CASO DE USO DE HACER UNA SALIDA//////////////////////////////////////////////////////////////
    public void mostrarVentanaHistorialSalidas() {
        cambiarPantalla(ventanaHistorialSalidas);
    }

    public void mostrarDialogoAgregarSalida() {
        DialogoRegistrarSalida ven = new DialogoRegistrarSalida(framePrincipal, true, this);
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);
    }

    public List<ProductoCargadoDTO> busquedaProductos(String nombre) throws SalidaException {
        try {
            return realizarSalida.buscadorProductos(nombre);
        } catch (SalidaException e) {
            throw new SalidaException("Error al buscar producto");
        }
    }

    public boolean agregarNuevaSalida(NuevaSalidaDTO nuevaSalidaDTO) throws SalidaException {
        try {
            SalidaDTO salidaDTO = realizarSalida.agregarNuevaSalida(nuevaSalidaDTO);

        } catch (SalidaException e) {
            throw new SalidaException(e.getMessage());
        }

        return true;
    }

    public void reconstruirVentanaHistorialSalidas() {
        ventanaHistorialSalidas = new VentanaHistorialSalidas(this);
        cambiarPantalla(ventanaHistorialSalidas);
    }

    public List<SalidaDTO> cargarSalidas() throws SalidaException {
        try {
            return realizarSalida.cargarTodasLasSalidas();
        } catch (SalidaException e) {
            throw new SalidaException("Error al cargar todas las salidas", e);
        }
    }

    public List<SalidaDTO> cargarSalidasFiltradas(String nombre, Date fechaDesde, Date fechaHasta) throws SalidaException {
        try {
            return realizarSalida.filtrarSalidas(nombre, fechaHasta, fechaDesde);
        } catch (SalidaException e) {
            throw new SalidaException("Error al cargar las salidas filtradas", e);
        }
    }
    
    public boolean restarStockAProducto(Double stock, Integer codigo) throws SalidaException{
        try {
            return realizarSalida.restarStockAProducto(stock, codigo);
        } catch (SalidaException e) {
            throw new SalidaException("Error al restar el stock del producto", e);
        }
    }

    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws VentaException {
        return realizarVenta.buscarTarjeta(titular, numeroTarjeta, fechaVencimiento, cvv);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void generarPDFVenta(VentaDTO venta) {
        realizarVenta.generarYMostrarPDFVenta(venta);
    }

    public void generarPDFGasto(List<GastoDTO> gastos) {
        registrarGasto.generarYMostrarPDFGasto(gastos);
    }
}
