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
 * Esta clase permite realizar operaciones de persistencia y consulta sobre la coleccion de
 * proveedores.
 *
 * Usa la coleccion "Proveedores" en la base de datos Mongo.
 *
 * Las operaciones disponibles son agregar un proveedor, consultar todos los
 * proveedores, y buscar un proveedor por su nombre.
 *
 * @author Admin
 */
public class ProveedorMongoDAO implements IProveedorDAO{
    /**
     * Se declara coleccion como la coleccion "Proveedores" de la BD.
     *
     */
    private final MongoCollection<Proveedor> coleccion;
    /**
     * Crea una nueva instancia de ProveedorMongoDAO y obtiene la coleccion de
     * proveedores desde la base de datos Mongo.
     */
    public ProveedorMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Proveedores", Proveedor.class);
    }

    /**
     * Metodo para agregar un proveedor a la base de datos.
     * Si el proveedor no tiene un id asignado, se le genera uno automaticamente.
     * Luego se inserta en la coleccion "Proveedor" y es agregado exitosamente a la BD.
     * 
     * @param proveedor el proveedor que se desea agregar
     * @return el proveedor agregado ya con su id asignado
     * @throws PersistenciaException si ocurre un error al insertar el proveedor
     */
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

    /**
     * Metodo que consulta y devuelve todos los proveedores almacenados en la BD.
     *
     * @return una lista con todos los proveedores
     * @throws PersistenciaException si ocurre un error al consultar los proveedores
     */
    @Override
    public List<Proveedor> consultarProveedores() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar proveedores: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Metodo para buscar un proveedor por su nombre exacto.
     *
     * @param nombre el nombre del proveedor a buscar
     * @return el proveedor encontrado, o null si no se encuentra
     * @throws PersistenciaException si ocurre un error durante la busqueda
     */
    @Override
    public Proveedor buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            return coleccion.find(eq("nombre", nombre)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar proveedor por nombre: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Metodo auxiliar para pruebas unitarias: elimina todos los proveedores insertados de prueba de la coleccion.
     */
    public void limpiarColeccion() {
        coleccion.deleteMany(new org.bson.Document());
    }

    
}
