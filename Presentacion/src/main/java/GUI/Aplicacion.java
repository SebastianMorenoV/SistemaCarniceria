package GUI;

/**
 * Esta clase representa el control de navegacion en la aplicacion.
 *
 * @author Sebastian Moreno
 */
import DTOs.ProductoEntradaDTO;
import DTOs.FechaDTO;
import EstrategiaPago.Pago;
import GUI.ModuloRealizarVenta.VentanaExitoProcesandoPago;
import GUI.ModuloRealizarVenta.VentanaFormularioEfectivo;
import GUI.ModuloRealizarVenta.VentanaProcesandoPago;
import GUI.ModuloRealizarVenta.MenuOpciones;
import GUI.ModuloRealizarVenta.VentanaFormularioMostrarCambio;
import GUI.ModuloRealizarVenta.FormularioMostrarCambio;
import GUI.ModuloRealizarVenta.FormularioEfectivo;
import GUI.ModuloRealizarVenta.FormularioTarjeta;
import GUI.ModuloRealizarVenta.RegistrarVenta;
import GUI.ModuloRealizarVenta.VentanaFormularioTarjeta;
import GUI.ModuloRealizarVenta.VentanaErrorProcesandoPago;
import GUI.ModuloRealizarVenta.ventanaMostrarTicket;
import DTOs.*;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import Devolucion.RealizarDevolucion;
import Exception.DevolucionException;
import Exception.GastoException;
import Exception.InventarioException;
import Exception.NegocioException;
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

import GUI.ModuloRegistrarEntrada.FormularioDatosEntrada;
import GUI.ModuloRegistrarEntrada.FormularioProductoNuevo;
import GUI.ModuloRegistrarEntrada.OpcionesInventario;
import GUI.ModuloRegistrarEntrada.PanelRegistrarProductosEntrada;
import GUI.ModuloRegistrarEntrada.SeleccionarProducto;
import GUI.ModuloRegistrarEntrada.SeleccionarProveedor;
import GUI.ModuloRegistrarSalida.DialogoFiltrarPorFecha;
import GUI.ModuloRegistrarSalida.DialogoFiltrarPorMes;
import GUI.ModuloRegistrarSalida.DialogoFiltrarPorProducto;
import GUI.ModuloRegistrarSalida.DialogoRegistrarSalida;

import GUI.ModuloRegistrarSalida.VentanaHistorialSalidas;

