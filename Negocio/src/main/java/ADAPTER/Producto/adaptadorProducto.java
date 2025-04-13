/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADAPTER.Producto;

import DTOs.ProductoCargadoDTO;
import Entidades.Producto;

/**
 *
 * @author HP
 */
public class adaptadorProducto implements IAdaptadorProducto{
    
    // Faltan atributos para poder crear el productoVenta que es la entidad
    //      Atributos
                //esPesable, texto

    @Override
    public ProductoCargadoDTO convertirADTO(Producto producto) {
        ProductoCargadoDTO productoDTO = new  ProductoCargadoDTO();
       // productoDTO.setCodigo(producto.getId());
       productoDTO.setDecimal(producto.getUnidad());
       productoDTO.setDescripcion(producto.getTexto());
       productoDTO.setNombre(producto.getNombre());
       return productoDTO;
       
    }

    @Override
    public Producto convertirAEntidad(ProductoCargadoDTO producto) {
       Producto productoEntidad = new  Producto();
       // productoDTO.setCodigo(producto.getId());
       //productoEntidad.setEsPesable(producto.);
       //productoEntidad.setTexto(texto);
       productoEntidad.setPrecio(producto.getPrecio());
       productoEntidad.setUnidad(producto.getDecimal());
       productoEntidad.setDescripcion(producto.getDescripcion());
       productoEntidad.setNombre(producto.getNombre());
       
       return productoEntidad;
       
    }

}
