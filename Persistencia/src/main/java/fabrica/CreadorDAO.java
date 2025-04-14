/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import DAOS.*;
import Interfaces.*;

/**
 * Esta clase Fabrica se encarga de crear objetos DAO.
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
}

