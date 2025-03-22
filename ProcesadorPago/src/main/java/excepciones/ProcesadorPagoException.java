package excepciones;

/**
 *
 * @author janot
 */
public class ProcesadorPagoException extends Exception{

    public ProcesadorPagoException(String message) {
        super(message);
    }

    public ProcesadorPagoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
