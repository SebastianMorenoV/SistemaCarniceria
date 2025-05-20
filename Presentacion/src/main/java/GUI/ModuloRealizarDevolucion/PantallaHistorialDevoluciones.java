package GUI.ModuloRealizarDevolucion;

import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import Exception.DevolucionException;
import GUI.Aplicacion;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
        btnAtras = new javax.swing.JLabel();
        inputFechaInicio = new com.toedter.calendar.JDateChooser();
        inputFechaFin = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFinalizarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnFinalizarVenta.setRoundBottomLeft(15);
        btnFinalizarVenta.setRoundBottomRight(15);
        btnFinalizarVenta.setRoundTopLeft(15);
        btnFinalizarVenta.setRoundTopRight(15);
        btnFinalizarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDevoluciones.setBackground(new java.awt.Color(255, 255, 255));
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

        btnFinalizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1040, 360));

        add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1060, 420));

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
        txtBusquedaNombre2.setText("Teléfono Cliente : ");
        add(txtBusquedaNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 230, 30));

        txtBusquedaNombre3.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre3.setText("Nombre Cliente :");
        add(txtBusquedaNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 230, 30));

        txtBusquedaNombre4.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtBusquedaNombre4.setText("Fecha Inicio:");
        add(txtBusquedaNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 230, 30));

        txtPanelVentaEnCaja.setBackground(new java.awt.Color(0, 0, 0));
        txtPanelVentaEnCaja.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtPanelVentaEnCaja.setText("Historial de Devoluciónes");
        add(txtPanelVentaEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 540, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        inputFechaInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inputFechaInicioPropertyChange(evt);
            }
        });
        add(inputFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 240, 50));

        inputFechaFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inputFechaFinPropertyChange(evt);
            }
        });
        add(inputFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 220, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void inputTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTelefonoFocusGained
        if (inputTelefono.getText().equals("Telefono")) {
            inputTelefono.setText("");
            inputNombre.setText("");
        }
    }//GEN-LAST:event_inputTelefonoFocusGained

    private void inputTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTelefonoFocusLost
        if (inputTelefono.getText().trim().isEmpty()) {
            inputTelefono.setText("");

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
            inputNombre.setText("");
        }
    }//GEN-LAST:event_inputNombreFocusLost

    private void inputNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreKeyTyped

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaMenuDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void inputFechaInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inputFechaInicioPropertyChange
        try {
            buscarDevolucionPorFiltro();
        } catch (DevolucionException ex) {
            Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inputFechaInicioPropertyChange

    private void inputFechaFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inputFechaFinPropertyChange
        try {
            buscarDevolucionPorFiltro();
        } catch (DevolucionException ex) {
            Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inputFechaFinPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnFinalizarVenta;
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

    private void agregarDocumentListener(JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    buscarDevolucionPorFiltro();
                } catch (DevolucionException ex) {
                    Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    buscarDevolucionPorFiltro();
                } catch (DevolucionException ex) {
                    Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    buscarDevolucionPorFiltro();
                } catch (DevolucionException ex) {
                    Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void buscarDevolucionPorFiltro() throws DevolucionException {
        String nombre = inputNombre.getText();
        String telefono = inputTelefono.getText();

        if ("Nombre".equals(nombre)) {
            nombre = null;
        }
        if ("Telefono".equals(telefono)) {
            telefono = null;
        }

        DevolucionSinVentaDTO filtroDTO = new DevolucionSinVentaDTO();
        filtroDTO.setNombreCompleto(nombre);
        filtroDTO.setTelefono(telefono);

        Date fechaInicioDate = inputFechaInicio.getDate();
        Date fechaFinDate = inputFechaFin.getDate();

        ZoneId zona = ZoneId.systemDefault();
        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFin = null;

        if (fechaInicioDate == null && fechaFinDate == null) {
            // Asumimos que quiere buscar por el día de hoy
            LocalDate hoy = LocalDate.now(zona);
            fechaInicio = hoy.atStartOfDay();
            fechaFin = hoy.atTime(LocalTime.MAX).withNano(999_000_000);
        } else {
            if (fechaInicioDate != null) {
                LocalDate fechaInicioLocalDate = fechaInicioDate.toInstant().atZone(zona).toLocalDate();
                fechaInicio = fechaInicioLocalDate.atStartOfDay();
            }

            if (fechaFinDate != null) {
                LocalDate fechaFinLocalDate = fechaFinDate.toInstant().atZone(zona).toLocalDate();
                fechaFin = fechaFinLocalDate.atTime(LocalTime.MAX).withNano(999_000_000);
            }
        }

        filtroDTO.setFechaInicio(fechaInicio);
        filtroDTO.setFechaFin(fechaFin);

        try {
            devolucionesFiltradas = app.buscarDevolucionPorFiltro(filtroDTO);
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
                formatearFecha(devolucion.getFechaHora()),
                devolucion.getNombreCompleto(),
                "$" + devolucion.getMontoDevuelto(),
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
        tablaDevoluciones.getColumnModel().getColumn(0).setPreferredWidth(70);
        tablaDevoluciones.getColumnModel().getColumn(1).setPreferredWidth(200);
        tablaDevoluciones.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaDevoluciones.getColumnModel().getColumn(3).setPreferredWidth(120);
        tablaDevoluciones.getColumnModel().getColumn(4).setPreferredWidth(120);
        tablaDevoluciones.getColumnModel().getColumn(5).setPreferredWidth(50);
        tablaDevoluciones.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    public void incializarValoresDefault() {

        ajustarTamañoColumnasPreferidos();
        try {
            buscarDevolucionPorFiltro();
        } catch (DevolucionException ex) {
            Logger.getLogger(PantallaHistorialDevoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarDocumentListener(inputNombre);
        agregarDocumentListener(inputTelefono);
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
     private String formatearFecha(LocalDateTime fecha) {
        if (fecha == null) {
            return "No disponible";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fecha.format(formatter);
    }

}
