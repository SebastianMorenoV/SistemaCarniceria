package GUI.ModuloRealizarVenta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class VentanaExitoProcesandoPago extends JDialog {

    public VentanaExitoProcesandoPago() {
        setTitle("Procesando Pago");
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        ImageIcon iconoPng = new ImageIcon(getClass().getResource("/imagenes/comprobado.png"));
        JLabel lblPng = new JLabel(iconoPng);

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.setPreferredSize(new Dimension(100, 100));
        panelImagen.add(lblPng);

        JLabel lblMensajeFinal = new JLabel("<html><h2>Procesando Pago</h2><p>Pago exitoso</p></html>", SwingConstants.CENTER);
        lblMensajeFinal.setFont(new Font("Product Sans Infanity", Font.PLAIN, 14));

        JPanel panelFinal = new JPanel(new BorderLayout(10, 10));
        panelFinal.setPreferredSize(new Dimension(400, 250));
        panelFinal.add(lblMensajeFinal, BorderLayout.NORTH);
        panelFinal.add(panelImagen, BorderLayout.CENTER);

        setContentPane(panelFinal);
        pack(); 


        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000); 
                return null;
            }

            @Override
            protected void done() {
                dispose(); 
            }
        };
        worker.execute(); 
    }
}
