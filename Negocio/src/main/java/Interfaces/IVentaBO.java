
package Interfaces;

import DTOs.VentaDTO;
import Exception.NegocioException;

/**
 * Esta interfaz representa los metodos que implementa la clase VentaBO 
 * su uso es con el fin de que no se limiten las BO's de el sistema y si se requiere
 * cambiar la BO facilmente.
 * @author Sebastian Moreno
 */
public interface IVentaBO {

    public VentaDTO registrarVenta(VentaDTO ventaDTO) throws NegocioException;
    
    public VentaDTO obtenerVentaPorTicket(String numeroTicket)throws NegocioException;
    
    public boolean validarVentaConDevolucion(int codigoVenta)throws NegocioException;
}
