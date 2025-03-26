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
    
    public VentanaFormularioEfectivo(Aplicacion app){
        configuracionVentana(app);
    }
    

    public void configuracionVentana(Aplicacion app){
        setTitle("Formulario de Efectivo");
        setSize(width, height);  // Tamaño personalizado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrar ventana
        setResizable(false);
        
        // Agregar el formulario a la ventana
        FormularioEfectivo formulario = new FormularioEfectivo(app);
        add(formulario);
        
        setVisible(true);
    }
}
