package GUI.ModuloRealizarVenta;

import GUI.Aplicacion;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author janot
 */
public class VentanaFormularioEfectivo extends JDialog {

    private final int width = 620;
    private final int height = 320;

    public VentanaFormularioEfectivo(Aplicacion app, FormularioEfectivo formularioEfectivo) {
        configuracionVentana(app, formularioEfectivo);
    }

    public void configuracionVentana(Aplicacion app, FormularioEfectivo formulario) {
        double totalTemporal = app.getTotalTemporal();
        String totalFormateado = String.format("%.2f", totalTemporal);
        formulario.jLabelTotal.setText("Total: " + " $" + totalFormateado);
        setTitle("Formulario de Efectivo");
        setSize(width, height);  // Tamaño personalizado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar ventana
        setResizable(false);
        add(formulario);
        setVisible(true);
    }

    public void ajustarTamanoTexto(JLabel label, String texto) {
        Font fuenteOriginal = label.getFont();
        int anchoLabel = label.getWidth();

        int tamanoFuente = fuenteOriginal.getSize();
        FontMetrics fm = label.getFontMetrics(fuenteOriginal);

        while (fm.stringWidth(texto) > anchoLabel && tamanoFuente > 10) {
            tamanoFuente--;
            fuenteOriginal = fuenteOriginal.deriveFont((float) tamanoFuente);
            fm = label.getFontMetrics(fuenteOriginal);
        }
        label.setFont(fuenteOriginal);
        label.setText(texto);
    }
}
