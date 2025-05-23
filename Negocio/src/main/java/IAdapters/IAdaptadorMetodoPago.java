/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.MetodoPagoDTO;
import entidades.MetodoPago;

/**
 *
 * @author HP
 */
public interface IAdaptadorMetodoPago {

    public MetodoPagoDTO convertirTarjetaADTO(MetodoPago metodoPago);

    public MetodoPago convertirTarjetaDTOAEntidad(MetodoPago metodoPago);

    public MetodoPagoDTO convertirEfectivoADTO(MetodoPago metodoPago);

    public MetodoPago convertirEfectivoAEntidad(MetodoPago metodoPago);

    //
    public MetodoPagoDTO convertirADTO(MetodoPago metodoPago);

    public MetodoPago convertirAEntidad(MetodoPagoDTO metodoPago);
}
