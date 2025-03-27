/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
import DTOs.*;
import Implementacion.*;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;




public class Aplicacion {

    private JFrame framePrincipal; // Ventana principal
    public RegistrarVenta registrarVenta;
    public FormularioTarjeta formularioTarjeta;
    public FormularioEfectivo formularioEfectivo;
    private FormularioMostrarCambio mostrarCambio;
    private MenuOpciones menuOpciones;
    private JDialog ventanaActual; // Variable para almacenar la ventana actual
    private ventanaMostrarTicket ticket;
    public RealizarVenta realizarVenta;
    public ProcesadorPago procesadorPago;

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
        formulario.setVisible(true);
    }
    
    public void mostrarTicketPDF() {
        ventanaMostrarTicket ticket = new ventanaMostrarTicket(this);   
    }

    // Método para mostrar FormularioEfectivo
    public void mostrarFormularioEfectivo() {
        VentanaFormularioEfectivo formulario = new VentanaFormularioEfectivo(this,this.formularioEfectivo);
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

    // Cambiar de pantalla dentro del frame principal
    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }

    private JDialog abrirPantalla(JPanel nuevaPantalla) {
        // Cerrar la ventana actual si está abierta
        if (ventanaActual != null && ventanaActual.isVisible()) {
            ventanaActual.dispose();
        }
        // Crear un nuevo JDialog
        ventanaActual = new JDialog(framePrincipal, true); // Modal
        ventanaActual.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)); // Icono vacío
        ventanaActual.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventanaActual.getContentPane().add(nuevaPantalla);
        ventanaActual.pack();
        ventanaActual.setLocationRelativeTo(framePrincipal);
        ventanaActual.setVisible(true);

        return ventanaActual;
    }

    public void cerrarPantallaDialogo() {
        if (ventanaActual != null && ventanaActual.isVisible()) {
            ventanaActual.dispose(); // Cierra el JDialog
        }
    }
    public EmpleadoCargadoDTO cargarEmpleado(){
        return realizarVenta.cargarEmpleado();
    }
    public List<ProductoCargadoDTO> cargarProductos(){
        return realizarVenta.cargarProductos();
    }
    public ventaDTO obtenerVenta(){
        return registrarVenta.guardarVenta();
    }

}
