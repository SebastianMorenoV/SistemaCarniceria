/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.NuevaTarjetaDTO;
import Entidades.Tarjeta;

/**
 *
 * @author HP
 */
public interface IAdaptadorTarjeta {
    public NuevaTarjetaDTO convertirADTO(Tarjeta tarjeta);
    public Tarjeta convertirAEntidad(NuevaTarjetaDTO tarjeta);

}
