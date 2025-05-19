/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IDevolucionDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionMongo;
import entidades.Devolucion;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import org.bson.Document;
import org.bson.conversions.Bson;
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

            System.out.println(devolucion.getId() + "persisntecia");
            coleccion.insertOne(devolucion);
            return devolucion;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar la devolución.", e);
        }
    }

    public List<Devolucion> buscarDevolucionPorFiltro(Devolucion filtro, LocalDateTime inicio, LocalDateTime fin) {
        List<Bson> filtros = new ArrayList<>();

        if (filtro.getTelefono() != null && !filtro.getTelefono().isEmpty()) {
            filtros.add(Filters.eq("telefono", filtro.getTelefono()));
        }

        if (filtro.getNombreCompleto() != null && !filtro.getNombreCompleto().isEmpty()) {
            filtros.add(Filters.regex("nombreCompleto", filtro.getNombreCompleto(), "i"));
        }

        // filtro de fecha
        if (inicio != null && fin != null) {
            filtros.add(Filters.and(
                    Filters.gte("fechaHora", Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant())),
                    Filters.lte("fechaHora", Date.from(fin.atZone(ZoneId.systemDefault()).toInstant()))
            ));
        }

        Bson filtroFinal = filtros.isEmpty() ? new Document() : Filters.and(filtros);

        return coleccion.find(filtroFinal).into(new ArrayList<>());
    }

    @Override
    public List<Devolucion> buscarDevoluciones() throws PersistenciaException {
        return coleccion.find().into(new ArrayList<>());
    }

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
