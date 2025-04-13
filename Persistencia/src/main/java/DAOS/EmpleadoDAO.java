/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Empleado;
import Exception.PersistenciaException;
import Interfaces.IEmpleadoDAO;

/**
 * 
 * @author Sebastian Moreno
 */
public class EmpleadoDAO implements IEmpleadoDAO{

    @Override
    public Empleado consultarEmpleadoPorNombre(String nombre) throws PersistenciaException {
       
       return new Empleado(nombre, "Cajero");
    }

    @Override
    public Empleado consultarEmpleadoPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
