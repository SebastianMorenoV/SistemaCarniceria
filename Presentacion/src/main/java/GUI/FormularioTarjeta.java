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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioTarjeta extends JPanel {

    private Aplicacion app;

    public FormularioTarjeta(Aplicacion app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        JLabel label = new JLabel("Ingrese datos de la tarjeta:");
        JTextField txtTarjeta = new JTextField(20);
        JButton btnProcesar = new JButton("Procesar Pago");

        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pago con tarjeta procesado correctamente.");
                app.mostrarMenuOpciones(); // Volver a la pantalla principal
            }
        });

        add(label);
        add(txtTarjeta);
        add(btnProcesar);
    }
}
