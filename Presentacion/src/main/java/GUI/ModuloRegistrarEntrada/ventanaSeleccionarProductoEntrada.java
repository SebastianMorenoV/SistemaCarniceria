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
public class ventanaSeleccionarProductoEntrada extends JDialog{
    controlRegistrarEntrada control;
    seleccionarProductoCargadoDTO SeleccionProducto;
    
    public ventanaSeleccionarProductoEntrada(controlRegistrarEntrada control){
        this.control = control;
        setTitle("Seleccionar Producto");  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 670);
        setLocationRelativeTo(null); 
        setResizable(false);
        SeleccionProducto = new seleccionarProductoCargadoDTO(control);
        add(SeleccionProducto);
        setVisible(true);
        
        
    } 
}
