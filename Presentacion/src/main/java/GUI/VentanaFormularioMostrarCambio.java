/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author janot
 */
public class VentanaFormularioMostrarCambio extends JDialog{
    private final int width= 381;
    private final int height = 270;
    
    public VentanaFormularioMostrarCambio(Aplicacion app,double total, double pagaraCon, double cambio){
        configuracionVentana(app,total,pagaraCon,cambio);
    }

    public void configuracionVentana(Aplicacion app, double total, double pagaraCon, double cambio){
        setTitle("Formulario Cambio");
        setSize(width, height);  // Tamaño personalizado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar ventana
        setResizable(false);
        
        // Agregar el formulario a la ventana
        FormularioMostrarCambio formulario = new FormularioMostrarCambio(app,total,pagaraCon,cambio);
        add(formulario);
        
        setVisible(true);
    }
}
