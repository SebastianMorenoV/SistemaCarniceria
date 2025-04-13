/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADAPTER.Empleado;

import DTOs.EmpleadoCargadoDTO;
import Entidades.Empleado;

/**
 *
 * @author HP
 */
public class adaptadorEmpleado implements IAdaptadorEmpleado{
    
    @Override
    public EmpleadoCargadoDTO convertirADTO(Empleado empleado) {
        EmpleadoCargadoDTO EmpleadoDTO = new EmpleadoCargadoDTO(empleado.getNombre());
        return EmpleadoDTO;
    }

    @Override
    public Empleado convertirAEntidad(EmpleadoCargadoDTO empleado) {
        Empleado empleadoEntidad = new Empleado();
        empleadoEntidad.setNombre(empleado.getNombre());
        return empleadoEntidad;
    }

    
}
