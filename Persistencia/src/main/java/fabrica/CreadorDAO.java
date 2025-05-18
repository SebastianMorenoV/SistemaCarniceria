package fabrica;

import DAOS.VentaDAO;
import DAOS.*;
import Interfaces.*;

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
    public ICrearVentaDAO CrearVentaDAO() {
        return new CrearVentaDAO();
    }

    @Override
    public IDevolucionDAO crearDevolucionDAO() {
        return new DevolucionDAO();
    }

    @Override
    public IGastoDAO crearGastoDAO() {
        return new GastoDAO();
    }

    @Override
    public IProveedorDAO crearProveedorDAO() {
        return new ProveedorDAO();
<<<<<<< Updated upstream
    }
=======
    }  

    @Override
    public IEntradaDAO crearEntradaDAO() {
        return new EntradaDAO();}
>>>>>>> Stashed changes
}
