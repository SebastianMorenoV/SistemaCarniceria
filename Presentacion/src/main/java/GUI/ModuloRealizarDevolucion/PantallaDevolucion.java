package GUI.ModuloRealizarDevolucion;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import Exception.DevolucionException;
import GUI.Aplicacion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian Moreno
 */
public class PantallaDevolucion extends javax.swing.JPanel {

    Aplicacion app;
    private double totalAcumulado = 0.0;
    private List<ProductoVentaDTO> productosEnTabla = new ArrayList<>();
    private List<ProductoVentaDTO> productosDevueltos = new ArrayList<>();
    private VentaDTO venta = null;

    public PantallaDevolucion(Aplicacion app) {
        this.app = app;
        initComponents();
        valoresIniciales();
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
        tablaProductosDevolucion = new javax.swing.JTable();
        pnlFinalizar = new GUI.PanelRound();
        btnTxtFinalizarVenta1 = new javax.swing.JLabel();
        pnlCancelarD = new GUI.PanelRound();
        btnTxtFinalizarVenta2 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        txtBusquedaNombre6 = new javax.swing.JLabel();
        txtTotalParcial = new javax.swing.JLabel();
        icnBasura = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPanelVentaEnCaja.setBackground(new java.awt.Color(0, 0, 0));
        txtPanelVentaEnCaja.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtPanelVentaEnCaja.setText("Devolución");
        add(txtPanelVentaEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 270, -1));

