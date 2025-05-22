/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IEntradaDAO;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import entidades.Entrada;
import entidades.Producto;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Sebastian Moreno
 */
public class EntradaMongoDAO implements IEntradaDAO{
     private final MongoCollection<Entrada> coleccion;

    public EntradaMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Entradas", Entrada.class);
    }
    
     @Override
    public Entrada registrarEntrada(Entrada entrada) throws PersistenciaException {
        try {
            // Asignar un nuevo _id si está en null
            if (entrada.getId() == null || entrada.getId() == 0) {
                entrada.setId(new ObjectId().getTimestamp());
            }
            coleccion.insertOne(entrada);
            return entrada;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar la devolución.", e);
        }
    }

    @Override
    public List<Producto> ConsultarProductos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
