/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADAPTER.productoVenta;

import DTOs.NuevoProductoVentaDTO;
import Entidades.ProductoVenta;

/**
 *
 * @author HP
 */
public interface IAdaptadorProductoVenta {
    public NuevoProductoVentaDTO convertirADTO(ProductoVenta producto);
    public ProductoVenta convertirAEntidad(NuevoProductoVentaDTO producto);

}
