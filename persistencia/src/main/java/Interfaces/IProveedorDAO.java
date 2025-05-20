/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.ProveedorDAO;
import Exception.PersistenciaException;
import entidades.Proveedor;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Admin
 */
public interface IProveedorDAO {
    
    static IProveedorDAO obtenerInstanciaDAO() {
        return new ProveedorDAO(); // o podrías usar singleton aquí
    }
    
    public Proveedor agregarProveedor(Proveedor proveedor) throws PersistenciaException;
    
    public List<Proveedor> consultarProveedores() throws PersistenciaException;
    
    public Proveedor buscarPorNombre(String nombre) throws PersistenciaException;
}
