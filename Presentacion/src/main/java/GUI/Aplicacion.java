/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Sebastian Moreno
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Aplicacion {

    private JFrame framePrincipal; // Ventana principal
    protected RegistrarVenta registrarVenta;
    private FormularioTarjeta formularioTarjeta;
    public FormularioEfectivo formularioEfectivo;
    public FormularioMostrarCambio mostrarCambio;
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
        mostrarCambio = new FormularioMostrarCambio(this);
        menuOpciones = new MenuOpciones(this);
    }

    // Método para mostrar RegistrarVenta (Pantalla Principal)

    // Método para mostrar FormularioTarjeta
    public void mostrarFormularioTarjeta() {  
        abrirPantalla(formularioTarjeta);
    }

    // Método para mostrar FormularioEfectivo
    public void mostrarFormularioEfectivo() {
        abrirPantalla(formularioEfectivo);
    }
    
    public void mostrarFormularioCambio(){
        abrirPantalla(mostrarCambio);
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
    
    public void mostrarProcesandoPago(String mensaje, String titulo, int duracion) {
        // Cargar el GIF
        ImageIcon iconoGif = new ImageIcon(getClass().getResource("/imagenes/cargando.gif")); 
        JLabel lblGif = new JLabel(iconoGif);

        // Crear el mensaje con texto + GIF
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel lblMensaje = new JLabel("<html><h2>" + titulo + "</h2><p>" + mensaje + "</p></html>");
        
        panel.setPreferredSize(new Dimension(400, 200));  // Tamaño del JOptionPane

        // Estilo del mensaje
        lblMensaje.setFont(new Font("Product Sans Infanity", Font.PLAIN, 14));
        panel.add(lblMensaje, BorderLayout.NORTH);
        panel.add(lblGif, BorderLayout.CENTER);

        // Crear el JOptionPane
        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog(titulo);

        // Configurar tamaño del JDialog
        dialog.setSize(500, 250);
        dialog.setLocationRelativeTo(null);
        dialog.pack(); 

        // Centrar la ventana
        dialog.setLocationRelativeTo(null);

        // Usar SwingWorker para no bloquear la ejecución
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(duracion);  // Esperar el tiempo indicado
                return null;
            }

            @Override
            protected void done() {
                dialog.dispose();  // Cerrar el diálogo
            }
        };

        worker.execute();  // Iniciar el temporizador en segundo plano
        dialog.setVisible(true);
    }    
    
    // Cambiar de pantalla dentro del frame principal
    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }
    
    private void abrirPantalla(JPanel nuevaPantalla) {
        // crear un nuevo JDialog que actue como una "ventana flotante"
        JDialog ventana= new JDialog(framePrincipal, true);  
        ventana.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // agregar el JPanel a la ventana q se abrira
        ventana.getContentPane().add(nuevaPantalla);
        ventana.pack();// ajustar tamaño al JPanel que se abre
        ventana.setLocationRelativeTo(framePrincipal); // centrar la ventana 

        ventana.setVisible(true);
    }
    
}
