package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IVentaDAO;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionMongo;
import entidades.Devolucion;
import entidades.Venta;
import org.bson.types.ObjectId;

/**
 * Representa una ventaDAO funcionando con la base de datos MongoDB para el registro y consultas de una venta.
 * @author Sebastian Moreno
 */
public class VentaMongoDAO implements IVentaDAO {

    private final MongoCollection<Venta> coleccion;

    public VentaMongoDAO() {
        this.coleccion = ConexionMongo.getDatabase().getCollection("Ventas", Venta.class);
    }
    
    /**
     * Este metodo registra una venta en la base de datos.
     * @param venta la venta a registrar 
     * @return una venta registrada para su conversion en otras capas.
     * @throws PersistenciaException  si la base de datos tiene un error al registrar.
     */
    @Override
    public Venta registrarVenta(Venta venta) throws PersistenciaException {
        try {
            if (venta.getId() == null) {
                venta.setId(new ObjectId().getTimestamp());
            }
            coleccion.insertOne(venta);
            return venta;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar la venta en la base de datos.", e);
        }
    }
    /**
     * Metodo para consultar una venta por su id 
     * @param id el id de la venta a consultar.
     * @return un objeto Venta consultado.
     * @throws PersistenciaException si exiten errores consultando la venta.
     */
    @Override
    public Venta consultarVenta(Integer id) throws PersistenciaException {
        try {
            return coleccion.find(eq("id", id)).first(); 
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo consultar la venta por id del sistema.", e);
        }
    }
 
    /**
     * Metodo para consultar una venta por el numero de su ticket.
     * @param ticket el identificador de el ticket relacionado con la venta.
     * @return un Objeto venta si existe.
     * @throws PersistenciaException  si no se encuentra la venta buscada.
     */
    @Override
    public Venta consultarVentaPorTicket(String ticket) throws PersistenciaException {
        try {
            Integer id = Integer.parseInt(ticket); 
            Venta venta = coleccion.find(eq("codigo", id)).first(); 
            return venta;
        } catch (NumberFormatException e) {
            throw new PersistenciaException("El número de ticket no es válido.", e);
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo buscar la venta por ID.", e);
        }
    }

    /**
     * Metodo auxiliar para buscar una venta sin devolucion
     *
     * @param codigoVenta
     * @return true si la venta no cuenta con una devolucion asociada. False si
     * la venta tiene una devolucion asociada
     * @throws PersistenciaException si existe algun error consultado.
     */
    @Override
    public boolean buscarVentaSinDevolucion(int codigoVenta) throws PersistenciaException {
        try {
            if (tieneDevolucionAsociada(codigoVenta)) {
                return false;  // Ya tiene devolución, no es válida para devolver
            }
            Venta venta = coleccion.find(eq("codigo", codigoVenta)).first();
            return venta != null;
        } catch (Exception e) {
            // Puedes personalizar el mensaje de la excepción o el tipo según convenga
            throw new PersistenciaException("Error al consultar la venta sin devolución: " + e.getMessage(), e);
        }
    }

    /**
     * Metodo auxiliar para validar si una venta tiene devolucion asociada.
     *
     * @param codigoVenta el codigo de la venta a buscar.
     * @return true si tiene devolucion asociada , false caso contrario.
     * @throws PersistenciaException si ocurre un error consultando la
     * devolucion.
     */
    @Override
    public boolean tieneDevolucionAsociada(int codigoVenta) throws PersistenciaException {
        try {
            MongoCollection<Devolucion> coleccionDevoluciones = ConexionMongo.getDatabase().getCollection("Devolucion", Devolucion.class);
            Devolucion devolucion = coleccionDevoluciones.find(eq("venta.codigo", codigoVenta)).first();
            return devolucion != null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al verificar devolución asociada: " + e.getMessage(), e);
        }
    }
}
