package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author janot
 */
public class VentanaFormularioEfectivo extends JDialog{
    private final int width= 620;
    private final int height = 320;
    
    public VentanaFormularioEfectivo(Aplicacion app, FormularioEfectivo formularioEfectivo){
        configuracionVentana(app, formularioEfectivo);
    }
    

    public void configuracionVentana(Aplicacion app, FormularioEfectivo formulario){
        formulario.jLabelTotal.setText("Total: "+ " $" + app.obtenerVenta().getTotal());
        setTitle("Formulario de Efectivo");
        setSize(width, height);  // Tamaño personalizado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar ventana
        setResizable(false);
        add(formulario);
        setVisible(true);
    }
}
