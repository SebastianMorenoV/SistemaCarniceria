package DAOS;

import entidades.Producto;
import Exception.PersistenciaException;
import Interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class ProductoDAO implements IProductoDAO {
    private static ProductoDAO instanceProductoDAO;
    private List<Producto> productos = new ArrayList<>();
    
    public ProductoDAO(){
        
    }
    
    public static ProductoDAO getInstanciaDAO(){
        if(instanceProductoDAO == null){
            instanceProductoDAO = new ProductoDAO();
        }
        return instanceProductoDAO;
    }

    @Override
    public List<Producto> consultarProductos() throws PersistenciaException {
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("Manzana");
        producto1.setDescripcion("Fruta roja y jugosa");
        producto1.setPrecio(25.50);
        producto1.setEsPesable(true);
        producto1.setUnidad(0.5);
        producto1.setStock(1);

        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setNombre("Pan de caja");
        producto2.setDescripcion("Pan integral Bimbo");
        producto2.setPrecio(40.00);
        producto2.setEsPesable(false);
        producto2.setUnidad(1);
        producto2.setStock(2);

        Producto producto3 = new Producto();
        producto3.setId(3);
        producto3.setNombre("Leche entera");
        producto3.setDescripcion("Leche Lala 1L");
        producto3.setPrecio(24.90);
        producto3.setEsPesable(false);
        producto3.setUnidad(1);
        producto3.setStock(3);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        return productos;
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        productos.add(producto);
        return producto;
    }

    @Override
    public List<Producto> buscadorProducto(String nombre) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> buscarPorNombre(String textoBusqueda) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean restarStockAProducto(double salida, Integer codigo) throws PersistenciaException {
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sumarStockAProducto(double salida, Integer codigo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
