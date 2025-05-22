
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IDevolucionDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionMongo;
import entidades.Devolucion;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Esta clase representa una DAO de Devoluciones funcionando con MongoDB.
 * @author Sebastian Moreno
 */
public class DevolucionMongoDAO implements IDevolucionDAO {

    private final MongoCollection<Devolucion> coleccion;

    public DevolucionMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Devolucion", Devolucion.class);
    }
    /**
     * Metodo que registra una devolucion en la BD.
     * @param devolucion la devolucion a registrar.
     * @return Un Objeto del tipo devolucion con id , persisitido.
     * @throws PersistenciaException si no se puede realizar la devolucion.
     */
    @Override
    public Devolucion registrarDevolucion(Devolucion devolucion) throws PersistenciaException {
        try {
            if (devolucion.getId() == null) {
                devolucion.setId(new ObjectId().getTimestamp());
            }
            coleccion.insertOne(devolucion);
            return devolucion;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar la devolución.", e);
        }
    }
    
    /**
     * Metodo para buscar una devolucion de manera dinamica en la base de datos.
     * Basicamente construye una lista de filtros los cuales, entran o desaparecen dependiendo
     * de lo que reciba el metodo.
     * @param filtro una devolucion con el dato telefono o nombre completo.
     * @param inicio la fecha de inicio a buscar
     * @param fin la fecha fin a buscar
     * @return una lista de devoluciones filtradas.
     */
    public List<Devolucion> buscarDevolucionPorFiltro(Devolucion filtro, LocalDateTime inicio, LocalDateTime fin) {
        List<Bson> filtros = new ArrayList<>();

        if (filtro.getTelefono() != null && !filtro.getTelefono().isEmpty()) {
            filtros.add(Filters.eq("telefono", filtro.getTelefono()));
        }

        if (filtro.getNombreCompleto() != null && !filtro.getNombreCompleto().isEmpty()) {
            filtros.add(Filters.regex("nombreCompleto", filtro.getNombreCompleto(), "i"));
        }

        if (inicio != null && fin != null) {
            filtros.add(Filters.and(
                    Filters.gte("fechaHora", Date.from(inicio.toInstant(ZoneOffset.UTC))),
                    Filters.lte("fechaHora", Date.from(fin.toInstant(ZoneOffset.UTC)))
            ));
        } else if (inicio != null) {
            filtros.add(Filters.gte("fechaHora", Date.from(inicio.toInstant(ZoneOffset.UTC))));
        } else if (fin != null) {
            filtros.add(Filters.lte("fechaHora", Date.from(fin.toInstant(ZoneOffset.UTC))));
        }

        Bson filtroFinal = filtros.isEmpty() ? new Document() : Filters.and(filtros);

        return coleccion.find(filtroFinal).into(new ArrayList<>());
    }

    /**
     * NO SE UTILIZA.
     * Metodo para buscar todas las devoluciones de la base de datos.
     * Realmente no se implementa como tal este metodo debido a que se utilizan las busquedas dinamicas.
     * Sobrecarga un poco el sistema si existen muchas devoluciones , por eso no es utilizado.
     * @return una lista de devoluciones
     *
     */
    @Override
    public List<Devolucion> buscarDevoluciones() {
        return coleccion.find().into(new ArrayList<>());
    }
    
    /**
     * Este metodo busca una devolucion por su numero de id.
     * @param id el id de la devolucion a buscar.
     * @return un objeto devolucion buscado por su codigo.
     * @throws PersistenciaException si no se puede buscar la devolucion por id.
     */
    @Override
    public Devolucion buscarPorID(String id) throws PersistenciaException {
        try {
            int codigo = Integer.parseInt(id);
            Devolucion devolucion = coleccion.find(eq("codigo", codigo)).first();
            return devolucion;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo buscar la devolución por ID.", e);
        }
    }
    
}
