package Interfaces;

import DAOS.DevolucionDAO;
import entidades.Devolucion;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Sebastian Moreno
 */
public interface IDevolucionDAO {

    static IDevolucionDAO obtenerInstanciaDAO() {
        return new DevolucionDAO(); // o podrías usar singleton aquí
    }

    public Devolucion registrarDevolucion(Devolucion devolucion) throws PersistenceException;

    public List<Devolucion> buscarDevolucionPorFiltro(Devolucion devolucion, LocalDateTime inicio, LocalDateTime fin) throws PersistenceException;

    public List<Devolucion> buscarDevoluciones() throws PersistenceException;

    public Devolucion buscarPorID(String id) throws PersistenceException;
}
