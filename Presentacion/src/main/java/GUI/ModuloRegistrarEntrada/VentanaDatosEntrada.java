/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI.ModuloRegistrarEntrada;

import ControlInventario.controlRegistrarEntrada;
import javax.swing.JDialog;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class VentanaDatosEntrada extends JDialog{
    private controlRegistrarEntrada control;
    private FormularioDatosEntrada form;
    public VentanaDatosEntrada(controlRegistrarEntrada control){
        this.control = control;
        this.form = new FormularioDatosEntrada(control);
        setLocationRelativeTo(null); 
        setResizable(false);
        add(form);
        setVisible(true);
    }
}
 