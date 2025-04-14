/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import ADAPTER.Empleado.IAdaptadorEmpleado;
import ADAPTER.Empleado.adaptadorEmpleado;
import DTOs.EmpleadoCargadoDTO;
import ADAPTERS.IAdaptadorEmpleadoEntidadAEmpleadoDTO;
import Entidades.Empleado;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IEmpleadoBO;
import Interfaces.IEmpleadoDAO;
import fabrica.ICreadorDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class EmpleadoBO implements IEmpleadoBO{

    public IAdaptadorEmpleado adapterEmpleado;
    //atributo referenciando a la fabrica
    private final IEmpleadoDAO empleadoDAO;

    public EmpleadoBO(ICreadorDAO fabrica) {
        this.empleadoDAO = fabrica.crearEmpleadoDAO();
        this.adapterEmpleado =  new adaptadorEmpleado();
    }

    @Override
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
        public EmpleadoCargadoDTO registrarEmpleado(EmpleadoCargadoDTO empleado){
            Empleado empleado1 = adapterEmpleado.convertirAEntidad(empleado);
            System.out.println(empleado1);
            EmpleadoCargadoDTO empleadoReturn = adapterEmpleado.convertirADTO(empleado1);
            return empleadoReturn;
        }
        
    }

