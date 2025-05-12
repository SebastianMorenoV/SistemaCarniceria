package DAOS;

import Interfaces.IDevolucionDAO;
import entidades.Devolucion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionDAO implements IDevolucionDAO{

    private static DevolucionDAO instanceDevolucionDAO;

    public DevolucionDAO() {
    }

    /**
     * Devuelve la unica instancia de esta clase (patron Singleton). Si la
     * instancia no existe, la crea.
     *
     * @return la instancia unica de IngredienteDAO.
     */
    public static DevolucionDAO getInstanceDAO() {
        if (instanceDevolucionDAO == null) {
            instanceDevolucionDAO = new DevolucionDAO();
        }

        return instanceDevolucionDAO;
    }

    /*
    Metodos de la interfaz.
     */
    
    private List<Devolucion> lista = new ArrayList<>();
    public Devolucion registrarDevolucion(Devolucion devolucion){
        lista.add(devolucion);
        return devolucion;
    }
    
    
     
    
}
