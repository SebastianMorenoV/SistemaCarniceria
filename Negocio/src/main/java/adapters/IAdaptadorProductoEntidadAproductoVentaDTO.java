/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adapters;

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
