package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IProductoDAO;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Aggregates.match;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import conexion.ConexionMongo;
import entidades.Producto;
import entidades.Salida;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author janot
 */
public class ProductoMongoDAO implements IProductoDAO{
    private final MongoCollection<Producto> coleccion;

    public ProductoMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Productos", Producto.class);
    }
    
    @Override
    public List<Producto> consultarProductos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto agregarProducto(Producto producto) throws PersistenciaException {
        try {
            if (producto.getId() == null) {
                producto.setId(new ObjectId().getTimestamp());
            }
            
            System.out.println(producto.getId() + "Persistencia");
            coleccion.insertOne(producto);
            return producto;
            
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar una nueva salida", e);
        }
    }

    @Override
    public List<Producto> buscadorProducto(String nombre) throws PersistenciaException {
        List<Producto> listaProductos = new ArrayList<>();

        //Lista que guardara las condiciones
        List<Bson> condiciones = new ArrayList<>();
        
        //Si el nombre no esta vacio se agrega a las condiciones
        if(nombre != null && !nombre.trim().isEmpty()){
            Pattern patron = Pattern.compile("^" + nombre, Pattern.CASE_INSENSITIVE);
            condiciones.add(regex("nombre", patron));
        }
        
        /*
            Si la lista de condiciones esta vacia regresa un documento vacio(Llamara a todo)
            a todas las condiciones les pondra la condicional and()
        */
        Bson filtro = condiciones.isEmpty() ? new Document() : and(condiciones);
        
        //Guardamos los resultados del filtro
        FindIterable<Producto> resultados = coleccion.find(filtro);
        
        //Agregamos todas las salidas recogidas a la listaSalidas
        for (Producto resultado : resultados) {
            listaProductos.add(resultado);
        }
        
        //Retornamos la listaSalidas
        return listaProductos;
    }
    
}
