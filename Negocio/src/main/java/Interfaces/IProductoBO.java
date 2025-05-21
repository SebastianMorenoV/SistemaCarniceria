package Interfaces;

import DAOS.ProductoDAO;
import DTOs.ProductoCargadoDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IProductoBO {
    
    static IProductoDAO obtenerInstanciaDAO(){
        return new ProductoDAO();
    }
    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException;
    
    public ProductoCargadoDTO agregarProducto(ProductoCargadoDTO producto) throws NegocioException;
    
    public List<ProductoCargadoDTO> buscadorProducto(String nombre) throws NegocioException;
    
    public List<ProductoCargadoDTO> buscaPorNombre(String textoBusqueda) throws NegocioException;
    
}
