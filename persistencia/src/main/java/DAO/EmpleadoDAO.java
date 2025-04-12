/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTOs.EmpleadoCargadoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class EmpleadoDAO {
    
    public List<EmpleadoCargadoDTO> cargarEmpleados() {
    List<EmpleadoCargadoDTO> listaEmpleados = new ArrayList<>();

    listaEmpleados.add(new EmpleadoCargadoDTO("Juan Pérez"));
    listaEmpleados.add(new EmpleadoCargadoDTO("Ana Gómez"));
    listaEmpleados.add(new EmpleadoCargadoDTO("Carlos Ruiz"));
    listaEmpleados.add(new EmpleadoCargadoDTO("María Torres"));
    listaEmpleados.add(new EmpleadoCargadoDTO("Lucía Fernández"));

    return listaEmpleados;
}

}
