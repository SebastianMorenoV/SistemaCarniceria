package pruebas;

import Exception.PersistenciaException;
import Interfaces.IProductoDAO;
import Interfaces.ISalidaDAO;
import entidades.Producto;
import entidades.Salida;
import fabrica.CreadorDAO;
import fabrica.ICreadorDAO;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author janot
 */
public class Prueba {
    public static void main(String[] args) {
        ICreadorDAO creador = new CreadorDAO();
        
        ISalidaDAO salidaDAO = creador.crearSalidaDAO();
        IProductoDAO productoDAO = creador.crearProductoDAO();
        /*
        Producto producto = new Producto("Leche chavo", "Eskeler", 0, true, 0, 0);
        Salida salida = new Salida(null, producto, new Date(), "jajajjaja", 2.2, 2.2, 2.2);
        
        try {
            for (Salida salida1: salidaDAO.consultarSalidasBuscador("Le", null, null)) {
                System.out.println(salida1.getProducto().getNombre());
            }
 
        } catch (PersistenciaException e) {
            e.getStackTrace();
        }
        */
        
        /*
        Producto producto = new Producto("Hamburguesas", "Eskeler", 0, true, 10, 200);
        try {
            
            System.out.println(productoDAO.restarStockAProducto(2.0, 1747811776));
        } catch (Exception e) {
        }
        */
    }
}