import Gasto.RegistrarGasto;
import Implementacion.RealizarVenta;
import Implementacion.RegistrarEntrada;
import Proveedor.RegistrarProveedor;
import excepciones.ProcesadorPagoException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Aplicacion {

    private JFrame framePrincipal; // Ventana principal
    private RegistrarVenta registrarVenta;
    private FormularioTarjeta formularioTarjeta;
    private FormularioEfectivo formularioEfectivo;
    private FormularioMostrarCambio mostrarCambio;
    private MenuOpciones menuOpciones;
    private JDialog ventanaActual; // Variable para almacenar la ventana actual
    private ventanaMostrarTicket ticket;
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
    private PanelRegistrarProductosEntrada panelResumenEntrada;
    private SeleccionarProducto seleccionarProducto;
    private SeleccionarProveedor seleccionarProveedor;
    private OpcionesInventario menuInventario;
    private FormularioProductoNuevo formularioProducto;
    
    //Caso de Uso Registrar Salidas
    private VentanaHistorialSalidas ventanaHistorialSalidas;
    
    public Aplicacion(){
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
        
        
        
        // Inicializar pantallas Caso de uso Principal (Venta)
        registrarVenta = new RegistrarVenta(this);
        formularioTarjeta = new FormularioTarjeta(this);
        formularioEfectivo = new FormularioEfectivo(this);
        mostrarCambio = new FormularioMostrarCambio(this);
        menuOpciones = new MenuOpciones(this);

        //Inicializar Pantallas de Devolucion
        menuDevolucion = new PantallaMenuDevolucion(this);
        pantallaTicketDevolucion = new PantallaTicket(this);
        pantallaDevolucion = new PantallaDevolucion(this);
        pantallaHistorialDevoluciones = new PantallaHistorialDevoluciones(this);

        //Pantallas de caso gastos inicializadas
        formularioAgregarProveedor = new FormularioAgregarProveedor(this);
        
        formularioRegistrarGasto = new FormularioRegistrarGasto(this);
        menuGastos = new MenuGastos(this);
        tablaHistorialGastos = new TablaHistorialGastos(this);
        
        //Caso de Uso Registrar Salidas
        ventanaHistorialSalidas = new VentanaHistorialSalidas(this);
         
    }

    // Método para mostrar RegistrarVenta (Pantalla Principal)
    // Método para mostrar FormularioTarjeta
    public void mostrarFormularioTarjeta() {
        VentanaFormularioTarjeta formulario = new VentanaFormularioTarjeta(this);
        formulario.setModal(true);
        formulario.setVisible(true);
    }

    public void mostrarTicketPDF() {
        ventanaMostrarTicket ticket = new ventanaMostrarTicket(this);
    }

    // Método para mostrar FormularioEfectivo
    public void mostrarFormularioEfectivo() {
        VentanaFormularioEfectivo formulario = new VentanaFormularioEfectivo(this, this.formularioEfectivo);
    }

    public void mostrarFormularioCambio() {
        VentanaFormularioMostrarCambio formulario = new VentanaFormularioMostrarCambio(this);
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

    //Gastos
    public void mostrarRegistrarGasto() {
        cambiarPantalla(formularioRegistrarGasto);
    }

    public void mostrarAgregarProveedor() {
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

    public void mostrarErrorVentaSinProducto() {
        JOptionPane.showMessageDialog(framePrincipal, "No hay productos para finalizar la venta.");
    }

    public void mostrarVentaCancelada() {
        JOptionPane.showMessageDialog(framePrincipal, "Venta cancelada o no registrada.");
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
        cambiarPantalla(pantallaHistorialDevoluciones);
    }

    public void mostrarPantallaMenuGastos() {
        cambiarPantalla(menuGastos);
    }

    public void mostrarPantallaHistorialGastos() {
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Cambiar de pantalla dentro del frame principal

    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }

    public void cerrarPantallaDialogo() {
        if (ventanaActual != null && ventanaActual.isVisible()) {
            ventanaActual.dispose(); // Cierra el JDialog
        }
    }

    public EmpleadoCargadoDTO cargarEmpleado() throws NegocioException {
        return realizarVenta.cargarEmpleado();
    }

    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException {
        return realizarVenta.cargarProductos();
    }

    public boolean verificarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
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

    public double getPagaraCon() {
        return formularioEfectivo.getPagaraCon();
    }

    public boolean validarPago(PagoNuevoDTO pago) throws NegocioException {
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

    public TicketDTO crearTicket(VentaDTO venta) {
        TicketDTO ticketNuevo = new TicketDTO(venta.getListadoProductosVenta(),
                venta.getFechaHora(),
                venta.getIva(),
                venta.getEmpleado(),
                venta.getSubtotal(),
                venta.getTotal());
        return ticketNuevo;
    }

//    Caso gastos
    public GastoDTO registrarGasto(CrearGastoDTO gasto) throws GastoException {
        try {
            return registrarGasto.agregarGasto(gasto);

        } catch (GastoException ex) {
            throw new GastoException("Error al registrar el gasto" + ex.getLocalizedMessage());
        }
    }

    public List<GastoDTO> consultarGastos() throws GastoException {
        return registrarGasto.consultarGastos();
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
    public void MostrarErrorNumeroInvalido(){ 
         JOptionPane.showMessageDialog(framePrincipal, "Error: Ingresa un valor numérico válido.");
         mostrarVentanaDatosEntrada();
    }
    public void MostrarErrorUsarioCancelo(){
        JOptionPane.showMessageDialog(framePrincipal, "El Usuario cancelo la operacion");
    }
    
    public void mostrarVentanaOpcionesInventario(){
        menuInventario = new OpcionesInventario(this);
        cambiarPantalla(menuInventario);        
    }
    
    public void mostrarVentanaProductoNuevo(){
        formularioProducto = new FormularioProductoNuevo(this);
        cambiarPantalla(formularioProducto);
    }
    
    public void mostrarVentanaSeleccionarProveedor() throws InventarioException{
        seleccionarProveedor = new SeleccionarProveedor(this); 
        cambiarPantalla(seleccionarProveedor);
    }
    
    public void mostrarVentanaSeleccionarProductosEntrada() throws NegocioException{    
        seleccionarProducto = new SeleccionarProducto(this); 
        cambiarPantalla(seleccionarProducto);
    }

    public void mostrarVentanaInformacionEntrada() throws InventarioException{
        panelResumenEntrada = new PanelRegistrarProductosEntrada(this); 
        cambiarPantalla(panelResumenEntrada);        
    }

    public void mostrarVentanaDatosEntrada() {
         FormularioDatosEntrada ventanaDatos = new FormularioDatosEntrada(this);
    }
    
    public void setProveedor(ProveedorDTO proveedor){
        registrarEntrada.setProveedor(proveedor);
    }
    
    public void setPrecioCompra(double precioCompra){
       registrarEntrada.setPrecioCompra(precioCompra);
    }
    
    public void setUnidades(double Unidades){
       registrarEntrada.setUnidades(Unidades);    
    }
    public void setProducto(ProductoCargadoDTO producto){
       registrarEntrada.setProductoEntrada(producto);
    }
    
    public List<ProveedorDTO> cargarProveedores() throws InventarioException{
        return registrarEntrada.cargarProveedores();
    }
    public List<ProductoEntradaDTO> cargarProductosEntrada(){
        return registrarEntrada.cargarProductosEntrada();   
    }
    
    public void agregarProductoEntrada() throws InventarioException{
        registrarEntrada.agregarProductoEntrada();
        mostrarVentanaInformacionEntrada();
    }
    public void setEntradaTemporal(EntradaDTO entrada){
        registrarEntrada.setEntradaTemporal(entrada);
    }
    public EntradaDTO getEntradaTemporal(){
        return registrarEntrada.getEntradaTemporal();
    }
    
    public void agregarProductoNuevo(ProductoCargadoDTO producto){
        registrarEntrada.agregarProducto(producto);
    }
    public void registrarEntrada(EntradaDTO entrada) throws InventarioException{
        registrarEntrada.registrarEntrada(entrada);
    }
    
    //Caso Registrar entrada----------------------------------------
    
    
    //Caso Registrar salidas----------------------------------------
    public void mostrarVentanaHistorialSalidas(){
        cambiarPantalla(ventanaHistorialSalidas);
    }
    
        public void mostrarDialogoAgregarSalida(){
        DialogoRegistrarSalida ven = new DialogoRegistrarSalida(framePrincipal, true);
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);
    }
    
    public void mostrarDialogoFiltrarPorMes(){
        DialogoFiltrarPorMes ven = new DialogoFiltrarPorMes(framePrincipal, true);
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);
    }
    
    public void mostrarDialogoFiltrarPorFecha(){
        DialogoFiltrarPorFecha ven = new DialogoFiltrarPorFecha(framePrincipal, true);
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);
    }
    
    public void mostrarDialogoFiltrarPorProducto(){
        DialogoFiltrarPorProducto ven = new DialogoFiltrarPorProducto(framePrincipal, true);
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);
    }

}
