/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import IAdapters.IAdaptadorProducto;
import DTOs.ProductoCargadoDTO;
import entidades.Producto;

/**
 *
 * @author HP
 */
public class AdaptadorProducto implements IAdaptadorProducto{
    

    @Override
    public ProductoCargadoDTO convertirADTO(Producto producto) {
       ProductoCargadoDTO productoDTO = new  ProductoCargadoDTO();
       productoDTO.setCodigo(producto.getId());
       productoDTO.setUnidad(producto.getUnidad());
       productoDTO.setDescripcion(producto.getDescripcion());
       productoDTO.setNombre(producto.getNombre());
       productoDTO.setPrecio(producto.getPrecio());
       productoDTO.setStock(producto.getStock());
       return productoDTO;
       
    }

    @Override
    public Producto convertirAEntidad(ProductoCargadoDTO producto) {
       Producto productoEntidad = new  Producto();
       // productoDTO.setCodigo(producto.getId());
       //productoEntidad.setEsPesable(producto.);
       //productoEntidad.setTexto(texto);
       productoEntidad.setPrecio(producto.getPrecio());
       productoEntidad.setUnidad(producto.getUnidad());
       productoEntidad.setDescripcion(producto.getDescripcion());
       productoEntidad.setNombre(producto.getNombre());
       
       return productoEntidad;
       
    }

}
