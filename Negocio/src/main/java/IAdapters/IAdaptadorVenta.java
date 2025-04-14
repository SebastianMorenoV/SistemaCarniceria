
package IAdapters;

import DTOs.CrearVentaDTO;
import DTOs.VentaDTO;
import entidades.Venta;

/**
 * Esta interfaz representa los metodos abstractos de un Adaptador Venta.   
 * @author HP
 */
public interface IAdaptadorVenta {
    public VentaDTO convertirADTO(Venta venta);
    public Venta convertirAVenta(VentaDTO ventaDTO);
    public CrearVentaDTO VentaACrearVentaDTO(Venta venta);
    public Venta CrearVentaDTOAVenta(CrearVentaDTO ventaDTO);

}
