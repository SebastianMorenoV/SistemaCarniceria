package fabrica;

import DAOS.VentaDAO;
import DAOS.*;
import Interfaces.*;
import MONGO.DAOS.DevolucionMongoDAO;
import MONGO.DAOS.SalidasMongoDAO;

/**
 * Esta clase Fabrica se encarga de crear objetos DAO.
 *
 * @author Admin
 */
public class CreadorDAO implements ICreadorDAO {

    @Override
    public IEmpleadoDAO crearEmpleadoDAO() {
        return new EmpleadoDAO(); // devuelve la implementación concreta
    }

    @Override
    public IVentaDAO crearVentaDAO() {
        return new VentaDAO();
    }

    @Override
    public IProductoVentaDAO crearProductoVentaDAO() {
        return new ProductoVentaDAO();
    }

    @Override
    public IProductoDAO crearProductoDAO() {
        return new ProductoDAO();
    }

    @Override
    public IPagoDAO crearPagoDAO() {
        return new PagoDAO();
    }

    @Override
    public IDevolucionDAO crearDevolucionDAO() {
        return new DevolucionMongoDAO();
    }

    @Override
    public IGastoDAO crearGastoDAO() {
        return new GastoDAO();
    }

    @Override
    public IProveedorDAO crearProveedorDAO() {
        return new ProveedorDAO();
    }

    @Override
    public IEntradaDAO crearEntradaDAO() {
        return new EntradaDAO();
    }

    @Override
    public ISalidaDAO crearSalidaDAO() {
        return new SalidasMongoDAO();
    }
    
    

}
