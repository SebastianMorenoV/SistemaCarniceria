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

public class RegistrarVenta extends JPanel {

    private Aplicacion app;

    public RegistrarVenta(Aplicacion app) {
        this.app = app;
        initUI();
    }

    private void initUI() {
        JButton btnTarjeta = new JButton("Pagar con Tarjeta");
        JButton btnEfectivo = new JButton("Pagar con Efectivo");

        btnTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mostrarFormularioTarjeta(); // Ir a FormularioTarjeta
            }
        });

        btnEfectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mostrarFormularioEfectivo(); // Ir a FormularioEfectivo
            }
        });

        add(btnTarjeta);
        add(btnEfectivo);
    }
}
