/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ModuloRealizarDevolucion;

import DTOs.Devolucion.CrearDevolucionDTO;
import GUI.Aplicacion;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sebastian Moreno
 */
public class PantallaDevolucion extends javax.swing.JPanel {

    Aplicacion app;

    public PantallaDevolucion(Aplicacion app) {
        this.app = app;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPanelVentaEnCaja = new javax.swing.JLabel();
        txtBusquedaNombre1 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        txtBusquedaNombre2 = new javax.swing.JLabel();
        inputRazon = new javax.swing.JTextField();
        txtBusquedaNombre3 = new javax.swing.JLabel();
        inputProductosDevueltos = new javax.swing.JTextField();
        txtBusquedaNombre4 = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        txtBusquedaNombre5 = new javax.swing.JLabel();
        btnFinalizarVenta = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFinalizarVenta1 = new GUI.PanelRound();
        btnTxtFinalizarVenta1 = new javax.swing.JLabel();
        btnFinalizarVenta2 = new GUI.PanelRound();
        btnTxtFinalizarVenta2 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPanelVentaEnCaja.setBackground(new java.awt.Color(0, 0, 0));
        txtPanelVentaEnCaja.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtPanelVentaEnCaja.setText("Devolución");
        add(txtPanelVentaEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 250, -1));

