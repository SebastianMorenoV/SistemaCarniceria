/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADAPTERS.Venta;

import ADAPTERS.IAdaptadorEmpleadoEntidadAEmpleadoDTO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.VentaDTO;
import Entidades.Empleado;
import Entidades.Venta;

/**
 *
 * @author Sebastian Moreno
 */
public class AdaptadorVenta implements IAdaptadorVenta {

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
    
}
