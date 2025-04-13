/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADAPTER.Tarjeta;

import DTOs.NuevaTarjetaDTO;
import Entidades.Tarjeta;

/**
 *
 * @author HP
 */
public class adaptadorTarjeta implements IAdaptadorTarjeta{

    @Override
    public NuevaTarjetaDTO convertirADTO(Tarjeta tarjeta) {
        NuevaTarjetaDTO tarjetaDTO = new  NuevaTarjetaDTO();
        tarjetaDTO.setTitular(tarjeta.getNombreTitular());
        tarjetaDTO.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        tarjetaDTO.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaDTO.setCvv(tarjeta.getCvv());
        return tarjetaDTO; 
        //Faltaaaaaa atributo saldo
    }

    @Override
    public Tarjeta convertirAEntidad(NuevaTarjetaDTO tarjeta) {
        Tarjeta tarjetaEntidad = new  Tarjeta();
        tarjetaEntidad.setNombreTitular(tarjeta.getTitular());
        tarjetaEntidad.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        tarjetaEntidad.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaEntidad.setCvv(tarjeta.getCvv());
        return tarjetaEntidad;  
    }

}
