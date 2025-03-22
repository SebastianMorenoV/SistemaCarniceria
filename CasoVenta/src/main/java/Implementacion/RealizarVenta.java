/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacion;

import DTOs.EmpledoCargadoDTO;

/**
 *
 * @author Lap-064
 */
public class RealizarVenta implements IRealizarVenta {

    @Override
    public EmpledoCargadoDTO cargarEmpleado() {
        return new EmpledoCargadoDTO("Juan Soto");
    }

}
