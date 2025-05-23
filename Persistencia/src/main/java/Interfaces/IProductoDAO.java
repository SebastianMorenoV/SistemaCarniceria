package Interfaces;

import DAOS.ProductoDAO;
import entidades.Producto;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IProductoDAO {
     static IProductoDAO obtenerInstanciaDAO() {
        return new ProductoDAO(); // o podrías usar singleton aquí
    }
    public List<Producto> consultarProductos() throws PersistenciaException;
    
    public Producto agregarProducto(Producto producto) throws PersistenciaException;
    
    public List<Producto> buscadorProducto(String nombre) throws PersistenciaException;
    
    public List<Producto> buscarPorNombre(String textoBusqueda) throws PersistenciaException;
    
    public boolean restarStockAProducto(double salida, Integer codigo) throws PersistenciaException;
    
    public boolean sumarStockAProducto(double salida, Integer codigo) throws PersistenciaException;

}
