/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.ProductoCargadoDTO;
import entidades.Producto;

/**
 *
 * @author HP
 */
public interface IAdaptadorProducto {
    public ProductoCargadoDTO convertirADTO(Producto producto);
    public Producto convertirAEntidad(ProductoCargadoDTO producto);
    public Producto convertirAEntidadStock(ProductoCargadoDTO producto);

}
