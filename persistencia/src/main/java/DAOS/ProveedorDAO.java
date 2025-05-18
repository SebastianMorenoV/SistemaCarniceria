/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Exception.PersistenciaException;
import entidades.Proveedor;
import Interfaces.IProveedorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Admin
 */
public class ProveedorDAO implements IProveedorDAO {

    @Override
    public Proveedor agregarProveedor(Proveedor proveedor) throws PersistenciaException {
        try {
            return new Proveedor("MrSteaks777", "141223");
        } catch (Exception e) {
            throw new PersistenceException("Proveedor no se agrego" + e.getMessage());
        }

    }
    
    @Override
    public List<Proveedor> consultarProveedores() throws PersistenciaException {
        try {
            List<Proveedor> proveedores = new ArrayList<>();
            proveedores.add(new Proveedor("MrSteaks777", "141223"));
            proveedores.add(new Proveedor("Carniceria Don Filete", "5345123"));
            proveedores.add(new Proveedor("Distribuidora El Chuletón", "5344323"));
            return proveedores;
        } catch (Exception e) {
            throw new PersistenceException("No se pudieron consultar los proveedores: " + e.getMessage());
        }
    }


}
