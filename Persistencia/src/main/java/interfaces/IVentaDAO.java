
package Interfaces;

import entidades.Venta;
import Exception.PersistenciaException;
import MONGO.DAOS.VentaMongoDAO;

/**
 * Esta clase representa la interfaz de la DAO Venta se encarga de crear la DAO.
 * Tiene metodos generales que utilizan las clases que implementan esta interfaz con la finalidad de
 * que si algun dia cambia la DAO , puedan remplazarlas sin que el sistema dependa de ellas.
 * @author Sebastian Moreno
 */
public interface IVentaDAO {

    static IVentaDAO obtenerInstanciaDAO() {
        return new VentaMongoDAO();
    }

    public Venta registrarVenta(Venta venta) throws PersistenciaException;

    public Venta consultarVenta(Integer id) throws PersistenciaException;

    public Venta consultarVentaPorTicket(String ticket) throws PersistenciaException;

    public boolean buscarVentaSinDevolucion(int codigoVenta) throws PersistenciaException;

    public boolean tieneDevolucionAsociada(int codigoVenta) throws PersistenciaException;

}
