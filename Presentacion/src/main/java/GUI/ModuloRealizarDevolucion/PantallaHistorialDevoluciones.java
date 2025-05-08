package GUI.ModuloRealizarDevolucion;

import GUI.Aplicacion;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sebastian Moreno
 */
public class PantallaHistorialDevoluciones extends javax.swing.JPanel {

    private Aplicacion app;

    public PantallaHistorialDevoluciones(Aplicacion app) {
        this.app = app;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizarVenta = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fechaFin = new javax.swing.JTextField();
        inputTelefono = new javax.swing.JTextField();
        inputNombre = new javax.swing.JTextField();
        fechaInicio = new javax.swing.JTextField();
        txtBusquedaNombre1 = new javax.swing.JLabel();
        txtBusquedaNombre2 = new javax.swing.JLabel();
        txtBusquedaNombre3 = new javax.swing.JLabel();
        txtBusquedaNombre4 = new javax.swing.JLabel();
        txtPanelVentaEnCaja = new javax.swing.JLabel();
        btnIngresar = new GUI.PanelRound();
        btnTxtIngresar = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                "Codigo reembolso", "Articulos Reembolsados", "Razon", "Fecha", "ID", "Cliente", "Total Regresado", "Detalles"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnFinalizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, 330));

        add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 1010, 360));

        fechaFin.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        fechaFin.setText("Seleccionar Fecha");
        fechaFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaFinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaFinFocusLost(evt);
            }
        });
        fechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaFinActionPerformed(evt);
            }
        });
        fechaFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fechaFinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaFinKeyTyped(evt);
            }
        });
        add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 270, 50));

        inputTelefono.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputTelefono.setText("Telefono");
        inputTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTelefonoFocusLost(evt);
            }
        });
        inputTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTelefonoActionPerformed(evt);
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
        add(inputTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 240, 50));

        inputNombre.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputNombre.setText("Nombre");
        inputNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputNombreFocusLost(evt);
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
        add(inputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 270, 50));

        fechaInicio.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        fechaInicio.setText("Seleccionar Fecha");
        fechaInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaInicioFocusLost(evt);
            }
        });
        fechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaInicioActionPerformed(evt);
            }
        });
        fechaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fechaInicioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaInicioKeyTyped(evt);
            }
        });
        add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 270, 50));

        txtBusquedaNombre1.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre1.setText("Fecha Fin:");
        add(txtBusquedaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 230, 30));

        txtBusquedaNombre2.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre2.setText("Telefono cliente : ");
        add(txtBusquedaNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 230, 30));

        txtBusquedaNombre3.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre3.setText("Nombre Cliente :");
        add(txtBusquedaNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 230, 30));

        txtBusquedaNombre4.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre4.setText("Fecha Inicio:");
        add(txtBusquedaNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 230, 30));

        txtPanelVentaEnCaja.setBackground(new java.awt.Color(0, 0, 0));
        txtPanelVentaEnCaja.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtPanelVentaEnCaja.setText("Historial de Devoluciones");
        add(txtPanelVentaEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 540, -1));

        btnIngresar.setBackground(new java.awt.Color(8, 124, 252));
        btnIngresar.setRoundBottomLeft(15);
        btnIngresar.setRoundBottomRight(15);
        btnIngresar.setRoundTopLeft(15);
        btnIngresar.setRoundTopRight(15);
        btnIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtIngresar.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        btnTxtIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtIngresar.setText("INGRESAR");
        btnTxtIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtIngresarMouseClicked(evt);
            }
        });
        btnIngresar.add(btnTxtIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 440, 40));

        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 460, 40));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarVentaMouseClicked

    }//GEN-LAST:event_btnFinalizarVentaMouseClicked

    private void fechaFinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaFinFocusGained
        if (fechaFin.getText().equals("Nombre Producto")) {
            fechaFin.setText("");
        }
    }//GEN-LAST:event_fechaFinFocusGained

    private void fechaFinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaFinFocusLost
        if (fechaFin.getText().trim().isEmpty()) {
            fechaFin.setText("Nombre Producto");
        }
    }//GEN-LAST:event_fechaFinFocusLost

    private void fechaFinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaFinKeyReleased

    }//GEN-LAST:event_fechaFinKeyReleased

    private void fechaFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaFinKeyTyped

    }//GEN-LAST:event_fechaFinKeyTyped

    private void inputTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTelefonoFocusGained
        if (inputTelefono.getText().equals("Telefono")) {
            inputTelefono.setText("");
        }
    }//GEN-LAST:event_inputTelefonoFocusGained

    private void inputTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTelefonoFocusLost
        if (inputTelefono.getText().trim().isEmpty()) {
            inputTelefono.setText("Telefono");
        }
    }//GEN-LAST:event_inputTelefonoFocusLost

    private void inputTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTelefonoKeyReleased

    private void inputTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoKeyTyped
        char c = evt.getKeyChar();
        // Solo permite números (0-9) y retroceso
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Ignora la entrada si no es válida
        }
    }//GEN-LAST:event_inputTelefonoKeyTyped

    private void inputTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTelefonoActionPerformed

    private void inputNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNombreFocusGained
        if (inputNombre.getText().equals("Nombre")) {
            inputNombre.setText("");
        }
    }//GEN-LAST:event_inputNombreFocusGained

    private void inputNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNombreFocusLost
        if (inputNombre.getText().trim().isEmpty()) {
            inputNombre.setText("Nombre");
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
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreKeyTyped

    private void fechaInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioFocusGained

    private void fechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaInicioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioFocusLost

    private void fechaInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaInicioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioKeyReleased

    private void fechaInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaInicioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioKeyTyped

    private void fechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioActionPerformed

    private void btnTxtIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtIngresarMouseClicked
        app.mostrarPantallaDetallesHistorialDevolucion();
    }//GEN-LAST:event_btnTxtIngresarMouseClicked

    private void fechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFinActionPerformed

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaMenuDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnFinalizarVenta;
    private GUI.PanelRound btnIngresar;
    private javax.swing.JLabel btnTxtIngresar;
    private javax.swing.JTextField fechaFin;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtBusquedaNombre1;
    private javax.swing.JLabel txtBusquedaNombre2;
    private javax.swing.JLabel txtBusquedaNombre3;
    private javax.swing.JLabel txtBusquedaNombre4;
    private javax.swing.JLabel txtPanelVentaEnCaja;
    // End of variables declaration//GEN-END:variables
}
