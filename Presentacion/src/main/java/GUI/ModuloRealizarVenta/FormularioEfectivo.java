/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ModuloRealizarVenta;

import DTOs.MetodoPagoDTO;
import DTOs.NuevoEfectivoDTO;
import DTOs.PagoNuevoDTO;
import GUI.Aplicacion;
import EstrategiaPago.Pago;
import Exception.NegocioException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author janot
 */
public class FormularioEfectivo extends javax.swing.JPanel {

    private Aplicacion app;
    private double total;
    private double pagaraCon;

    /**
     * Creates new form FormularioEfectivo
     */
    public FormularioEfectivo(Aplicacion app) {
        this.app = app;
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

        JLabelPagoEfectivo = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelPagaraCon = new javax.swing.JLabel();
        jTextPago = new javax.swing.JTextField();
        btnAceptar = new GUI.PanelRound();
        jLabelAceptar = new javax.swing.JLabel();
        btnCancelar = new GUI.PanelRound();
        jLabelRegresar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabelPagoEfectivo.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        JLabelPagoEfectivo.setForeground(new java.awt.Color(0, 0, 0));
        JLabelPagoEfectivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelPagoEfectivo.setText("Pago en efectivo");
        add(JLabelPagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 620, -1));

        jLabelTotal.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotal.setText("Total:");
        add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jLabelPagaraCon.setBackground(new java.awt.Color(0, 0, 0));
        jLabelPagaraCon.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelPagaraCon.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPagaraCon.setText("Pagaras con:");
        add(jLabelPagaraCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jTextPago.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 150, 30));

        btnAceptar.setBackground(new java.awt.Color(44, 44, 44));
        btnAceptar.setRoundBottomLeft(15);
        btnAceptar.setRoundBottomRight(15);
        btnAceptar.setRoundTopLeft(15);
        btnAceptar.setRoundTopRight(15);
        btnAceptar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAceptar.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabelAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAceptar.setText("Aceptar");
        jLabelAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAceptarMouseExited(evt);
            }
        });
        btnAceptar.add(jLabelAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 140, 40));

        btnCancelar.setBackground(new java.awt.Color(44, 44, 44));
        btnCancelar.setRoundBottomLeft(15);
        btnCancelar.setRoundBottomRight(15);
        btnCancelar.setRoundTopLeft(15);
        btnCancelar.setRoundTopRight(15);
        btnCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegresar.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabelRegresar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegresar.setText("Regresar");
        jLabelRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseExited(evt);
            }
        });
        btnCancelar.add(jLabelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseClicked
        ((JDialog) SwingUtilities.getWindowAncestor((JComponent) evt.getSource())).dispose();
    }//GEN-LAST:event_jLabelRegresarMouseClicked

    private void jLabelRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseEntered
        btnCancelar.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_jLabelRegresarMouseEntered

    private void jLabelAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAceptarMouseClicked
        if (calcularCambio()) {
            ((JDialog) SwingUtilities.getWindowAncestor((JComponent) evt.getSource())).dispose();
        }
    }//GEN-LAST:event_jLabelAceptarMouseClicked

    private void jLabelAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAceptarMouseEntered
        btnAceptar.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_jLabelAceptarMouseEntered

    private void jLabelAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAceptarMouseExited
        btnAceptar.setBackground(new Color(60, 63, 65));
    }//GEN-LAST:event_jLabelAceptarMouseExited

    private void jLabelRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseExited
        btnCancelar.setBackground(new Color(60, 63, 65));
    }//GEN-LAST:event_jLabelRegresarMouseExited

    private boolean calcularCambio() {
        total = app.getTotalTemporal();
    


        if (validarTextFieldPagaraCon()) {
            pagaraCon = Double.parseDouble(jTextPago.getText());
            NuevoEfectivoDTO nuevoPagoEfectivo = new NuevoEfectivoDTO(pagaraCon);
            PagoNuevoDTO pago = new PagoNuevoDTO(LocalDateTime.MAX, new MetodoPagoDTO(nuevoPagoEfectivo), total);
            try {
                if (!app.validarPago(pago)) {
                    JOptionPane.showMessageDialog(this, "No te alcanza");
                } else {
                    app.setTotalTemporal(total);
                    app.mostrarFormularioCambio();
                    return true;
                }
            } catch (NegocioException | HeadlessException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        return false;

    }

    //Valida el campo de texto
    private boolean validarTextFieldPagaraCon() {
        String pagaraCon = jTextPago.getText();
        //Validar si el campo de texto esta vacio
        if (pagaraCon.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo esta vacio");
            return false;
        }

        try {
            Double.parseDouble(pagaraCon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tiene que ser de tipo numerico");
        }

        return true;
    }

    public double getPagaraCon() {
        return pagaraCon;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelPagoEfectivo;
    private GUI.PanelRound btnAceptar;
    private GUI.PanelRound btnCancelar;
    private javax.swing.JLabel jLabelAceptar;
    private javax.swing.JLabel jLabelPagaraCon;
    private javax.swing.JLabel jLabelRegresar;
    public javax.swing.JLabel jLabelTotal;
    private javax.swing.JTextField jTextPago;
    // End of variables declaration//GEN-END:variables
}
