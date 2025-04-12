/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.EmpleadoCargadoDTO;
import adapters.IAdaptadorEmpleadoEntidadAEmpleadoDTO;

/**
 *
 * @author HP
 */
public class EmpleadoBO implements IAdaptadorEmpleadoEntidadAEmpleadoDTO {
    public IAdaptadorEmpleadoEntidadAEmpleadoDTO EmpleadoDAO;

    @Override
    public EmpleadoCargadoDTO IAdaptadorEmpleadoEntidadAEmpleadoDTO(EmpleadoCargadoDTO empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EmpleadoCargadoDTO convertirEmpleadoDTOAempleadoEntidad(EmpleadoCargadoDTO empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    
}
