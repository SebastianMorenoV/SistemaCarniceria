
package GUI.ModuloRealizarDevolucion;

import GUI.Aplicacion;
import java.awt.Color;

/**
 *
 * @author Sebastian Moreno
 */
public class PantallaMenuDevolucion extends javax.swing.JPanel {

    private Aplicacion app;
    public PantallaMenuDevolucion(Aplicacion app) {
        this.app = app;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPanelVentaEnCaja = new javax.swing.JLabel();
        pnlDevolucion = new GUI.PanelRound();
        txtBusquedaNombre1 = new javax.swing.JLabel();
        pnlHistorial = new GUI.PanelRound();
        txtBusquedaNombre3 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPanelVentaEnCaja.setBackground(new java.awt.Color(0, 0, 0));
        txtPanelVentaEnCaja.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtPanelVentaEnCaja.setText("Area de Devolución");
        add(txtPanelVentaEnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 420, -1));

        pnlDevolucion.setBackground(new java.awt.Color(0, 0, 0));
        pnlDevolucion.setRoundBottomLeft(30);
        pnlDevolucion.setRoundBottomRight(30);
        pnlDevolucion.setRoundTopLeft(30);
        pnlDevolucion.setRoundTopRight(30);
        pnlDevolucion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBusquedaNombre1.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        txtBusquedaNombre1.setForeground(new java.awt.Color(255, 255, 255));
        txtBusquedaNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBusquedaNombre1.setText("Realizar Devolución");
        txtBusquedaNombre1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtBusquedaNombre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusquedaNombre1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtBusquedaNombre1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBusquedaNombre1MouseExited(evt);
            }
        });
        pnlDevolucion.add(txtBusquedaNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 90));

        add(pnlDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 470, 90));

        pnlHistorial.setBackground(new java.awt.Color(0, 0, 0));
        pnlHistorial.setRoundBottomLeft(30);
        pnlHistorial.setRoundBottomRight(30);
        pnlHistorial.setRoundTopLeft(30);
        pnlHistorial.setRoundTopRight(30);
        pnlHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBusquedaNombre3.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        txtBusquedaNombre3.setForeground(new java.awt.Color(255, 255, 255));
        txtBusquedaNombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBusquedaNombre3.setText("Historial de Devoluciones");
        txtBusquedaNombre3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtBusquedaNombre3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusquedaNombre3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtBusquedaNombre3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBusquedaNombre3MouseExited(evt);
            }
        });
        pnlHistorial.add(txtBusquedaNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 90));

        add(pnlHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 470, 90));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaNombre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaNombre1MouseClicked
        app.mostrarPantallaTicketDevolucion();
    }//GEN-LAST:event_txtBusquedaNombre1MouseClicked

    private void txtBusquedaNombre3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaNombre3MouseClicked
        app.mostrarPantallaHistorialDevolucion();
    }//GEN-LAST:event_txtBusquedaNombre3MouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarMenuOpciones();
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void txtBusquedaNombre3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaNombre3MouseEntered
          pnlHistorial.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_txtBusquedaNombre3MouseEntered

    private void txtBusquedaNombre3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaNombre3MouseExited
          pnlHistorial.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtBusquedaNombre3MouseExited

    private void txtBusquedaNombre1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaNombre1MouseEntered
          pnlDevolucion.setBackground(new Color(100, 100, 120, 180));
    }//GEN-LAST:event_txtBusquedaNombre1MouseEntered

    private void txtBusquedaNombre1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaNombre1MouseExited
          pnlDevolucion.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtBusquedaNombre1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound pnlDevolucion;
    private GUI.PanelRound pnlHistorial;
    private javax.swing.JLabel txtBusquedaNombre1;
    private javax.swing.JLabel txtBusquedaNombre3;
    private javax.swing.JLabel txtPanelVentaEnCaja;
    // End of variables declaration//GEN-END:variables
}
