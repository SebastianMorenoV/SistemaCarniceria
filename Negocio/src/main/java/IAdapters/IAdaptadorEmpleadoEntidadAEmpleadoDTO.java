/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.EmpleadoCargadoDTO;

import DTOs.ProductoCargadoDTO;
import Entidades.Empleado;

/**
 *
 * @author HP
 */
public interface IAdaptadorEmpleadoEntidadAEmpleadoDTO {
    public EmpleadoCargadoDTO convertirADTO(Empleado empleado);
    public Empleado convertirAEntidad(EmpleadoCargadoDTO empleado);

}
