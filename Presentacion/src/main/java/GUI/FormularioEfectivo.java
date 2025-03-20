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

public class FormularioEfectivo extends JPanel {

    private Aplicacion app;

    public FormularioEfectivo(Aplicacion app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        JLabel label = new JLabel("Ingrese monto en efectivo:");
        JTextField txtEfectivo = new JTextField(10);
        JButton btnProcesar = new JButton("Procesar Pago");

        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pago en efectivo procesado correctamente.");
                app.mostrarRegistrarVenta(); // Volver a la pantalla principal
            }
        });

        add(label);
        add(txtEfectivo);
        add(btnProcesar);
    }
}