        txtBusquedaNombre1.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        txtBusquedaNombre1.setText("Venta:");
        add(txtBusquedaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 80, 30));

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

        txtBusquedaNombre2.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
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
        });
        add(inputRazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 570, 50));

        txtBusquedaNombre3.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        txtBusquedaNombre3.setText("Productos devueltos.*:");
        add(txtBusquedaNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 280, 30));

        inputProductosDevueltos.setEditable(false);
        inputProductosDevueltos.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputProductosDevueltos.setText("Seleccionar productos");
        inputProductosDevueltos.setToolTipText("Selecciona los productos en la tabla de Venta que se desean devolver.");
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
        add(inputProductosDevueltos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 570, 50));

        txtBusquedaNombre4.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
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
        add(txtBusquedaNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1100, 30));

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

        tablaProductosDevolucion.setBackground(new java.awt.Color(187, 187, 187));
        tablaProductosDevolucion.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        tablaProductosDevolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productos", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductosDevolucion.setToolTipText("Selecciona los productos que se desean devolver");
        tablaProductosDevolucion.setRowHeight(18);
        tablaProductosDevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosDevolucionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductosDevolucion);

        btnFinalizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 330));

        add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 300, 360));

        pnlFinalizar.setBackground(new java.awt.Color(44, 44, 44));
        pnlFinalizar.setRoundBottomLeft(15);
        pnlFinalizar.setRoundBottomRight(15);
        pnlFinalizar.setRoundTopLeft(15);
        pnlFinalizar.setRoundTopRight(15);
        pnlFinalizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtFinalizarVenta1.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        btnTxtFinalizarVenta1.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtFinalizarVenta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtFinalizarVenta1.setText("Finalizar");
        btnTxtFinalizarVenta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtFinalizarVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtFinalizarVenta1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtFinalizarVenta1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtFinalizarVenta1MouseExited(evt);
            }
        });
        pnlFinalizar.add(btnTxtFinalizarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 70));

        add(pnlFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 370, 70));

        pnlCancelarD.setBackground(new java.awt.Color(44, 44, 44));
        pnlCancelarD.setRoundBottomLeft(15);
        pnlCancelarD.setRoundBottomRight(15);
        pnlCancelarD.setRoundTopLeft(15);
        pnlCancelarD.setRoundTopRight(15);
        pnlCancelarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCancelarDMouseClicked(evt);
            }
        });
        pnlCancelarD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtFinalizarVenta2.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        btnTxtFinalizarVenta2.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtFinalizarVenta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtFinalizarVenta2.setText("Cancelar Devolucion");
        btnTxtFinalizarVenta2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtFinalizarVenta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtFinalizarVenta2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtFinalizarVenta2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtFinalizarVenta2MouseExited(evt);
            }
        });
        pnlCancelarD.add(btnTxtFinalizarVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 70));

        add(pnlCancelarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 370, 70));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        txtBusquedaNombre6.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        txtBusquedaNombre6.setText("Nombre Completo.*:");
        add(txtBusquedaNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 280, 30));

        txtTotalParcial.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        txtTotalParcial.setText("Total a devolver : $ 0.00");
        add(txtTotalParcial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, 360, 30));

        icnBasura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bote-de-basura.png"))); // NOI18N
        icnBasura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icnBasura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icnBasuraMouseClicked(evt);
            }
        });
        add(icnBasura, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));
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

    private void pnlCancelarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCancelarDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlCancelarDMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaTicketDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void tablaProductosDevolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosDevolucionMouseClicked
        if (evt.getClickCount() == 2) { // Doble clic
            int respuesta = app.mostrarPreguntaAñadirProducto();
            if (respuesta == JOptionPane.YES_OPTION) { // tambien mandar a abrir jOptionPanes desde aplicacion.
                seleccionarProducto(); // Llama al método al doble clic --- aqui necesito quitar el producto de la lista local

            } else {
                // Limpiar la selección
                tablaProductosDevolucion.getSelectionModel().clearSelection();
            }
        }
    }//GEN-LAST:event_tablaProductosDevolucionMouseClicked

    private void icnBasuraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icnBasuraMouseClicked
        resetearDevolucion();
    }//GEN-LAST:event_icnBasuraMouseClicked

    private void btnTxtFinalizarVenta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtFinalizarVenta2MouseClicked
        app.mostrarPantallaTicketDevolucion();
    }//GEN-LAST:event_btnTxtFinalizarVenta2MouseClicked

    private void btnTxtFinalizarVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtFinalizarVenta1MouseClicked
        try {
            registrarDevolucion();
            
        } catch (DevolucionException ex) {
            Logger.getLogger(PantallaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTxtFinalizarVenta1MouseClicked

    private void inputRazonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputRazonKeyReleased

    }//GEN-LAST:event_inputRazonKeyReleased

    private void btnTxtFinalizarVenta2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtFinalizarVenta2MouseEntered
          pnlCancelarD.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_btnTxtFinalizarVenta2MouseEntered

    private void btnTxtFinalizarVenta2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtFinalizarVenta2MouseExited
          pnlCancelarD.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_btnTxtFinalizarVenta2MouseExited

    private void btnTxtFinalizarVenta1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtFinalizarVenta1MouseEntered
          pnlFinalizar.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_btnTxtFinalizarVenta1MouseEntered

    private void btnTxtFinalizarVenta1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtFinalizarVenta1MouseExited
          pnlFinalizar.setBackground(new Color(0,0,0));
    }//GEN-LAST:event_btnTxtFinalizarVenta1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnFinalizarVenta;
    private javax.swing.JLabel btnTxtFinalizarVenta1;
    private javax.swing.JLabel btnTxtFinalizarVenta2;
    private javax.swing.JLabel icnBasura;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputProductosDevueltos;
    private javax.swing.JTextField inputRazon;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.PanelRound pnlCancelarD;
    private GUI.PanelRound pnlFinalizar;
    private javax.swing.JTable tablaProductosDevolucion;
    private javax.swing.JLabel txtBusquedaNombre1;
    private javax.swing.JLabel txtBusquedaNombre2;
    private javax.swing.JLabel txtBusquedaNombre3;
    private javax.swing.JLabel txtBusquedaNombre4;
    private javax.swing.JLabel txtBusquedaNombre5;
    private javax.swing.JLabel txtBusquedaNombre6;
    private javax.swing.JLabel txtPanelVentaEnCaja;
    private javax.swing.JLabel txtTotalParcial;
    // End of variables declaration//GEN-END:variables

