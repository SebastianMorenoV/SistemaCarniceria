/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadoresBO;

import BO.DevolucionBO;
import BO.EmpleadoBO;
import BO.EntradaBO;
import BO.GastoBO;
import BO.ProductoBO;
import BO.ProveedorBO;
import BO.SalidaBO;
import BO.VentaBO;
import DAOS.VentaDAO;
import Interfaces.ICrearVentaBO;
import Interfaces.IDevolucionBO;
import Interfaces.IEmpleadoBO;
import Interfaces.IEntradaBO;
import Interfaces.IGastoBO;
import Interfaces.IProductoBO;
import Interfaces.IProveedorBO;
import Interfaces.ISalidaBO;
import Interfaces.IVentaBO;
import Interfaces.IVentaDAO;
import fabrica.CreadorDAO;
import fabrica.ICreadorDAO;

/**
 *
 * @author Admin
 */
public class ManejadorObjetosNegocio {

    public static IVentaBO crearVentasBO() {

        ICreadorDAO fabrica = new CreadorDAO();
        return new VentaBO(fabrica);

    }

    public static IProductoBO crearProductoBO() {

        ICreadorDAO fabrica = new CreadorDAO();
        return new ProductoBO(fabrica);

    }

    public static IEmpleadoBO crearEmpleadoBO() {

        ICreadorDAO fabrica = new CreadorDAO();
        return new EmpleadoBO(fabrica);

    }

    public static IDevolucionBO crearDevolucionesBO() {

        ICreadorDAO fabrica = new CreadorDAO();
        return new DevolucionBO(fabrica);

    }

    public static IGastoBO crearGastoBO() {
        ICreadorDAO fabrica = new CreadorDAO();
        return new GastoBO(fabrica);
    }
    
    public static IProveedorBO crearProveedorBO(){
        ICreadorDAO fabrica = new CreadorDAO();
        return new ProveedorBO(fabrica);
    }
    
    public static IEntradaBO crearEntradaBO(){
        ICreadorDAO fabrica = new CreadorDAO();
        return new EntradaBO(fabrica);
    }
    
    public static ISalidaBO crearSalidaBO(){
        ICreadorDAO fabrica = new CreadorDAO();
        return new SalidaBO(fabrica);
    }
    

}
