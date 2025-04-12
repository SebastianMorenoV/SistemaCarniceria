/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adapters;

import DTOs.EmpleadoCargadoDTO;

import DTOs.ProductoCargadoDTO;

/**
 *
 * @author HP
 */
public interface IAdaptadorEmpleadoEntidadAEmpleadoDTO {
    public EmpleadoCargadoDTO IAdaptadorEmpleadoEntidadAEmpleadoDTO(EmpleadoCargadoDTO empleado);
    public EmpleadoCargadoDTO convertirEmpleadoDTOAempleadoEntidad(EmpleadoCargadoDTO empleado);

}