//Metodos auxiliares:
    public void registrarDevolucion() throws DevolucionException {
        String nombre = inputNombre.getText().trim();
        String razon = inputRazon.getText().trim();
        String telefono = inputTelefono.getText().trim();

        // Validar que los campos no estén vacíos ni contengan solo el texto por defecto
        if (nombre.isEmpty() || nombre.equals("Nombre completo")
                || razon.isEmpty() || razon.equals("Razon")
                || telefono.isEmpty() || telefono.equals("Ingresar numero telefonico.")
                || productosDevueltos == null || productosDevueltos.isEmpty()
                || venta == null) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, completa todos los campos requeridos y asegúrate de haber agregado productos devueltos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        EmpleadoCargadoDTO empleado = new EmpleadoCargadoDTO("Miguelito", "Cajero");
        CrearDevolucionDTO devolucionDTO = new CrearDevolucionDTO();
        devolucionDTO.setNombreCompleto(nombre);
        devolucionDTO.setRazon(razon);
        devolucionDTO.setCajeroDevolucion(empleado);
        devolucionDTO.setProductosDevueltos(productosDevueltos);
        devolucionDTO.setTelefono(telefono);
        devolucionDTO.setFechaHora(LocalDateTime.now());
        devolucionDTO.setMontoDevuelto(totalAcumulado);
        devolucionDTO.setVenta(venta);

        try {
            DevolucionDTO dto = app.registrarDevolucion(devolucionDTO);
            if (dto != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy - HH:mm");
                String fechaFormateada = dto.getFechaHora().format(formatter);

                String mensaje = "<html>"
                        + "<h2 style='color:green;'>Devolución exitosa</h2>"
                        + "<p>" + fechaFormateada + "</p>"
                        + "<p><strong>Motivo o Razón:</strong> " + dto.getRazon() + "</p>"
                        + "<p><strong>Total a regresar:</strong> $" + String.format("%.2f", dto.getMontoDevuelto()) + "</p>"
                        + "</html>";

                JOptionPane.showMessageDialog(null, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);

                app.mostrarPantallaMenuDevolucion();
            }
        } catch (DevolucionException ex) {
            String mensajeError = "<html>"
                    + "<h2 style='color:red;'>Error al registrar la devolución</h2>"
                    + "<p>" + ex.getMessage() + "</p>"
                    + "</html>";

            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void valoresIniciales() {
        icnBasura.setVisible(false);
        cargarTabla();
        cargarTextos();
        ajustarTamañoColumnasPreferidos();
    }

    public void cargarTextos() {
        VentaDTO venta = app.getVentaEncontradaTicket();
        txtBusquedaNombre5.setText("Venta encontrada con el numero de folio: " + String.valueOf(venta.getId()));
    }

    public void cargarTabla() {
        venta = app.getVentaEncontradaTicket();
        DefaultTableModel model = (DefaultTableModel) tablaProductosDevolucion.getModel();
        model.setRowCount(0);
        productosEnTabla.clear(); // Limpia lista auxiliar

        for (ProductoVentaDTO producto : venta.getListadoProductosVenta()) {
            Object[] fila = new Object[]{
                producto.getProducto().getNombre(),
                producto.getImporte()
            };
            model.addRow(fila);
            productosEnTabla.add(producto); // Guarda referencia
        }
    }

    public void resetearDevolucion() {
        inputProductosDevueltos.setText("Seleccionar productos");
        txtTotalParcial.setText("Total a devolver : $ 0.00");
        cargarTabla();
        icnBasura.setVisible(false);
    }

    public void seleccionarProducto() {
        DefaultTableModel model = (DefaultTableModel) tablaProductosDevolucion.getModel();
        int filaSeleccionada = tablaProductosDevolucion.getSelectedRow();

        if (filaSeleccionada != -1) {
            ProductoVentaDTO productoSeleccionado = productosEnTabla.get(filaSeleccionada);
            double precio = productoSeleccionado.getImporte();

            model.removeRow(filaSeleccionada);
            productosEnTabla.remove(filaSeleccionada); // Quita también de la lista

            if (inputProductosDevueltos.getText().equals("Seleccionar productos")) {
                inputProductosDevueltos.setText("");
                totalAcumulado = 0.0;
                productosDevueltos.clear();
            }

            String textoActual = inputProductosDevueltos.getText();
            if (!textoActual.isEmpty()) {
                textoActual += ", ";
            }

            inputProductosDevueltos.setText(textoActual + productoSeleccionado.getProducto().getNombre());

            icnBasura.setVisible(true);
            totalAcumulado += precio;
            txtTotalParcial.setText("Total a devolver: $" + String.format("%.2f", totalAcumulado));

            // Agrega a la lista de productos devueltos
            productosDevueltos.add(productoSeleccionado);
        }
    }

    public void ajustarTamañoColumnasPreferidos() {
        tablaProductosDevolucion.getColumnModel().getColumn(0).setPreferredWidth(200);  // Nombre Producto
        tablaProductosDevolucion.getColumnModel().getColumn(1).setPreferredWidth(80); // Precio
    }

}
