/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAOS;

import Exception.PersistenciaException;
import Interfaces.IProveedorDAO;
import entidades.Entrada;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ProveedorDAO implements IProveedorDAO{
    private List<Proveedor> listaProveedores = new ArrayList<>();
    private static ProveedorDAO instanceProveedorDAO;
    
    public ProveedorDAO(){
        
    }
    public static ProveedorDAO getInstanciaDAO(){
        if(instanceProveedorDAO == null){
            instanceProveedorDAO = new ProveedorDAO();
        }
        return instanceProveedorDAO;
    }

    @Override
    public Proveedor registrarProveedor(Proveedor proveedor) {
        listaProveedores.add(proveedor);
        return proveedor;
    }

    @Override
    public List<Proveedor> ConsultarProveedores() throws PersistenciaException {
        return this.listaProveedores;
    }
    
}
