/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

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

/**
 *
 * @author Admin
 */
public class VentanaErrorProcesandoPago extends JDialog {

    public VentanaErrorProcesandoPago() {
        ImageIcon iconoPng = new ImageIcon(getClass().getResource("/imagenes/no.png"));
        JLabel lblPng = new JLabel(iconoPng);

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.setPreferredSize(new Dimension(100, 100)); // Tamaño ideal para la imagen
        panelImagen.add(lblPng);

        JLabel lblMensaje = new JLabel("<html><h2>Procesando Pago</h2><p>El pago no fue exitoso</p></html>", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Product Sans Infanity", Font.PLAIN, 14));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setPreferredSize(new Dimension(400, 250));  // Tamaño del JOptionPane
        panel.add(lblMensaje, BorderLayout.NORTH);
        panel.add(panelImagen, BorderLayout.CENTER);

        JOptionPane procesarPago = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = procesarPago.createDialog("Procesando Pago");

        dialog.setSize(400, 275);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
