/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ModuloRealizarVenta;

import GUI.Aplicacion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 *
 * @author Admin
 */
public class VentanaProcesandoPago extends JDialog {
    Aplicacion app;
    public VentanaProcesandoPago() {
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

        //cerrarPantallaDialogo();

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
            }
        };

        worker.execute();  // Iniciar el temporizador en segundo plano
        dialog.setVisible(true);
    }
}
