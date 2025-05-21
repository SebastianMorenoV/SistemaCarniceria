/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import IAdapters.IAdaptadorProductoVenta;
import IAdapters.IAdaptadorProducto;
import Adapters.AdaptadorProducto;
import DTOs.NuevoProductoVentaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoVentaDTO;
import entidades.Producto;
import entidades.ProductoVenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class AdaptadorProductoVenta implements IAdaptadorProductoVenta {

    IAdaptadorProducto adapter = new AdaptadorProducto();

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
        for (ProductoVenta producto : listaProductoVenta) {
            listaProductosVentaDTO.add(convertirADTO(producto));
            
        }
        return listaProductosVentaDTO;

    }

    @Override
    public List<ProductoVenta> convertirListaDTOAEntidad(List<ProductoVentaDTO> listaProductoVenta) {
        List<ProductoVenta> listaProductosVentaDTO = new ArrayList<>();
        for (ProductoVentaDTO producto : listaProductoVenta) {
            listaProductosVentaDTO.add(convertirProductoVentaAEntidad(producto));

        }
        return listaProductosVentaDTO;
    }

    @Override
    public ProductoVentaDTO convertirProductoVentaADTO(ProductoVenta producto) {
        ProductoVentaDTO productoVenta = new ProductoVentaDTO();
        ProductoCargadoDTO productoCargado = adapter.convertirADTO(producto.getProducto());
        productoVenta.setProducto(productoCargado);
        productoVenta.setCantidad(producto.getCantidad());
        productoVenta.setPrecioUnitario(producto.getPrecioUnitario());
        productoVenta.setImporte(producto.getImporte());
        
        return productoVenta;
    }
    
      @Override
    public ProductoVenta convertirProductoVentaAEntidad(ProductoVentaDTO producto) {
          System.out.println("PRODUCTO DESDE EL ADAPTER PRODUCTO VENTA" + producto);
        Producto productoCargado = adapter.convertirAEntidad(producto.getProducto());
        ProductoVenta productoVentaEntidad = new ProductoVenta();
        productoVentaEntidad.setProducto(productoCargado);
        productoVentaEntidad.setImporte(producto.getImporte());
        productoVentaEntidad.setPrecioUnitario(producto.getPrecioUnitario());
        productoVentaEntidad.setCantidad(producto.getCantidad());

        return productoVentaEntidad;

    }
}
