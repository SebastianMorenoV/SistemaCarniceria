/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.NuevoEfectivoDTO;
import Entidades.Efectivo;
import Entidades.MetodoPago;
import Entidades.Tarjeta;

/**
 *
 * @author HP
 */
public class adaptadorMetodoPago /*implements IAdaptadorMetodoPago*/ {
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
