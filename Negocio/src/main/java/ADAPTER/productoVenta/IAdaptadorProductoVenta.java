/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADAPTER.productoVenta;

import DTOs.NuevoProductoVentaDTO;
import Entidades.ProductoVenta;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IAdaptadorProductoVenta {
    public NuevoProductoVentaDTO convertirADTO(ProductoVenta producto);
    public ProductoVenta convertirAEntidad(NuevoProductoVentaDTO producto);
    public List<NuevoProductoVentaDTO> convertirListaADTO(List<ProductoVenta> listaProductoVenta);
    public List<ProductoVenta> convertirListaDTOAEntidad(List<NuevoProductoVentaDTO> listaProductoVenta);

}