        txtBusquedaNombre1.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre1.setText("Venta:");
        add(txtBusquedaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 80, 30));

        inputNombre.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputNombre.setText("Nombre completo");
        inputNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputNombreFocusLost(evt);
            }
        });
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });
        inputNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreKeyTyped(evt);
            }
        });
        add(inputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 570, 50));

        txtBusquedaNombre2.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre2.setText("Razon de la devolución.*:");
        add(txtBusquedaNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 280, 30));

        inputRazon.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputRazon.setText("Razon");
        inputRazon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputRazonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputRazonFocusLost(evt);
            }
        });
        inputRazon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputRazonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputRazonKeyTyped(evt);
            }
        });
        add(inputRazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 570, 50));

        txtBusquedaNombre3.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre3.setText("Productos devueltos.*:");
        add(txtBusquedaNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 280, 30));

        inputProductosDevueltos.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputProductosDevueltos.setText("Seleccionar productos");
        inputProductosDevueltos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputProductosDevueltosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputProductosDevueltosFocusLost(evt);
            }
        });
        inputProductosDevueltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputProductosDevueltosActionPerformed(evt);
            }
        });
        inputProductosDevueltos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputProductosDevueltosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputProductosDevueltosKeyTyped(evt);
            }
        });
        add(inputProductosDevueltos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 570, 50));

        txtBusquedaNombre4.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre4.setText("Telefono.*:");
        add(txtBusquedaNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 280, 30));

        inputTelefono.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputTelefono.setText("Ingresar numero telefonico.");
        inputTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTelefonoFocusLost(evt);
            }
        });
        inputTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTelefonoKeyTyped(evt);
            }
        });
        add(inputTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 570, 50));

        txtBusquedaNombre5.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre5.setText("Nombre Completo.*:");
        add(txtBusquedaNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 280, 30));

        btnFinalizarVenta.setBackground(new java.awt.Color(187, 187, 187));
        btnFinalizarVenta.setRoundBottomLeft(15);
        btnFinalizarVenta.setRoundBottomRight(15);
        btnFinalizarVenta.setRoundTopLeft(15);
        btnFinalizarVenta.setRoundTopRight(15);
        btnFinalizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarVentaMouseClicked(evt);
            }
        });
        btnFinalizarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(187, 187, 187));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productos", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnFinalizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 330));

        add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 300, 360));

        btnFinalizarVenta1.setBackground(new java.awt.Color(44, 44, 44));
        btnFinalizarVenta1.setRoundBottomLeft(15);
        btnFinalizarVenta1.setRoundBottomRight(15);
        btnFinalizarVenta1.setRoundTopLeft(15);
        btnFinalizarVenta1.setRoundTopRight(15);
        btnFinalizarVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarVenta1MouseClicked(evt);
            }
        });
        btnFinalizarVenta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtFinalizarVenta1.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        btnTxtFinalizarVenta1.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtFinalizarVenta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtFinalizarVenta1.setText("Finalizar");
        btnTxtFinalizarVenta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarVenta1.add(btnTxtFinalizarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 290, 70));

        add(btnFinalizarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 370, 70));

        btnFinalizarVenta2.setBackground(new java.awt.Color(44, 44, 44));
        btnFinalizarVenta2.setRoundBottomLeft(15);
        btnFinalizarVenta2.setRoundBottomRight(15);
        btnFinalizarVenta2.setRoundTopLeft(15);
        btnFinalizarVenta2.setRoundTopRight(15);
        btnFinalizarVenta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarVenta2MouseClicked(evt);
            }
        });
        btnFinalizarVenta2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtFinalizarVenta2.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        btnTxtFinalizarVenta2.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtFinalizarVenta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtFinalizarVenta2.setText("Cancelar Devolucion");
        btnTxtFinalizarVenta2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarVenta2.add(btnTxtFinalizarVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 70));

        add(btnFinalizarVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 370, 70));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void inputNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNombreFocusGained
        if (inputNombre.getText().equals("Nombre completo")) {
            inputNombre.setText("");
        }
    }//GEN-LAST:event_inputNombreFocusGained

    private void inputNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNombreFocusLost
        if (inputNombre.getText().trim().isEmpty()) {
            inputNombre.setText("Nombre completo");
        }
    }//GEN-LAST:event_inputNombreFocusLost

    private void inputNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreKeyReleased
        char c = evt.getKeyChar();
        // Permitir solo letras, espacios y retroceso
        if (!Character.isLetter(c) && c != ' ' && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Ignorar entrada si no es válida
        }
    }//GEN-LAST:event_inputNombreKeyReleased

    private void inputNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreKeyTyped

    }//GEN-LAST:event_inputNombreKeyTyped

    private void inputRazonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputRazonFocusGained
        if (inputRazon.getText().equals("Razon")) {
            inputRazon.setText("");
        }
    }//GEN-LAST:event_inputRazonFocusGained

    private void inputRazonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputRazonFocusLost
        if (inputRazon.getText().trim().isEmpty()) {
            inputRazon.setText("Razon");
        }
    }//GEN-LAST:event_inputRazonFocusLost

    private void inputRazonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputRazonKeyReleased

    }//GEN-LAST:event_inputRazonKeyReleased

    private void inputRazonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputRazonKeyTyped

    }//GEN-LAST:event_inputRazonKeyTyped

    private void inputProductosDevueltosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputProductosDevueltosFocusGained
        if (inputNombre.getText().equals("Nombre Producto")) {
            inputNombre.setText("");
        }
    }//GEN-LAST:event_inputProductosDevueltosFocusGained

    private void inputProductosDevueltosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputProductosDevueltosFocusLost
        if (inputNombre.getText().trim().isEmpty()) {
            inputNombre.setText("Nombre Producto");
        }
    }//GEN-LAST:event_inputProductosDevueltosFocusLost

    private void inputProductosDevueltosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputProductosDevueltosKeyReleased

    }//GEN-LAST:event_inputProductosDevueltosKeyReleased

    private void inputProductosDevueltosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputProductosDevueltosKeyTyped

    }//GEN-LAST:event_inputProductosDevueltosKeyTyped

    private void inputTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTelefonoFocusGained
        if (inputTelefono.getText().equals("Ingresar numero telefonico.")) {
            inputTelefono.setText("");
        }
    }//GEN-LAST:event_inputTelefonoFocusGained

    private void inputTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTelefonoFocusLost
        if (inputTelefono.getText().trim().isEmpty()) {
            inputTelefono.setText("Ingresar numero telefonico.");
        }
    }//GEN-LAST:event_inputTelefonoFocusLost

    private void inputTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoKeyReleased

    }//GEN-LAST:event_inputTelefonoKeyReleased

    private void inputTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoKeyTyped

    }//GEN-LAST:event_inputTelefonoKeyTyped

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

    private void inputProductosDevueltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputProductosDevueltosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputProductosDevueltosActionPerformed

    private void btnFinalizarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarVentaMouseClicked

    }//GEN-LAST:event_btnFinalizarVentaMouseClicked

    private void btnFinalizarVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarVenta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarVenta1MouseClicked

    private void btnFinalizarVenta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarVenta2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarVenta2MouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaTicketDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnFinalizarVenta;
    private GUI.PanelRound btnFinalizarVenta1;
    private GUI.PanelRound btnFinalizarVenta2;
    private javax.swing.JLabel btnTxtFinalizarVenta1;
    private javax.swing.JLabel btnTxtFinalizarVenta2;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputProductosDevueltos;
    private javax.swing.JTextField inputRazon;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtBusquedaNombre1;
    private javax.swing.JLabel txtBusquedaNombre2;
    private javax.swing.JLabel txtBusquedaNombre3;
    private javax.swing.JLabel txtBusquedaNombre4;
    private javax.swing.JLabel txtBusquedaNombre5;
    private javax.swing.JLabel txtPanelVentaEnCaja;
    // End of variables declaration//GEN-END:variables

//Metodos auxiliares:
    public void registrarDevolucion(){
        CrearDevolucionDTO devolucionDTO = new CrearDevolucionDTO();
        devolucionDTO.setNombreCompleto(inputNombre.getText());
        devolucionDTO.setRazon(inputRazon.getText());
        //hacer logica de productos
        devolucionDTO.setProductosDevueltos(null);
        devolucionDTO.setTelefono(inputTelefono.getText());
    }
}
