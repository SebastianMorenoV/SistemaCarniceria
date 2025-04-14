/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import IAdapters.IAdaptadorEmpleado;
import DTOs.EmpleadoCargadoDTO;
import entidades.Empleado;

/**
 *
 * @author HP
 */
public class AdaptadorEmpleado implements IAdaptadorEmpleado{
    
    @Override
    public EmpleadoCargadoDTO convertirADTO(Empleado empleado) {
        EmpleadoCargadoDTO EmpleadoDTO = new EmpleadoCargadoDTO(empleado.getNombre(),empleado.getCargo());
        return EmpleadoDTO;
    }

    @Override
    public Empleado convertirAEntidad(EmpleadoCargadoDTO empleado) {
        Empleado empleadoEntidad = new Empleado(empleado.getNombre(),empleado.getCargo());
        return empleadoEntidad;
    }

    
}
