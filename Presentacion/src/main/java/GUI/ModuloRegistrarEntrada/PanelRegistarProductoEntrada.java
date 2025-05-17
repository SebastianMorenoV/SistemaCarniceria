/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ModuloRegistrarEntrada;

import ControlInventario.controlRegistrarEntrada;
import javax.swing.JDialog;


/**
 *
 * @author HP
 */
public class PanelRegistarProductoEntrada extends JDialog{
    controlRegistrarEntrada control;
    PanelRegistrarProductosEntrada SeleccionProductoEntrada;
    
    public PanelRegistarProductoEntrada(controlRegistrarEntrada control){
        this.control = control;
        setTitle("Seleccionar Producto"); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null); 
        setResizable(false);
        SeleccionProductoEntrada = new PanelRegistrarProductosEntrada(control);
        add(SeleccionProductoEntrada);
        setVisible(true);
        
    }  
}
