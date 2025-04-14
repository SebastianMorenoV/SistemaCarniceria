/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.EmpleadoDAO;
import entidades.Empleado;
import Exception.PersistenciaException;

/**
 * Interfaz que implementa la DAO 
 * Se encarga de crear la DAO.
 * @author Sebastian Moreno
 */
public interface IEmpleadoDAO {

    static IEmpleadoDAO obtenerInstanciaDAO() {
        return new EmpleadoDAO(); // o podrías usar singleton aquí
    }

    public Empleado consultarEmpleadoPorNombre(String nombre) throws PersistenciaException;

    public Empleado consultarEmpleadoPorId(Long id) throws PersistenciaException;
}
