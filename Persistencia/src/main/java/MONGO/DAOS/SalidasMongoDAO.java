package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.ISalidaDAO;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import entidades.Salida;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author janot
 */
public class SalidasMongoDAO implements ISalidaDAO{
    private final MongoCollection<Salida> coleccion;

    public SalidasMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Salida", Salida.class);
    }

    @Override
    public Salida agregarNuevaSalida(Salida salida) throws PersistenciaException {
        try {
            if (salida.getId() == null) {
                salida.setId(new ObjectId().getTimestamp());
            }
            
            System.out.println(salida.getId() + "Persistencia");
            coleccion.insertOne(salida);
            return salida;
            
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar una nueva salida", e);
        }
        
    }

    @Override
    public List<Salida> consultarSalidasPorNombre(String nombre) throws PersistenciaException  {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Salida> consultarSalidasPorFecha(LocalDateTime fecha) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Salida> consultarSalidasPorMes(int mes, int año) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
