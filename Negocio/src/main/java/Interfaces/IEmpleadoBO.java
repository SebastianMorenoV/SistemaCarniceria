/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.EmpleadoCargadoDTO;
import Exception.NegocioException;

/**
 *
 * @author Sebastian Moreno
 */
public interface IEmpleadoBO {
     public EmpleadoCargadoDTO consultarEmpleado() throws NegocioException;
}
