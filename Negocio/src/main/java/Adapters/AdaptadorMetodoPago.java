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
    /*
    @Override
        public MetodoPagoDTO convertirTarjetaADTO(MetodoPago metodoPago) {

        MetodoPagoDTO metodoTarjetaDTO = new MetodoPagoDTO();
        NuevaTarjetaDTO TarjetaDTO = metodoTarjetaDTO.getNuevaTarjeta();
        Tarjeta Tarjeta = metodoPago.getTarjeta();
        TarjetaDTO.setTitular(Tarjeta.getNombreTitular()); 
        TarjetaDTO.setNumeroTarjeta(Tarjeta.getNumeroTarjeta()); 
        TarjetaDTO.setFechaVencimiento(Tarjeta.getFechaVencimiento()); 
        TarjetaDTO.setCvv(Tarjeta.getCvv());
        metodoTarjetaDTO.setNuevaTarjeta(TarjetaDTO);
        metodoPago.setTarjeta(metodoPago.getTarjeta());
        
        return metodoTarjetaDTO;
    }

    @Override
    public MetodoPago convertirTarjetaDTOAEntidad(MetodoPago metodoPago) {
        
        MetodoPagoDTO metodoTarjetaDTO = new MetodoPagoDTO();
        NuevaTarjetaDTO TarjetaDTO = metodoTarjetaDTO.getNuevaTarjeta();
        Tarjeta Tarjeta = metodoPago.getTarjeta();
        Tarjeta.setNombreTitular(TarjetaDTO.getTitular()); 
        Tarjeta.setNumeroTarjeta(TarjetaDTO.getNumeroTarjeta()); 
        Tarjeta.setFechaVencimiento(TarjetaDTO.getFechaVencimiento()); 
        Tarjeta.setCvv(TarjetaDTO.getCvv());
        metodoPago.setTarjeta(Tarjeta);
        return metodoPago;
    }

    @Override
    public MetodoPagoDTO convertirEfectivoADTO(MetodoPago metodoPago) {
        
        MetodoPagoDTO metodoEfectivoDTO = new MetodoPagoDTO();
        NuevoEfectivoDTO EfectivoDTO = metodoEfectivoDTO.getNuevoEfectivo();
        Efectivo Efectivo= metodoPago.getEfectivo();  
        EfectivoDTO.setMonto(Efectivo.getMonto());
        EfectivoDTO.setPagoCon((Efectivo.getMonto()+Efectivo.getCambio()));     
        metodoEfectivoDTO.setNuevoEfectivo(EfectivoDTO);
        return metodoEfectivoDTO;
    }

    @Override
    public MetodoPago convertirEfectivoAEntidad(MetodoPago metodoPago) {
        
        MetodoPago MetodoPagoEntidad = new MetodoPago();
        MetodoPagoDTO metodoEfectivoDTO = new MetodoPagoDTO();
        NuevoEfectivoDTO EfectivoDTO = metodoEfectivoDTO.getNuevoEfectivo();
        Efectivo Efectivo= metodoPago.getEfectivo();  
        Efectivo.setMonto(EfectivoDTO.getMonto());
        Efectivo.setCambio((EfectivoDTO.getMonto() - EfectivoDTO.getPagoCon()));     
        MetodoPagoEntidad.setEfectivo(Efectivo);
        return MetodoPagoEntidad;
}
     */
}
