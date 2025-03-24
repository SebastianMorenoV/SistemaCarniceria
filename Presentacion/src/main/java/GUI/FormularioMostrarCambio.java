/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author janot
 */
public class FormularioMostrarCambio extends javax.swing.JPanel {
    Aplicacion app;
    Timer timer;
    double total;
    double pagoCon;
    double cambio = 0;
    
    /**
     * Creates new form FormularioMostrarCambio
     */
    public FormularioMostrarCambio(Aplicacion app) {
        initComponents();
        this.app = app;    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabelCantTotal = new javax.swing.JLabel();
        jlabelTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlabelCantPagaste = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelCantCambio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlabelTotal1 = new javax.swing.JLabel();
        btnAceptar = new GUI.PanelRound();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jlabelCantTotal.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jlabelCantTotal.setForeground(new java.awt.Color(0, 0, 0));

        jlabelTotal.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jlabelTotal.setForeground(new java.awt.Color(0, 0, 0));
        jlabelTotal.setText("Total:");

        jLabel2.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Pagaste Con:");

        jlabelCantPagaste.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jlabelCantPagaste.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cambio:");

        jLabelCantCambio.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabelCantCambio.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCantCambio.setText("$");

        jlabelTotal1.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jlabelTotal1.setForeground(new java.awt.Color(0, 0, 0));
        jlabelTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTotal1.setText("PAGO EFECTIVO");

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

        jLabel5.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Aceptar");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        btnAceptar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabelTotal1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelTotal)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCantCambio)
                    .addComponent(jlabelCantPagaste)
                    .addComponent(jlabelCantTotal))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelTotal1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelCantTotal)
                    .addComponent(jlabelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlabelCantPagaste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabelCantCambio))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(196, 196, 196)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
       btnAceptar.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        app.mostrarRegistrarVenta();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        btnAceptar.setBackground(new Color(60,63,65));
    }//GEN-LAST:event_jLabel5MouseExited

    public void cargarLabels(){
        jlabelCantTotal.setText("$" + total);
        jlabelCantPagaste.setText("$" + pagoCon);
        jLabelCantCambio.setText("$" + (total-pagoCon));
    }
    
    
    private void calcularCambio(){
        System.out.println();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPagoCon() {
        return pagoCon;
    }

    public void setPagoCon(double pagoCon) {
        this.pagoCon = pagoCon;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.PanelRound btnAceptar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabelCantCambio;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel jlabelCantPagaste;
    public javax.swing.JLabel jlabelCantTotal;
    private javax.swing.JLabel jlabelTotal;
    private javax.swing.JLabel jlabelTotal1;
    // End of variables declaration//GEN-END:variables
}
