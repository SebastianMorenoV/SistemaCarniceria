/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI.ModuloRegistrarEntrada;

import ControlInventario.controlRegistrarEntrada;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class VentanaInformacionEntrada extends JDialog{
    private controlRegistrarEntrada control;
    private PanelRegistrarProductosEntrada panelInformarcionEntrada;
    
    public VentanaInformacionEntrada(controlRegistrarEntrada control){
        this.control = control;
        setTitle("Seleccionar Producto");  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null); 
        setResizable(false);
        panelInformarcionEntrada = new PanelRegistrarProductosEntrada(control);
        add(panelInformarcionEntrada);
        setVisible(true);

    } 
}
