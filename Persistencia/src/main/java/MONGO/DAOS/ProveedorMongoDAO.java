/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IProveedorDAO;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionMongo;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Admin
 */
public class ProveedorMongoDAO implements IProveedorDAO{
    
    private final MongoCollection<Proveedor> coleccion;

    public ProveedorMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Proveedores", Proveedor.class);
    }

    @Override
    public Proveedor agregarProveedor(Proveedor proveedor) throws PersistenciaException {
        try {
            // Asignar un nuevo _id si esta en null
            if (proveedor.getId() == null) {
                proveedor.setId(new ObjectId());
            }

            coleccion.insertOne(proveedor);
            return proveedor;
        } catch (Exception e) {
            throw new PersistenciaException("Error al agregar proveedor: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Proveedor> consultarProveedores() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar proveedores: " + e.getLocalizedMessage());
        }
    }
    
    @Override
    public Proveedor buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            return coleccion.find(eq("nombre", nombre)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar proveedor por nombre: " + e.getLocalizedMessage());
        }
    }

    
}
