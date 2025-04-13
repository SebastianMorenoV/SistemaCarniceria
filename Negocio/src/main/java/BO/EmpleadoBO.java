/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.EmpleadoCargadoDTO;
import ADAPTERS.IAdaptadorEmpleadoEntidadAEmpleadoDTO;
import Entidades.Empleado;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IEmpleadoDAO;
import fabrica.ICreadorDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class EmpleadoBO {

    public IAdaptadorEmpleadoEntidadAEmpleadoDTO EmpleadoDAO;
    //atributo referenciando a la fabrica
    private final IEmpleadoDAO empleadoDAO;

    public EmpleadoBO(ICreadorDAO fabrica) {
        this.empleadoDAO = fabrica.crearEmpleadoDAO();
    }

    public EmpleadoCargadoDTO consultarEmpleado() throws NegocioException {
        EmpleadoCargadoDTO empleadoDTO = new EmpleadoCargadoDTO();
        Empleado empleado;
        try {
            empleado = empleadoDAO.consultarEmpleadoPorNombre("Juanito");
            empleadoDTO.setNombre(empleado.getNombre());
            empleadoDTO.setCargo(empleado.getCargo());
            return empleadoDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo consultar el empleado: " + ex.getMessage());
        }

    }

}
