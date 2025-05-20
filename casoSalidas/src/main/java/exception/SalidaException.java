package exception;

/**
 *
 * @author janot
 */
public class SalidaException extends Exception{

    public SalidaException(String message) {
        super(message);
    }

    public SalidaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
