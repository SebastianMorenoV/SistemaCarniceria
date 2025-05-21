/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ModuloRegistrarEntrada;


import DTOs.ProductoCargadoDTO;
import Exception.InventarioException;
import Exception.NegocioException;
import GUI.Aplicacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class SeleccionarProducto extends javax.swing.JPanel {
    private Aplicacion control;
    private double unidades, precioCompra;
    private ProductoCargadoDTO productoSeleccionado;
    /**
     * 
     * @param control
     */
    public SeleccionarProducto(Aplicacion control) throws NegocioException {
        this.control = control;
        initComponents();        
        crearTablaProductos();
        this.setAlignmentY(tablaProductos.CENTER_ALIGNMENT);  
        this.revalidate();
        this.repaint();
        setVisible(true);
    }
    public void crearTablaProductos() throws NegocioException{
        String columnasTabla[] = {"ID","Nombre","Descripcion"};
        tablaProductos.setRowHeight(25);
        DefaultTableModel modelo = new DefaultTableModel(columnasTabla, 0){
            @Override
            public boolean  isCellEditable(int fila, int columna){
                return false;
            }                    
        }; 
        try {
            for(ProductoCargadoDTO producto : control.cargarProductosCE()){
                modelo.addRow(new Object[]{
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getDescripcion()
                }
                );
            }
        } catch (InventarioException ex) {
            Logger.getLogger(SeleccionarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablaProductos.setModel(modelo);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.getTableHeader().setResizingAllowed(false);   
        scrollTablaProductos.setViewportView(tablaProductos);

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panaelTitulo = new javax.swing.JPanel();
        labelSeleccionProv = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        labelProveedor = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        labelIndicaciones = new javax.swing.JLabel();
        panelTablaProductos = new javax.swing.JPanel();
        scrollTablaProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        BtnAgregarProducto = new javax.swing.JButton();

        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(650, 670));
        setPreferredSize(new java.awt.Dimension(650, 670));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panaelTitulo.setMaximumSize(new java.awt.Dimension(600, 75));
        panaelTitulo.setPreferredSize(new java.awt.Dimension(600, 75));
        panaelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSeleccionProv.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        labelSeleccionProv.setText("Seleccion de Producto");
        panaelTitulo.add(labelSeleccionProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 6, -1, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        panaelTitulo.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        add(panaelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 640, 68));

        panelBusqueda.setMaximumSize(new java.awt.Dimension(650, 120));
        panelBusqueda.setPreferredSize(new java.awt.Dimension(650, 120));

        labelProveedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelProveedor.setText("Buscar Producto:");

        campoBusqueda.setMaximumSize(new java.awt.Dimension(200, 75));

        labelIndicaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelIndicaciones.setText("**Puedes buscar por ID o nombre de producto**");

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(labelProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(labelIndicaciones)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProveedor)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIndicaciones)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        add(panelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 68, 630, 103));

        panelTablaProductos.setMaximumSize(new java.awt.Dimension(600, 650));
        panelTablaProductos.setPreferredSize(new java.awt.Dimension(600, 650));

        scrollTablaProductos.setMaximumSize(new java.awt.Dimension(600, 600));
        scrollTablaProductos.setPreferredSize(new java.awt.Dimension(600, 650));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setMaximumSize(new java.awt.Dimension(700, 650));
        tablaProductos.setPreferredSize(new java.awt.Dimension(600, 300));
        tablaProductos.setRowSelectionAllowed(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        scrollTablaProductos.setViewportView(tablaProductos);

        javax.swing.GroupLayout panelTablaProductosLayout = new javax.swing.GroupLayout(panelTablaProductos);
        panelTablaProductos.setLayout(panelTablaProductosLayout);
        panelTablaProductosLayout.setHorizontalGroup(
            panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelTablaProductosLayout.setVerticalGroup(
            panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProductosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(scrollTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        add(panelTablaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 171, -1, 530));

        BtnAgregarProducto.setBackground(new java.awt.Color(0, 0, 0));
        BtnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarProducto.setText("Agregar producto");
        BtnAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAgregarProductoMouseClicked(evt);
            }
        });
        add(BtnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 701, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){ 
            try {
                productoSeleccionado = control.cargarProductos().get(tablaProductos.getSelectedRow());
                productoSeleccionado();
                mostrarDatosProductoEntrada();
            } catch (NegocioException ex) {
                Logger.getLogger(SeleccionarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void BtnAgregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAgregarProductoMouseClicked
        // TODO add your handling code here:
        control.mostrarVentanaProductoNuevo();
    }//GEN-LAST:event_BtnAgregarProductoMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        try {
            control.mostrarVentanaSeleccionarProveedor();
        } catch (InventarioException ex) {
            Logger.getLogger(SeleccionarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtrasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarProducto;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel labelIndicaciones;
    private javax.swing.JLabel labelProveedor;
    private javax.swing.JLabel labelSeleccionProv;
    private javax.swing.JPanel panaelTitulo;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelTablaProductos;
    private javax.swing.JScrollPane scrollTablaProductos;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
   
    public void mostrarDatosProductoEntrada(){
        control.mostrarVentanaDatosEntrada();
    }
    public void productoSeleccionado(){
        control.setProducto(productoSeleccionado);
    }
}

