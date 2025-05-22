
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
       productoDTO.setEsPesable(producto.isEsPesable());
       productoDTO.setNombre(producto.getNombre());
       productoDTO.setPrecio(producto.getPrecio());
       productoDTO.setStock(producto.getStock()); //FUERZA BRUTA
       return productoDTO;
       
    }

    @Override
    public Producto convertirAEntidad(ProductoCargadoDTO producto) {
       Producto productoEntidad = new  Producto();
       productoEntidad.setId(producto.getCodigo());
       productoEntidad.setEsPesable(producto.isEsPesable());
       productoEntidad.setPrecio(producto.getPrecio());
       productoEntidad.setUnidad(producto.getUnidad());
       productoEntidad.setDescripcion(producto.getDescripcion());
       productoEntidad.setNombre(producto.getNombre());
       // quite el setStock deberia guardarlo en 0 , pero se necesita otro adapter para cuando se guarde la entrada con el stock.
       
       return productoEntidad;
       
    }

    @Override
    public Producto convertirAEntidadStock(ProductoCargadoDTO producto) {
        Producto productoEntidad = new  Producto();
        productoEntidad.setId(producto.getCodigo());
        productoEntidad.setEsPesable(producto.isEsPesable());
        productoEntidad.setPrecio(producto.getPrecio());
        productoEntidad.setUnidad(producto.getUnidad());
        productoEntidad.setDescripcion(producto.getDescripcion());
        productoEntidad.setNombre(producto.getNombre());
        productoEntidad.setStock(producto.getStock());
     
        return productoEntidad;
    }

}
