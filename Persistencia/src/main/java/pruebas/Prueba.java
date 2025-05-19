package pruebas;

import Exception.PersistenciaException;
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
        
        Producto producto = new Producto("Leche chavo", "Eskeler", 0, true, 0, 0);
        Salida salida = new Salida(null, producto, new Date(), "jajajjaja", 2.2, 2.2, 2.2);
        
        try {
            System.out.println(salidaDAO.agregarNuevaSalida(salida));
        } catch (PersistenciaException e) {
            e.getStackTrace();
        }
        
        
    }
}
