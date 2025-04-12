
package ADAPTERS.Venta;

import DTOs.VentaDTO;
import Entidades.Venta;

/**
 * Esta interfaz representa los metodos abstractos de un Adaptador Venta.   
 * @author HP
 */
public interface IAdaptadorVenta {
    public VentaDTO convertirADTO(Venta venta);
    public Venta convertirAVenta(VentaDTO ventaDTO);
}
