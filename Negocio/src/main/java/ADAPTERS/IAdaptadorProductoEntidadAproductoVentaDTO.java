package ADAPTERS;

import DTOs.NuevoProductoVentaDTO;
import DTOs.ProductoCargadoDTO;

/**
 *
 * @author HP
 */
public interface IAdaptadorProductoEntidadAproductoVentaDTO {
    public NuevoProductoVentaDTO convertirProductoEntidadAproductoVentaDTO(ProductoCargadoDTO producto);
    public ProductoCargadoDTO convertirproductoVentaDTOAProductoEntidad(NuevoProductoVentaDTO producto);
}
