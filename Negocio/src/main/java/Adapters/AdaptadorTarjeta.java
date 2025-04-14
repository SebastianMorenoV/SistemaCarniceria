/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import IAdapters.IAdaptadorVenta;
import IAdapters.IAdaptadorEmpleadoEntidadAEmpleadoDTO;
import DTOs.CrearVentaDTO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.VentaDTO;
import Entidades.Empleado;
import Entidades.Venta;

/**
 *
 * @author Sebastian Moreno
 */
public class AdaptadorTarjeta implements IAdaptadorVenta {

    IAdaptadorEmpleadoEntidadAEmpleadoDTO adaptador; //Llamada al adaptador de Empleado
    
    @Override
    public VentaDTO convertirADTO(Venta venta) {
        EmpleadoCargadoDTO empleado = adaptador.convertirADTO(venta.getCajero());
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setEmpleado(empleado);
        ventaDTO.setIva(venta.getIva());
        ventaDTO.setFechaHora(venta.getFechaHora());
        // se ocupa otro mapper.
        //ventaDTO.setListadoProductosVenta(listadoProductosVenta);
        ventaDTO.setTotal(venta.getTotal());
        venta.setSubtotal(venta.getSubtotal());
        
        return ventaDTO;
    }
    
    @Override
    public Venta convertirAVenta(VentaDTO ventaDTO) {
        Empleado empleado = adaptador.convertirAEntidad(ventaDTO.getEmpleado());
        
        // falta la lista de productos. 
        Venta venta = new Venta();
        venta.setCajero(empleado);
        venta.setFechaHora(ventaDTO.getFechaHora());
        venta.setIva(ventaDTO.getIva());
        venta.setSubtotal(ventaDTO.getSubtotal());
        venta.setTotal(ventaDTO.getTotal());
        
        return venta;
    }

    @Override
    public CrearVentaDTO VentaACrearVentaDTO(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta CrearVentaDTOAVenta(CrearVentaDTO ventaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
