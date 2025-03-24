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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Aplicacion {

    private JFrame framePrincipal; // Ventana principal
    protected RegistrarVenta registrarVenta;
    private FormularioTarjeta formularioTarjeta;
    public FormularioEfectivo formularioEfectivo;
    public FormularioMostrarCambio mostrarCambio;
    private MenuOpciones menuOpciones;
    private JDialog ventanaActual; // Variable para almacenar la ventana actual

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

    public void mostrarFormularioCambio() {
        abrirPantalla(mostrarCambio);
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

    public void mostrarProcesandoPago(boolean pago) {
        // Cargar el GIF
        ImageIcon iconoGif = new ImageIcon(getClass().getResource("/imagenes/cargando.gif"));
        JLabel lblGif = new JLabel(iconoGif);

        // Crear el mensaje con texto centrado
        JLabel lblMensaje = new JLabel("<html><h2>" + "Procesando Pago" + "</h2><p>" + "Procesando el pago de la tarjeta..." + "</p></html>", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Product Sans Infanity", Font.PLAIN, 14));

        // Panel principal con layout adecuado
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setPreferredSize(new Dimension(400, 250));  // Tamaño del JOptionPane
        panel.add(lblMensaje, BorderLayout.NORTH);

        // Panel para centrar el GIF
        JPanel panelGif = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelGif.add(lblGif);
        panel.add(panelGif, BorderLayout.CENTER);

        // Crear el JOptionPane
        JOptionPane procesarPago = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = procesarPago.createDialog("Procesando Pago");

        // Configurar tamaño del JDialog
        dialog.setSize(400, 180);
        dialog.setLocationRelativeTo(null);

        // Usar SwingWorker para no bloquear la ejecución
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(2000);  // Esperar el tiempo indicado
                return null;
            }

            @Override
            protected void done() {
                dialog.dispose();  // Cerrar el diálogo
                if (!pago) {
                    mostrarErrorProcesandoPago();
                } else {
                    // Cargar la imagen de éxito
                    ImageIcon iconoPng = new ImageIcon(getClass().getResource("/imagenes/comprobado.png"));
                    JLabel lblPng = new JLabel(iconoPng);

                    // Panel para centrar la imagen
                    JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    panelImagen.setPreferredSize(new Dimension(100, 100)); // Tamaño ideal para la imagen
                    panelImagen.add(lblPng);

                    // Crear el mensaje con texto centrado
                    JLabel lblMensajeFinal = new JLabel("<html><h2>Procesando Pago</h2><p>Pago exitoso</p></html>", SwingConstants.CENTER);
                    lblMensajeFinal.setFont(new Font("Product Sans Infanity", Font.PLAIN, 14));

                    // Panel principal para la confirmación
                    JPanel panelFinal = new JPanel(new BorderLayout(10, 10));
                    panelFinal.setPreferredSize(new Dimension(400, 250));  // Tamaño del JOptionPane
                    panelFinal.add(lblMensajeFinal, BorderLayout.NORTH);
                    panelFinal.add(panelImagen, BorderLayout.CENTER);

                    // Crear el JOptionPane final
                    JOptionPane procesarPagoFinal = new JOptionPane(panelFinal, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                    JDialog dialogFinal = procesarPagoFinal.createDialog("Procesando Pago");
                    dialogFinal.setSize(400, 275);
                    dialogFinal.setLocationRelativeTo(null);
                    dialogFinal.setVisible(true);
                }
            }
        };

        worker.execute();  // Iniciar el temporizador en segundo plano
        dialog.setVisible(true);
    }

    public void mostrarErrorProcesandoPago() {
        // Cargar la imagen
        ImageIcon iconoPng = new ImageIcon(getClass().getResource("/imagenes/no.png"));
        JLabel lblPng = new JLabel(iconoPng);

        // Panel para centrar la imagen
        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.setPreferredSize(new Dimension(100, 100)); // Tamaño ideal para la imagen
        panelImagen.add(lblPng);

        // Crear el mensaje con texto centrado
        JLabel lblMensaje = new JLabel("<html><h2>Procesando Pago</h2><p>El pago no fue exitoso</p></html>", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Product Sans Infanity", Font.PLAIN, 14));

        // Panel principal con layout adecuado
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setPreferredSize(new Dimension(400, 250));  // Tamaño del JOptionPane
        panel.add(lblMensaje, BorderLayout.NORTH);
        panel.add(panelImagen, BorderLayout.CENTER);

        // Crear el JOptionPane
        JOptionPane procesarPago = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = procesarPago.createDialog("Procesando Pago");

        // Configurar tamaño del JDialog
        dialog.setSize(400, 275);
        dialog.setLocationRelativeTo(null);
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
        ventanaActual = new JDialog(framePrincipal, true);
        ventanaActual.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        ventanaActual.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventanaActual.getContentPane().add(nuevaPantalla);
        ventanaActual.pack();
        ventanaActual.setLocationRelativeTo(framePrincipal);
        ventanaActual.setVisible(true);
    }

}
