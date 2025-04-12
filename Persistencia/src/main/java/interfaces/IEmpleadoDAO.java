/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Empleado;
import Exception.PersistenciaException;

/**
 * 
 * @author Sebastian Moreno
 */
public interface IEmpleadoDAO {

    public Empleado consultarEmpleadoPorNombre(String nombre) throws PersistenciaException;

    public Empleado consultarEmpleadoPorId(Long id) throws PersistenciaException;
}
