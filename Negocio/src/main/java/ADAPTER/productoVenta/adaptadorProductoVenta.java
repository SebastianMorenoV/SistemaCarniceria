/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADAPTER.productoVenta;

import ADAPTER.Producto.IAdaptadorProducto;
import ADAPTER.Producto.adaptadorProducto;
import DTOs.NuevoProductoVentaDTO;
import DTOs.ProductoCargadoDTO;
import Entidades.Producto;
import Entidades.ProductoVenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class adaptadorProductoVenta implements IAdaptadorProductoVenta{
    IAdaptadorProducto adapter = new adaptadorProducto();
    @Override
    public NuevoProductoVentaDTO convertirADTO(ProductoVenta producto) {
        NuevoProductoVentaDTO productoDTO = new NuevoProductoVentaDTO();
        ProductoCargadoDTO productoCargado = adapter.convertirADTO(producto.getProducto());
        
        productoDTO.setProducto(productoCargado);
        productoDTO.setImporte(producto.getImporte());
        productoDTO.setPrecioUnitario(producto.getPrecioUnitario());
        productoDTO.setCantidad(producto.getCantidad());
        
        return productoDTO;
    }

    @Override
    public ProductoVenta convertirAEntidad(NuevoProductoVentaDTO producto) {
        Producto productoCargado = adapter.convertirAEntidad(producto.getProducto());
        ProductoVenta productoVentaEntidad = new ProductoVenta();
        productoVentaEntidad.setProducto(productoCargado);
        productoVentaEntidad.setImporte(producto.getImporte());
        productoVentaEntidad.setPrecioUnitario(producto.getPrecioUnitario());
        productoVentaEntidad.setCantidad(producto.getCantidad());

        return productoVentaEntidad;
    
    }
    
  
    @Override
    public List<NuevoProductoVentaDTO> convertirListaADTO(List<ProductoVenta> listaProductoVenta) {
        List<NuevoProductoVentaDTO> listaProductosVentaDTO = new ArrayList<>();
        for(ProductoVenta producto : listaProductoVenta){
            listaProductosVentaDTO.add(convertirADTO(producto));
 
        }
        return listaProductosVentaDTO;
        
        
    }

    @Override
    public List<ProductoVenta> convertirListaDTOAEntidad(List<NuevoProductoVentaDTO> listaProductoVenta) {
        List<ProductoVenta> listaProductosVentaDTO = new ArrayList<>();
           for(NuevoProductoVentaDTO producto : listaProductoVenta){
               listaProductosVentaDTO.add(convertirAEntidad(producto));
       
           }
           return listaProductosVentaDTO;
    }

  
}

