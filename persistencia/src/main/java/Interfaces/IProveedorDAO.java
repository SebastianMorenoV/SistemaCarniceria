/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.ProveedorDAO;
import Exception.PersistenciaException;
import entidades.Proveedor;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IProveedorDAO {
    static IProveedorDAO obtenerIntanciaDAO(){
        return new ProveedorDAO();
    }
    public Proveedor registrarProveedor(Proveedor proveedor)throws PersistenciaException ;
    public List<Proveedor> ConsultarProveedores() throws PersistenciaException; 
}
