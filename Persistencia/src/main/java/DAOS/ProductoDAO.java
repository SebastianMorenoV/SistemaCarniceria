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

    @Override
    public List<Producto> consultarProductos() throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        Producto producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Manzana");
        producto1.setDescripcion("Fruta roja y jugosa");
        producto1.setPrecio(25.50);
        producto1.setEsPesable(true);
        producto1.setUnidad(0.5);
        producto1.setTexto("Por kilo");

        Producto producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Pan de caja");
        producto2.setDescripcion("Pan integral Bimbo");
        producto2.setPrecio(40.00);
        producto2.setEsPesable(false);
        producto2.setUnidad(1);
        producto2.setTexto("Por pieza");

        Producto producto3 = new Producto();
        producto3.setId(3L);
        producto3.setNombre("Leche entera");
        producto3.setDescripcion("Leche Lala 1L");
        producto3.setPrecio(24.90);
        producto3.setEsPesable(false);
        producto3.setUnidad(1);
        producto3.setTexto("Por litro");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        return productos;
    }

}
