package Interfaces;

import DAOS.DevolucionDAO;
import Exception.PersistenciaException;
import MONGO.DAOS.DevolucionMongoDAO;
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
        return new DevolucionMongoDAO(); // o podrías usar singleton aquí
    }

    public Devolucion registrarDevolucion(Devolucion devolucion) throws PersistenciaException;

    public List<Devolucion> buscarDevolucionPorFiltro(Devolucion devolucion, LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException;

    public List<Devolucion> buscarDevoluciones() throws PersistenciaException;

    public Devolucion buscarPorID(String id) throws PersistenciaException;
}
