/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IDevolucionDAO;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import entidades.Devolucion;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.PersistenceException;
import org.bson.types.ObjectId;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionMongoDAO implements IDevolucionDAO {

    private final MongoCollection<Devolucion> coleccion;

    public DevolucionMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Devolucion", Devolucion.class);
    }

    @Override
    public Devolucion registrarDevolucion(Devolucion devolucion) throws PersistenciaException {
        try {
            // Asignar un nuevo _id si está en null
            if (devolucion.getId() == null) {
                devolucion.setId(new ObjectId().getTimestamp());
            }

            coleccion.insertOne(devolucion);
            return devolucion;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar la devolución.", e);
        }
    }

    @Override
    public List<Devolucion> buscarDevolucionPorFiltro(Devolucion devolucion, LocalDateTime inicio, LocalDateTime fin) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Devolucion> buscarDevoluciones() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Devolucion buscarPorID(String id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
