/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.carniceria.presentacion;

import GUI.Aplicacion;
import GUI.ModuloRealizarVenta.FormularioEfectivo;
import GUI.ModuloRealizarVenta.MenuOpciones;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sebastian Moreno
 */
public class Presentacion {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        Aplicacion app = new Aplicacion();
        app.mostrarMenuOpciones();
    }
}
