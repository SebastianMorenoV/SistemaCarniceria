package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.ISalidaDAO;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import entidades.Salida;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.regex;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import org.bson.Document;

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
    public List<Salida> consultarSalidasBuscador(String nombre, Date fechaDesde, Date fechaHasta) throws PersistenciaException  {     
        //Lista que regresara el metodo
        List<Salida> listaSalidas = new ArrayList<>();
        
        //Lista que guardara las condiciones
        List<Bson> condiciones = new ArrayList<>();
        
        //Si el nombre no esta vacio se agrega a las condiciones
        if(nombre != null && !nombre.trim().isEmpty()){
            Pattern patron = Pattern.compile("^" + nombre, Pattern.CASE_INSENSITIVE);
            condiciones.add(regex("producto.nombre", patron));
        }
        
        //Si fechaDesde no esta vacia se agrega a las condiciones
        if(fechaDesde != null){
            condiciones.add(lte("fecha", fechaDesde));
        }
        
        //Si fechaHasta no esta vacia se agrega a las condiciones
        if(fechaHasta != null){
            condiciones.add(gte("fecha", fechaHasta));
        }
        
        /*
            Si la lista de condiciones esta vacia regresa un documento vacio(Llamara a todo)
            a todas las condiciones les pondra la condicional and()
        */
        Bson filtro = condiciones.isEmpty() ? new Document() : and(condiciones);
        
        //Guardamos los resultados del filtro
        FindIterable<Salida> resultados = coleccion.find(filtro);
        
        //Agregamos todas las salidas recogidas a la listaSalidas
        for (Salida resultado : resultados) {
            listaSalidas.add(resultado);
        }
        
        //Retornamos la listaSalidas
        return listaSalidas;
    }

}
