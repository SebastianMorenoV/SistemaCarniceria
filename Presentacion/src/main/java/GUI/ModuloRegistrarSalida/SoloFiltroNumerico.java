package GUI.ModuloRegistrarSalida;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Lo que hace esta clase es hacer un bloque en jTextFields, para que nomas
 * reciba como entrada numeros tanto enteros como doubles y decimales, NO TEXTO
 * @author janot
 */
public class SoloFiltroNumerico extends DocumentFilter{
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        String nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
                .insert(offset, string).toString();
        if (esNumeroValido(nuevoTexto)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
            throws BadLocationException {
        String nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
                .replace(offset, offset + length, string).toString();
        if (esNumeroValido(nuevoTexto)) {
            super.replace(fb, offset, length, string, attrs);
        }
    }

    private boolean esNumeroValido(String texto) {
        if (texto.isEmpty() || texto.equals("."))
            return true; // Permitir texto vacío o solo punto por mientras escribe
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
