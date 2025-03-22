/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author janot
 */
public class FormularioEfectivo extends javax.swing.JPanel {

    /**
     * Creates new form FormularioEfectivo
     */
    public FormularioEfectivo(Aplicacion app) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnAceptar = new GUI.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        btnAceptar1 = new GUI.PanelRound();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, -1));

        jLabel2.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pago en efectivo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 620, -1));

        jLabel3.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Total:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("$0.00");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Pagaras con:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("$");
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 150, 30));

        btnAceptar.setBackground(new java.awt.Color(44, 44, 44));
        btnAceptar.setRoundBottomLeft(15);
        btnAceptar.setRoundBottomRight(15);
        btnAceptar.setRoundTopLeft(15);
        btnAceptar.setRoundTopRight(15);
        btnAceptar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Aceptar");
        btnAceptar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 140, 40));

        btnAceptar1.setBackground(new java.awt.Color(44, 44, 44));
        btnAceptar1.setRoundBottomLeft(15);
        btnAceptar1.setRoundBottomRight(15);
        btnAceptar1.setRoundTopLeft(15);
        btnAceptar1.setRoundTopRight(15);
        btnAceptar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cancelar");
        btnAceptar1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 140, 30));

        add(btnAceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 140, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.PanelRound btnAceptar;
    private GUI.PanelRound btnAceptar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
