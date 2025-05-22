/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.NuevoEfectivoDTO;
import IAdapters.IAdaptadorMetodoPago;
import entidades.Efectivo;
import entidades.MetodoPago;
import entidades.Tarjeta;

/**
 *
 * @author HP
 */
public class AdaptadorMetodoPago implements IAdaptadorMetodoPago {
    
    @Override
    public MetodoPagoDTO convertirTarjetaADTO(MetodoPago metodoPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MetodoPago convertirTarjetaDTOAEntidad(MetodoPago metodoPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MetodoPagoDTO convertirEfectivoADTO(MetodoPago metodoPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MetodoPago convertirEfectivoAEntidad(MetodoPago metodoPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MetodoPagoDTO convertirADTO(MetodoPago metodoPago) {
        MetodoPagoDTO dto = new MetodoPagoDTO();
        if (metodoPago.getEfectivo() != null) {
            dto.setNuevoEfectivo(new NuevoEfectivoDTO());
        } else {
            dto.setNuevaTarjeta(new NuevaTarjetaDTO());
        }

        return dto;
    }

    @Override
    public MetodoPago convertirAEntidad(MetodoPagoDTO metodoPagoDTO) {
        MetodoPago metodoPago = new MetodoPago();
        if (metodoPagoDTO.getNuevoEfectivo() != null) {
            Efectivo efectivo = new Efectivo();
            efectivo.setMonto(metodoPagoDTO.getNuevoEfectivo().getPagoCon());
            metodoPago.setEfectivo(efectivo);
        } else {
            metodoPago.setTarjeta(new Tarjeta());
        }
        return metodoPago;  
    }
 
}
