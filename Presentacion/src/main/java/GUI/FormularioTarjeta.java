/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.PagoNuevoDTO;
import Implementacion.ProcesadorPago;
import excepciones.ProcesadorPagoException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class FormularioTarjeta extends javax.swing.JPanel {
    Aplicacion app;
    ProcesadorPago proce;
    /**
     * Creates new form FormularioTarjeta
     */
    public FormularioTarjeta(Aplicacion app) {
        this.app = app;
        this.proce = new ProcesadorPago();
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputNumeroTarjeta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputTitularTarjeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputFechaExpiracion = new javax.swing.JTextField();
        inputCVV = new javax.swing.JTextField();
        btnRegresar = new GUI.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        btnAceptar = new GUI.PanelRound();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalles del pago");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 800, -1));

        jLabel2.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabel2.setText("CVV");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));
        add(inputNumeroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 270, 30));

        jLabel3.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabel3.setText("Titular de la tarjeta");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));
        add(inputTitularTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 270, 30));

        jLabel4.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabel4.setText("Numero de la tarjeta");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabel5.setText("Fecha de expiracion");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));
        add(inputFechaExpiracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 170, 30));
        add(inputCVV, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 140, 30));

        btnRegresar.setBackground(new java.awt.Color(44, 44, 44));
        btnRegresar.setRoundBottomLeft(15);
        btnRegresar.setRoundBottomRight(15);
        btnRegresar.setRoundTopLeft(15);
        btnRegresar.setRoundTopRight(15);
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        btnRegresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Regresar");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        btnRegresar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 160, 40));

        btnAceptar.setBackground(new java.awt.Color(44, 44, 44));
        btnAceptar.setRoundBottomLeft(15);
        btnAceptar.setRoundBottomRight(15);
        btnAceptar.setRoundTopLeft(15);
        btnAceptar.setRoundTopRight(15);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Aceptar");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 40));

        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 160, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        ((JDialog) SwingUtilities.getWindowAncestor((JComponent) evt.getSource())).dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        //app.mostrarProcesandoPago(false);
        String titular = inputTitularTarjeta.getText();
        String numeroTarjeta = inputNumeroTarjeta.getText();
        String fechaVencimiento = inputFechaExpiracion.getText();
        String cvvStr = inputCVV.getText();
        int cvv;
        cvv = Integer.parseInt(cvvStr);
        NuevaTarjetaDTO tarjeta = new NuevaTarjetaDTO(titular, numeroTarjeta, fechaVencimiento, cvv);
        Date fechaPago = new Date();
        double monto = 300.00;
        
        MetodoPagoDTO pene = new MetodoPagoDTO(tarjeta);
        PagoNuevoDTO pago = new PagoNuevoDTO(fechaPago, pene, monto);
        try {
            boolean ans = proce.verificarPago(pago);
            if(ans){
                app.mostrarProcesandoPago(true);
            }else{
                app.mostrarProcesandoPago(false);
            }
        } catch (ProcesadorPagoException ex) {
            app.mostrarProcesandoPago(false);
            Logger.getLogger(FormularioTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
         ((JDialog) SwingUtilities.getWindowAncestor((JComponent) evt.getSource())).dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.PanelRound btnAceptar;
    private GUI.PanelRound btnRegresar;
    private javax.swing.JTextField inputCVV;
    private javax.swing.JTextField inputFechaExpiracion;
    private javax.swing.JTextField inputNumeroTarjeta;
    private javax.swing.JTextField inputTitularTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
