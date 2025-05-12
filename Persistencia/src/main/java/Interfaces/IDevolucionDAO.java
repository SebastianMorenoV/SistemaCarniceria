package Interfaces;

import DAOS.DevolucionDAO;
import entidades.Devolucion;

/**
 *
 * @author Sebastian Moreno
 */
public interface IDevolucionDAO {

    static IDevolucionDAO obtenerInstanciaDAO() {
        return new DevolucionDAO(); // o podrías usar singleton aquí
    }

    public Devolucion registrarDevolucion(Devolucion devolucion);
}
