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
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
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
public class ProductoMongoDAO implements IProductoDAO {

    private final MongoCollection<Producto> coleccion;

    public ProductoMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Productos", Producto.class);
    }

    @Override
    public List<Producto> consultarProductos() throws PersistenciaException {
        try {
            List<Producto> productos = new ArrayList<>();
            FindIterable<Producto> resultados = coleccion.find();

            for (Producto producto : resultados) {
                productos.add(producto);
            }

            return productos;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron consultar los productos", e);
        }
    }

    @Override
    public Producto agregarProducto(Producto producto) throws PersistenciaException {
        try {
            if (producto.getId() == null || producto.getId() == 0) {
                producto.setId(new  ObjectId().getTimestamp());
            }
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
        if (nombre != null && !nombre.trim().isEmpty()) {
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
    
    @Override
    public List<Producto> buscarPorNombre(String textoBusqueda) throws PersistenciaException {
        try {
            List<Producto> productosEncontrados = new ArrayList<>();

            if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
                // Si no hay texto de búsqueda, regresamos todos los productos
                return consultarProductos();
            }

            // Normalizamos el texto de búsqueda: minúsculas y sin espacios
            String textoNormalizado = textoBusqueda.toLowerCase().replaceAll("\\s+", "");

            // Obtenemos todos los productos para aplicar la lógica de comparación en Java
            List<Producto> todos = consultarProductos();

            for (Producto p : todos) {
                String infoProducto = p.getId() + " " + p.getNombre() + " " + p.getDescripcion() + " $" + p.getPrecio();
                String productoNormalizado = infoProducto.toLowerCase().replaceAll("\\s+", "");

                if (productoNormalizado.contains(textoNormalizado)) {
                    productosEncontrados.add(p);
                }
            }

            return productosEncontrados;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo buscar el producto por nombre", e);
        }
    }
    
        @Override
    public boolean restarStockAProducto(Double salida, Integer codigo) throws PersistenciaException {
        try {
            // Filtro para encontrar el producto que deseas actualizar (ajusta según tu criterio)
            Bson filtro = Filters.eq("codigo", codigo);

             // Operación de decremento
            Bson actualizacion = Updates.inc("stock",-(salida));

            // Ejecutar la actualización
            UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);
        
            return resultado.getModifiedCount() > 0;
        
        } catch (Exception e) {
            throw new PersistenciaException("Error al restarle el stock al producto", e);
        }
    } 


}
