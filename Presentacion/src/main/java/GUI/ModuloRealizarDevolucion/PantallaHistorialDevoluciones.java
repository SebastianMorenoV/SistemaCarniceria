package GUI.ModuloRealizarDevolucion;

import DTOs.FechaDTO;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import DTOs.ProductoVentaDTO;
import Exception.DevolucionException;
import GUI.Aplicacion;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian Moreno
 */
public class PantallaHistorialDevoluciones extends javax.swing.JPanel {

    private Aplicacion app;
    List<DevolucionDTO> devolucionesFiltradas = new ArrayList<>(); // lista local.

    public PantallaHistorialDevoluciones(Aplicacion app) {
        this.app = app;
        initComponents();
        incializarValoresDefault();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizarVenta = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDevoluciones = new javax.swing.JTable();
        inputTelefono = new javax.swing.JTextField();
        inputNombre = new javax.swing.JTextField();
        txtBusquedaNombre1 = new javax.swing.JLabel();
        txtBusquedaNombre2 = new javax.swing.JLabel();
        txtBusquedaNombre3 = new javax.swing.JLabel();
        txtBusquedaNombre4 = new javax.swing.JLabel();
        txtPanelVentaEnCaja = new javax.swing.JLabel();
        btnIngresar = new GUI.PanelRound();
        btnTxtIngresar = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        inputFechaInicio = new com.toedter.calendar.JDateChooser();
        inputFechaFin = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFinalizarVenta.setBackground(new java.awt.Color(187, 187, 187));
        btnFinalizarVenta.setRoundBottomLeft(15);
        btnFinalizarVenta.setRoundBottomRight(15);
        btnFinalizarVenta.setRoundTopLeft(15);
        btnFinalizarVenta.setRoundTopRight(15);
        btnFinalizarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDevoluciones.setBackground(new java.awt.Color(187, 187, 187));
        tablaDevoluciones.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo reembolso", "Articulos Reembolsados", "Razon", "Fecha", "Cliente", "Total Regresado", "Detalles"
            }
        ));
        tablaDevoluciones.setRowHeight(24);
        jScrollPane1.setViewportView(tablaDevoluciones);

        btnFinalizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 340));

        add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 1010, 360));

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
        inputTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNombreKeyTyped(evt);
            }
        });
        add(inputNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 270, 50));

        txtBusquedaNombre1.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre1.setText("Fecha Fin:");
        add(txtBusquedaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 230, 30));

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
        add(inputFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 240, 50));
        add(inputFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 220, 50));
    }// </editor-fold>//GEN-END:initComponents

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

    private void inputTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTelefonoKeyTyped
        char c = evt.getKeyChar();
        // Solo permite números (0-9) y retroceso
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Ignora la entrada si no es válida
        }
    }//GEN-LAST:event_inputTelefonoKeyTyped

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

    private void inputNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreKeyTyped

    private void btnTxtIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtIngresarMouseClicked

        try {
            buscarDevolucionPorFiltro();
        } catch (DevolucionException ex) {
            Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnTxtIngresarMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaMenuDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnFinalizarVenta;
    private GUI.PanelRound btnIngresar;
    private javax.swing.JLabel btnTxtIngresar;
    private com.toedter.calendar.JDateChooser inputFechaFin;
    private com.toedter.calendar.JDateChooser inputFechaInicio;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDevoluciones;
    private javax.swing.JLabel txtBusquedaNombre1;
    private javax.swing.JLabel txtBusquedaNombre2;
    private javax.swing.JLabel txtBusquedaNombre3;
    private javax.swing.JLabel txtBusquedaNombre4;
    private javax.swing.JLabel txtPanelVentaEnCaja;
    // End of variables declaration//GEN-END:variables

    public void buscarDevolucionPorFiltro() throws DevolucionException {
        String nombre = inputNombre.getText();
        String telefono = inputTelefono.getText();

        // DTO con los datos de filtro
        DevolucionSinVentaDTO devolucionDTO = new DevolucionSinVentaDTO();
        devolucionDTO.setTelefono(telefono);
        devolucionDTO.setNombreCompleto(nombre);

        // Obtener fechas desde los JDateChooser
        Date fechaInicioDate = inputFechaInicio.getDate();
        Date fechaFinDate = inputFechaFin.getDate();

        if (fechaInicioDate == null || fechaFinDate == null) {
            throw new DevolucionException("Debe seleccionar ambas fechas: inicio y fin.");
        }

        LocalDateTime fechaInicio = fechaInicioDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime fechaFin = fechaFinDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        devolucionDTO.setFechaInicio(fechaInicio);
        devolucionDTO.setFechaFin(fechaFin);

        try {
            devolucionesFiltradas = app.buscarDevolucionPorFiltro(devolucionDTO);
            llenarTabla();
        } catch (DevolucionException ex) {
            throw new DevolucionException("Existió un error consultando la base de datos: " + ex.getLocalizedMessage());
        }
    }

    public void llenarTabla() {
        DefaultTableModel model = (DefaultTableModel) tablaDevoluciones.getModel();
        model.setRowCount(0);

        for (DevolucionDTO devolucion : devolucionesFiltradas) {
            String nombresProductos = devolucion.getProductosDevueltos()
                    .stream()
                    .map(pv -> pv.getProducto().getNombre())
                    .collect(Collectors.joining(", "));

            Object[] fila = new Object[]{
                devolucion.getId(),
                nombresProductos,
                devolucion.getRazon(),
                devolucion.getFechaHora(),
                devolucion.getNombreCompleto(),
                devolucion.getMontoDevuelto(),
                "Detalles"
            };
            model.addRow(fila);
        }

        // Configurar el botón solo una vez
        if (tablaDevoluciones.getColumn("Detalles") != null
                && !(tablaDevoluciones.getColumn("Detalles").getCellRenderer() instanceof ButtonRenderer)) {

            tablaDevoluciones.getColumn("Detalles").setCellRenderer(new ButtonRenderer());
            tablaDevoluciones.getColumn("Detalles").setCellEditor(new ButtonEditor(tablaDevoluciones));
        }
    }

    public void ajustarTamañoColumnasPreferidos() {
        tablaDevoluciones.getColumnModel().getColumn(0).setPreferredWidth(40);  // Código
        tablaDevoluciones.getColumnModel().getColumn(1).setPreferredWidth(280); // Descripción del artículo
        tablaDevoluciones.getColumnModel().getColumn(2).setPreferredWidth(150);  // Cantidad
        tablaDevoluciones.getColumnModel().getColumn(3).setPreferredWidth(100);  // Precio
        tablaDevoluciones.getColumnModel().getColumn(4).setPreferredWidth(80);  // Importe
        tablaDevoluciones.getColumnModel().getColumn(4).setPreferredWidth(80);  // Importe
        tablaDevoluciones.getColumnModel().getColumn(4).setPreferredWidth(50);  // Importe
    }
    
    
    public void incializarValoresDefault(){
      inputFechaInicio.setDate(new Date());
      inputFechaFin.setDate(new Date());
        ajustarTamañoColumnasPreferidos();
    }
    // Dentro de tu clase del formulario (por ejemplo: public class RealizarDevolucion extends JFrame { ... })
    private class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            setText("Detalles");
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {

        private JButton button;
        private JTable table;

        public ButtonEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;
            button = new JButton("Detalles");
            button.setOpaque(true);
            button.addActionListener(e -> {
                fireEditingStopped();
                int row = table.getSelectedRow();
                Object id = table.getValueAt(row, 0); // Ajusta si tu ID está en otra columna
                try {
                    DevolucionDTO devolucionDTO = app.buscarDevolucionPorID(id.toString());
                    app.setDevolucionTemporal(devolucionDTO);
                    app.mostrarPantallaDetallesHistorialDevolucion();
                } catch (DevolucionException ex) {
                    Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }

        public Object getCellEditorValue() {
            return "Detalles";
        }
    }

}
