/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ModuloRealizarDevolucion;

import DTOs.Devolucion.DevolucionDTO;
import DTOs.ProductoVentaDTO;
import GUI.Aplicacion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lap-064
 */
public class PantallaDetallesHistorialDevolucion extends javax.swing.JPanel {

    Aplicacion app;

    public PantallaDetallesHistorialDevolucion(Aplicacion app) {
        this.app = app;
        initComponents();
        inicializarValores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPanelVentaEnCaja = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JLabel();
        txtVentaTitulo = new javax.swing.JLabel();
        btnFinalizarVenta = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductosDevueltos = new javax.swing.JTable();
        txtDevolucion = new javax.swing.JLabel();
        txtFechaCompra = new javax.swing.JLabel();
        txtMetodoPago = new javax.swing.JLabel();
        txtCajeroVenta = new javax.swing.JLabel();
        txtCajeroDevolucion = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        txtFechaDevolucion = new javax.swing.JLabel();
        txtMontoDevolucion = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPanelVentaEnCaja.setBackground(new java.awt.Color(0, 0, 0));
        txtPanelVentaEnCaja.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtPanelVentaEnCaja.setText("Detalles Devolucion");
        add(txtPanelVentaEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 430, -1));

        txtMotivo.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtMotivo.setText("Motivo:");
        add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 400, 30));

        txtVentaTitulo.setFont(new java.awt.Font("Product Sans Infanity", 1, 26)); // NOI18N
        txtVentaTitulo.setText("Venta ");
        add(txtVentaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 80, 30));

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

        tablaProductosDevueltos.setBackground(new java.awt.Color(187, 187, 187));
        tablaProductosDevueltos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productos", "Cantidad", "Precio Unitario", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tablaProductosDevueltos);

        btnFinalizarVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 410));

        add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 650, 410));

        txtDevolucion.setFont(new java.awt.Font("Product Sans Infanity", 1, 26)); // NOI18N
        txtDevolucion.setText("Devolucion");
        add(txtDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 140, 30));

        txtFechaCompra.setFont(new java.awt.Font("Product Sans Infanity", 0, 14)); // NOI18N
        txtFechaCompra.setText("Fecha Compra : ");
        add(txtFechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 290, 30));

        txtMetodoPago.setFont(new java.awt.Font("Product Sans Infanity", 0, 14)); // NOI18N
        txtMetodoPago.setText("Metodo Pago :  ");
        add(txtMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 290, 30));

        txtCajeroVenta.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtCajeroVenta.setText("Cajero:");
        add(txtCajeroVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 270, 30));

        txtCajeroDevolucion.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtCajeroDevolucion.setText("Cajero:");
        add(txtCajeroDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 270, 30));

        txtCliente.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtCliente.setText("Cliente:");
        add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 270, 40));

        txtFechaDevolucion.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtFechaDevolucion.setText("Fecha devolucion:");
        add(txtFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 400, 30));

        txtMontoDevolucion.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtMontoDevolucion.setText("Monto devolucion:");
        add(txtMontoDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 400, 30));

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

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaHistorialDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnFinalizarVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductosDevueltos;
    private javax.swing.JLabel txtCajeroDevolucion;
    private javax.swing.JLabel txtCajeroVenta;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtDevolucion;
    private javax.swing.JLabel txtFechaCompra;
    private javax.swing.JLabel txtFechaDevolucion;
    private javax.swing.JLabel txtMetodoPago;
    private javax.swing.JLabel txtMontoDevolucion;
    private javax.swing.JLabel txtMotivo;
    private javax.swing.JLabel txtPanelVentaEnCaja;
    private javax.swing.JLabel txtVentaTitulo;
    // End of variables declaration//GEN-END:variables

    public void inicializarValores() {
        cargarTextos();
        cargarTabla();

    }

    private String formatearFecha(LocalDateTime fecha) {
        if (fecha == null) {
            return "No disponible";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fecha.format(formatter);
    }

    private void cargarTextos() {
        DevolucionDTO devolucionDTO = app.getDevolucionTemporal();

        // Asegúrate de que devolucionDTO no sea null
        if (devolucionDTO == null || devolucionDTO.getVenta() == null) {
            System.out.println("No se encontró información de devolución.");
            return;
        }

        // Cajero
        String nombreCajero = devolucionDTO.getVenta().getEmpleado() != null
                ? devolucionDTO.getVenta().getEmpleado().getNombre()
                : "No disponible";
        txtCajeroDevolucion.setText("Cajero: " + nombreCajero);

        // Cliente
        txtCliente.setText("Cliente: " + devolucionDTO.getNombreCompleto());

        // Fecha de compra
        LocalDateTime fechaCompra = devolucionDTO.getVenta().getFechaHora();
        txtFechaCompra.setText("Fecha de compra: " + formatearFecha(fechaCompra));

        // Fecha de devolución
        LocalDateTime fechaDevolucion = devolucionDTO.getFechaHora();
        txtFechaDevolucion.setText("Fecha de devolución: " + formatearFecha(fechaDevolucion));

        String metodoPago = "No disponible";

        if (devolucionDTO.getVenta() != null
                && devolucionDTO.getVenta().getMetodoPago() != null
                && devolucionDTO.getVenta().getMetodoPago().getNuevaTarjeta() != null) {

            metodoPago = devolucionDTO.getVenta().getMetodoPago().getNuevaTarjeta().toString();
        }

        txtMetodoPago.setText("Método de pago: " + metodoPago);

        // Monto devuelto
        txtMontoDevolucion.setText("Monto devuelto: $" + devolucionDTO.getMontoDevuelto());

        // Motivo
        txtMotivo.setText("Motivo: " + devolucionDTO.getRazon());
    }

    public void cargarTabla() {
        DevolucionDTO devolucionDTO = app.getDevolucionTemporal();

        DefaultTableModel model = (DefaultTableModel) tablaProductosDevueltos.getModel();
        model.setRowCount(0);

        List<ProductoVentaDTO> productosDevueltos = devolucionDTO.getProductosDevueltos();

        for (ProductoVentaDTO productoDevuelto : productosDevueltos) {
            Object[] fila = new Object[]{
                productoDevuelto.getProducto().getNombre() + "" + productoDevuelto.getProducto().getDescripcion(),
                productoDevuelto.getCantidad(),
                productoDevuelto.getPrecioUnitario(),
                productoDevuelto.getImporte(),};
            model.addRow(fila);
        }

    }
}
