/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IVentaDAO;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Sorts;
import conexion.ConexionMongo;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Sebastian Moreno
 */
public class VentaMongoDAO implements IVentaDAO {

    private final MongoCollection<Venta> coleccion;

    public VentaMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Ventas", Venta.class);
    }

    @Override
    public Venta registrarVenta(Venta venta) throws PersistenciaException {
        try {
            

            // Asignar un nuevo _id si está en null
            if (venta.getId() == null) {
                venta.setId(new ObjectId().getTimestamp());
            }

            coleccion.insertOne(venta);
            return venta;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar la venta en la base de datos.", e);
        }
    }

    public Integer generarNuevoIdVenta() {
    // Este método debe consultar el último ID usado y sumarle 1.
    Venta ultimaVenta = coleccion.find()
        .sort(Sorts.descending("codigo"))
        .first();

    if (ultimaVenta != null) {
        return ultimaVenta.getId() + 1;
    } else {
        return 1; // primer ID
    }
}
    
    @Override
    public Venta consultarVenta(Integer id) throws PersistenciaException {
        try {
            return coleccion.find(eq("id", id)).first(); // Buscando por tu ID propio
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo consultar la venta por id del sistema.", e);
        }
    }

    @Override
    public List<ProductoVenta> consultarProductosVenta() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta consultarVentaPorTicket(String ticket) throws PersistenciaException {
        try {
            Integer id = Integer.parseInt(ticket); // convertir el ticket a Integer
            Venta venta = coleccion.find(eq("codigo", id)).first(); // buscar por el campo "id"
            return venta;
        } catch (NumberFormatException e) {
            throw new PersistenciaException("El número de ticket no es válido.", e);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo buscar la venta por ID.", e);
        }
    }

}
