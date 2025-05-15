/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadoresBO;

import BO.CrearVentaBO;
import BO.DevolucionBO;
import BO.EmpleadoBO;
import BO.ProductoBO;
import BO.VentaBO;
import DAOS.VentaDAO;
import Interfaces.ICrearVentaBO;
import Interfaces.IDevolucionBO;
import Interfaces.IEmpleadoBO;
import Interfaces.IProductoBO;
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

    public static ICrearVentaBO crearVentaBO() {

        ICreadorDAO fabrica = new CreadorDAO();
        return new CrearVentaBO(fabrica);

    }

    public static IDevolucionBO crearDevolucionesBO() {

        ICreadorDAO fabrica = new CreadorDAO();
        return new DevolucionBO(fabrica);

    }

}
