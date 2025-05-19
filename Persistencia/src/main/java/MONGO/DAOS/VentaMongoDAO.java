/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IVentaDAO;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class VentaMongoDAO implements IVentaDAO {

        private final MongoCollection<Venta> coleccion;
        
        public VentaMongoDAO(){
        this.coleccion = ConexionMongo.getDatabase().getCollection("Ventas",Venta.class);
        }

    
    @Override
    public Venta registrarVenta(Venta venta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta consultarVenta(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoVenta> consultarProductosVenta() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta consultarVentaPorTicket(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
