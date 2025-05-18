/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adapters;

import DTOs.EmpleadoCargadoDTO;
import DTOs.EntradaDTO;
import DTOs.ProveedorDTO;
import IAdapters.IAdaptadorEntrada;
import entidades.Empleado;
import entidades.Entrada;
import entidades.Proveedor;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorEntrada implements IAdaptadorEntrada{

    @Override
    public EntradaDTO convertirADTO(Entrada entrada) {
        AdaptadorEmpleado empleado = new AdaptadorEmpleado();    
        EmpleadoCargadoDTO empleadoDTO = empleado.convertirADTO(entrada.getEmpleado());
        AdaptadorProveedor proveedor = new AdaptadorProveedor();
        ProveedorDTO proveedorDTO = proveedor.ConvertirADTO(entrada.getProveedor());
        EntradaDTO entradaDTO = new EntradaDTO();
        entradaDTO.setId(entrada.getId());
        entradaDTO.setFechaHora(entrada.getFechaHora());
        entradaDTO.setEmpleado(empleadoDTO);
        entradaDTO.setListaProductosEntrada(entrada.getListaProductosEntrada());
        entradaDTO.setProveedor(proveedorDTO);
        return entradaDTO;
    }

    @Override
    public Entrada convertirAEntidad(EntradaDTO entrada) {
        AdaptadorEmpleado empleado = new AdaptadorEmpleado();    
        Empleado empleadoEntidad = empleado.convertirAEntidad(entrada.getEmpleado());
        AdaptadorProveedor proveedor = new AdaptadorProveedor();
        Proveedor proveedorEntidad = proveedor.ConvertirAEntidad(entrada.getProveedor());
        
        Entrada entradaEntidad = new Entrada();
        entradaEntidad.setId(entrada.getId());
        entradaEntidad.setFechaHora(entrada.getFechaHora());
        entradaEntidad.setEmpleado(empleadoEntidad);
        entradaEntidad.setListaProductosEntrada(entrada.getListaProductosEntrada());
        entradaEntidad.setProveedor(proveedorEntidad);
        return entradaEntidad;
    }
    
}
