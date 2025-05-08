package GUI.ModuloRealizarDevolucion;

import GUI.Aplicacion;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sebastian Moreno
 */
public class PantallaTicket extends javax.swing.JPanel {

    Aplicacion app;

    public PantallaTicket(Aplicacion app) {
        this.app = app;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
        inputNumeroTicket = new javax.swing.JTextField();
        txtSubtitulo = new javax.swing.JLabel();
        btnCancelar = new GUI.PanelRound();
        btnTxtCancelar = new javax.swing.JLabel();
        btnIngresar = new GUI.PanelRound();
        btnTxtIngresar = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setBackground(new java.awt.Color(0, 0, 0));
        txtTitulo.setFont(new java.awt.Font("Product Sans Infanity", 0, 36)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(159, 9, 9));
        txtTitulo.setText("*Para la devolucion es necesario el ticket*");
        add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 690, -1));

        inputNumeroTicket.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        inputNumeroTicket.setText("Ingresa el numero");
        inputNumeroTicket.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNumeroTicketFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputNumeroTicketFocusLost(evt);
            }
        });
        inputNumeroTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputNumeroTicketKeyTyped(evt);
            }
        });
        add(inputNumeroTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 380, 50));

        txtSubtitulo.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        txtSubtitulo.setText("Numero de el ticket: ");
        add(txtSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 280, 30));

        btnCancelar.setBackground(new java.awt.Color(255, 44, 84));
        btnCancelar.setRoundBottomLeft(15);
        btnCancelar.setRoundBottomRight(15);
        btnCancelar.setRoundTopLeft(15);
        btnCancelar.setRoundTopRight(15);
        btnCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtCancelar.setFont(new java.awt.Font("Product Sans Infanity", 0, 24)); // NOI18N
        btnTxtCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtCancelar.setText("CANCELAR");
        btnTxtCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtCancelarMouseClicked(evt);
            }
        });
        btnCancelar.add(btnTxtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 50));

        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 280, 50));

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
        btnIngresar.add(btnTxtIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 50));

        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 280, 50));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras (1).png"))); // NOI18N
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });
        add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        txtTitulo1.setBackground(new java.awt.Color(0, 0, 0));
        txtTitulo1.setFont(new java.awt.Font("Product Sans Infanity", 0, 48)); // NOI18N
        txtTitulo1.setText("Ingresar el numero de ticket");
        add(txtTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 620, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inputNumeroTicketFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNumeroTicketFocusGained
        if (inputNumeroTicket.getText().equals("Ingresa el numero")) {
            inputNumeroTicket.setText("");
        }
    }//GEN-LAST:event_inputNumeroTicketFocusGained

    private void inputNumeroTicketFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNumeroTicketFocusLost
        if (inputNumeroTicket.getText().trim().isEmpty()) {
            inputNumeroTicket.setText("Ingresa el numero");
        }
    }//GEN-LAST:event_inputNumeroTicketFocusLost

    private void inputNumeroTicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumeroTicketKeyTyped
        char c = evt.getKeyChar();
        // Solo permite números (0-9) y retroceso
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume(); // Ignora la entrada si no es válida
        }
    }//GEN-LAST:event_inputNumeroTicketKeyTyped

    private void btnTxtCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelarMouseClicked
        app.mostrarPantallaMenuDevolucion();
    }//GEN-LAST:event_btnTxtCancelarMouseClicked

    private void btnTxtIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtIngresarMouseClicked
        if (validarTicket()) {
            app.mostrarPantallaDevolucion();
        }

    }//GEN-LAST:event_btnTxtIngresarMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        app.mostrarPantallaMenuDevolucion();
    }//GEN-LAST:event_btnAtrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private GUI.PanelRound btnCancelar;
    private GUI.PanelRound btnIngresar;
    private javax.swing.JLabel btnTxtCancelar;
    private javax.swing.JLabel btnTxtIngresar;
    private javax.swing.JTextField inputNumeroTicket;
    private javax.swing.JLabel txtSubtitulo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtTitulo1;
    // End of variables declaration//GEN-END:variables

//Metodos auxiliares
    public boolean validarTicket() {
        String texto = inputNumeroTicket.getText().trim();
        if (texto == null || texto.isEmpty() || texto.equals("Ingresa el numero")) {
            return false;
        }
        return app.validarTicket(texto);
    }
}
