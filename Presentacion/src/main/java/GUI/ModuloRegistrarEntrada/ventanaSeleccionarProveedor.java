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
public class ventanaSeleccionarProveedor extends JDialog{
    controlRegistrarEntrada control;
    seleccionarProveedor Seleccionproveedor;
    
    public ventanaSeleccionarProveedor(controlRegistrarEntrada control){
        setTitle("Seleccionar Proveedor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 680);
        setLocationRelativeTo(null); 
        setResizable(false);
        this.control = control;
        Seleccionproveedor = new seleccionarProveedor(control);
        add(Seleccionproveedor);
        setVisible(true);
        
    } 
}
