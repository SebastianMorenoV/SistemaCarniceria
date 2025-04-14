/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.ProductoVentaDTO;   
import DTOs.NuevoProductoVentaDTO;
import Entidades.ProductoVenta;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IAdaptadorProductoVenta {

    public ProductoVentaDTO convertirProductoVentaADTO(ProductoVenta producto);

    // Nuevo ProductoVentaDTO es para crear un nuevoProductoVenta no para el nuevoCreado en la base de datos
    public NuevoProductoVentaDTO convertirADTO(ProductoVenta producto);

    public ProductoVenta convertirAEntidad(NuevoProductoVentaDTO producto);

    public List<NuevoProductoVentaDTO> convertirListaADTO(List<ProductoVenta> listaProductoVenta);

    public List<ProductoVenta> convertirListaDTOAEntidad(List<NuevoProductoVentaDTO> listaProductoVenta);

}
