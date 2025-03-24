/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DTOs.NuevoProductoVentaDTO;
import DTOs.ventaDTO;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class vistaTicketPDF extends javax.swing.JPanel {
    protected ventaDTO venta;
    /**
     * Creates new form vistaTicketPDF
     */
    public vistaTicketPDF(ventaDTO venta) {
        initComponents();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ticket.setAlignmentX(CENTER_ALIGNMENT);
        campoCarniceria.setAlignmentX(CENTER_ALIGNMENT);
        campoEmpleado.setAlignmentX(CENTER_ALIGNMENT);
        campoFechaVenta.setAlignmentX(CENTER_ALIGNMENT);
        
        this.venta = venta;
        generarTicketVenta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ticket = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        campoCarniceria = new javax.swing.JLabel();
        campoFechaVenta = new javax.swing.JLabel();
        campoEmpleado = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        ticket.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ticket.setText("Ticket de Compra");
        add(ticket);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);

        campoCarniceria.setText("Carniceria");
        add(campoCarniceria);

        campoFechaVenta.setText("jLabel3");
        add(campoFechaVenta);

        campoEmpleado.setText("jLabel1");
        add(campoEmpleado);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campoCarniceria;
    private javax.swing.JLabel campoEmpleado;
    private javax.swing.JLabel campoFechaVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel ticket;
    // End of variables declaration//GEN-END:variables

    public void generarTicketVenta(){
        String columnasTabla[] = {"Producto","cantidad","total"};
        campoEmpleado.setText(venta.getEmpleado().getNombre());
        campoFechaVenta.setText(venta.getFechaHora().toString());
        DefaultTableModel modelo = new DefaultTableModel(columnasTabla, 0);
       
        for(NuevoProductoVentaDTO producto : venta.getListadoProductosVenta()){
            modelo.addRow(new Object[]{producto.getProducto().getNombre(), producto.getCantidad(),producto.getCantidad()*producto.getImporte()});  
        }
        jTable1.setModel(modelo);
        jTable1.setVisible(true);
        jScrollPane1.add(jTable1);
        this.add(jScrollPane1);
       
    }
    public double calcularSubtotal(ArrayList<NuevoProductoVentaDTO> productosEnTabla) {
        double subtotal = 0.0;
        for (NuevoProductoVentaDTO nuevoProductoVentaDTO : productosEnTabla) {
            double precioConIva = nuevoProductoVentaDTO.getImporte();
            subtotal += precioConIva / 1.16; // Quitar el IVA para obtener el subtotal
        }
        return subtotal;
    }
     
    public double calcularIva(double subtotal) {
        return subtotal * 0.16; // 16% de IVA
    }

    
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}
