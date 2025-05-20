/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.MetodoPagoDTO;
import DTOs.PagoNuevoDTO;
import DTOs.PagoViejoDTO;
import IAdapters.IAdaptadorMetodoPago;
import IAdapters.IAdaptadorPago;
import entidades.MetodoPago;
import entidades.Pago;


/**
 *
 * @author HP
 */
public class AdaptadorPago implements IAdaptadorPago{
    private IAdaptadorMetodoPago adaptadorMetodoPago = new AdaptadorMetodoPago();
    @Override
    public PagoViejoDTO convertirADTO(Pago pago) {
        PagoViejoDTO pagoDTO = new PagoViejoDTO();
        pagoDTO.setIdPago(pago.getId());
        MetodoPagoDTO metodoPago = adaptadorMetodoPago.convertirADTO(pago.getMetodoPago());
        pagoDTO.setMetodoPago(metodoPago);
        pagoDTO.setEstado(pago.getEstado());
        pagoDTO.setFechaHora(pago.getFechaHora());
        pagoDTO.setMonto(pago.getMonto());
        
        
        return pagoDTO;
    }

    @Override
    public Pago convertirAEntidad(PagoViejoDTO pago) {
        Pago pagoEntidad = new Pago();
        pagoEntidad.setFechaHora(pago.getFechaHora());
        pagoEntidad.setEstado(pago.getEstado());
        
        MetodoPago metodoPago = adaptadorMetodoPago.convertirAEntidad(pago.getMetodoPago());
        pagoEntidad.setMetodoPago(metodoPago);
        pagoEntidad.setMonto(pago.getMonto());
        return pagoEntidad;
    }

    
   

}
