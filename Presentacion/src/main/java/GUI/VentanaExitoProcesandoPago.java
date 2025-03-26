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
public class VentanaExitoProcesandoPago extends JDialog{

    public VentanaExitoProcesandoPago() {
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
