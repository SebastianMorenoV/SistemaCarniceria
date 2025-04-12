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
 * @author janot
 */
public class VentanaFormularioMostrarCambio extends JDialog{
    private final int width= 381;
    private final int height = 270;
    
    public VentanaFormularioMostrarCambio(Aplicacion app){
        configuracionVentana(app);
    }

    public void configuracionVentana(Aplicacion app){
        setTitle("Formulario Cambio");
        setSize(width, height);  // Tamaño personalizado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar ventana
        setResizable(false);
        
        // Agregar el formulario a la ventana
        FormularioMostrarCambio formulario = new FormularioMostrarCambio(app);
        add(formulario);
        
        setVisible(true);
    }
}
