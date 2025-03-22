/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
import javax.swing.*;

public class Aplicacion {

    private JFrame framePrincipal; // Ventana principal
    private RegistrarVenta registrarVenta;
    private FormularioTarjeta formularioTarjeta;
    private FormularioEfectivo formularioEfectivo;
    private MenuOpciones menuOpciones;

    public Aplicacion() {
        framePrincipal = new JFrame("Sistema Carnicería");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(1150, 700);
        framePrincipal.setLocationRelativeTo(null); // Centrar pantalla

        // Inicializar pantallas
        registrarVenta = new RegistrarVenta(this);
        formularioTarjeta = new FormularioTarjeta(this);
        formularioEfectivo = new FormularioEfectivo(this);
        menuOpciones = new MenuOpciones(this);
    }

    // Método para mostrar RegistrarVenta (Pantalla Principal)

    // Método para mostrar FormularioTarjeta
    public void mostrarFormularioTarjeta() {
        cambiarPantalla(formularioTarjeta);
    }

    // Método para mostrar FormularioEfectivo
    public void mostrarFormularioEfectivo() {
        cambiarPantalla(formularioEfectivo);
    }

    // Mostrar un mensaje de error si no hay productos
    public void mostrarErrorVentaSinProductos() {
        JOptionPane.showMessageDialog(framePrincipal, "Error: No hay productos en la venta.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarMenuOpciones(){
        cambiarPantalla(menuOpciones);
    }

    public void mostrarRegistrarVenta(){
        cambiarPantalla(registrarVenta);
    }
    // Cambiar de pantalla dentro del frame principal
    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }
}
