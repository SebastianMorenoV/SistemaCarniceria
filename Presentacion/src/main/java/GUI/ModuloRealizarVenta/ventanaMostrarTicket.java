/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ModuloRealizarVenta;

import DTOs.VentaDTO;
import GUI.Aplicacion;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class ventanaMostrarTicket extends JDialog {
    Aplicacion app;
    
    public ventanaMostrarTicket(Aplicacion app) {
        setTitle("Formulario de Tarjeta");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false);
        generarTicketVenta ticket = new generarTicketVenta(app);
        add(ticket);
        setVisible(true);
    }
         
    }
