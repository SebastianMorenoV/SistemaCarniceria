/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ModuloRealizarVenta;

import GUI.Aplicacion;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class VentanaFormularioTarjeta extends JDialog{
        public VentanaFormularioTarjeta(Aplicacion app) {
        // Configuración de la ventana
        super((JFrame) null, "Formulario Tarjeta", true); // Hace la ventana modal
        setSize(800, 500);  // Tamaño personalizado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar ventana
        setResizable(false);

        // Agregar el formulario a la ventana
        FormularioTarjeta formulario = new FormularioTarjeta(app);
        add(formulario);
    }
}
