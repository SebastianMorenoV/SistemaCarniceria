package fabrica;

import MONGO.DAOS.ProductoMongoDAO;
import DAOS.*;
import Interfaces.*;
import MONGO.DAOS.DevolucionMongoDAO;
import MONGO.DAOS.GastoMongoDAO;
import MONGO.DAOS.ProveedorMongoDAO;
import MONGO.DAOS.SalidasMongoDAO;
import MONGO.DAOS.VentaMongoDAO;

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
        return new VentaMongoDAO();
    }

    @Override
    public IProductoVentaDAO crearProductoVentaDAO() {
        return new ProductoVentaDAO();
    }

    @Override
    public IProductoDAO crearProductoDAO() {
        return new ProductoMongoDAO();
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
        return new GastoMongoDAO();
    }

    @Override
    public IProveedorDAO crearProveedorDAO() {
        return new ProveedorMongoDAO();
    }

    @Override
    public IEntradaDAO crearEntradaDAO() {
        return new EntradaDAO();
    }

    @Override
    public ISalidaDAO crearSalidaDAO() {
        return new SalidasMongoDAO();
    }

    @Override
    public IProductoDAO crearProductoMokosDAO() {
        return new ProductoDAO();
    }

}
