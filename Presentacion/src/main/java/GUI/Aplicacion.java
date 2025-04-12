package GUI;

/**
 * Esta clase representa el control de navegacion en la aplicacion.
 * @author Sebastian Moreno
 */
import EstrategiaPago.ProcesadorPago;
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
import Implementacion.RealizarVenta;
import excepciones.ProcesadorPagoException;
import java.util.List;
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
    private ProcesadorPago procesadorPago;

    public Aplicacion() {
        framePrincipal = new JFrame("Sistema Carnicería");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(1150, 700);
        framePrincipal.setLocationRelativeTo(null); // Centrar pantalla

        // Inicializar pantallas
        this.realizarVenta = new RealizarVenta();
        this.procesadorPago = new ProcesadorPago();
        registrarVenta = new RegistrarVenta(this);
        formularioTarjeta = new FormularioTarjeta(this);
        formularioEfectivo = new FormularioEfectivo(this);
        mostrarCambio = new FormularioMostrarCambio(this);
        menuOpciones = new MenuOpciones(this);
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

    public EmpleadoCargadoDTO cargarEmpleado() {
        return realizarVenta.cargarEmpleado();
    }

    public List<ProductoCargadoDTO> cargarProductos() {
        return realizarVenta.cargarProductos();
    }

    public boolean verificarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        return procesadorPago.verificarPago(pago);
    }

    public NuevoProductoVentaDTO agregarProducto(ProductoCargadoDTO productoCargado, double cantidad) {
        return realizarVenta.agregarProducto(productoCargado, cantidad);
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

    public boolean validarPago(NuevoEfectivoDTO efectivo) {
        return procesadorPago.validarEfectivo(efectivo);
    }

    public double procesarPagoEfectivo(double total, double pagaraCon) {
        return procesadorPago.procesarPagoEfectivo(new NuevoEfectivoDTO(total, pagaraCon));
    }

    public void setearVenta(VentaDTO ventaNueva) {
        realizarVenta.setearVenta(ventaNueva);
    }

    public VentaDTO obtenerVenta() {
        return realizarVenta.obtenerVenta();
    }

}
