/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author Sebastian Moreno
 */
public class VentaException extends Exception{

    public VentaException(String message) {
        super(message);
    }

    public VentaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
