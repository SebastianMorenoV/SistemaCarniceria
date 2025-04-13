/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fabrica;

import Interfaces.IEmpleadoDAO;
import Interfaces.IPagoDAO;
import Interfaces.IProductoDAO;
import Interfaces.IProductoVentaDAO;
import Interfaces.IVentaDAO;

/**
 * Esta clase representa una fabrica de DAOS Mock.
 * Asi la BO no sabe que tipo de DAO esta creando simplemente habla a esta clase y esta clase se los da.
 * @author Sebastian Moreno
 */
public interface ICreadorDAO {
    
    IEmpleadoDAO crearEmpleadoDAO();

    IVentaDAO crearVentaDAO();

    IProductoVentaDAO crearProductoVentaDAO();
    
    IProductoDAO crearProductoDAO();
    
    IPagoDAO crearPagoDAO();
}
