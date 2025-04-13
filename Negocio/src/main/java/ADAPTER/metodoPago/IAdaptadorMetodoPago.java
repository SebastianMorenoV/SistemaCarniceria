/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADAPTER.metodoPago;

import DTOs.MetodoPagoDTO;
import Entidades.MetodoPago;

/**
 *
 * @author HP
 */
public interface IAdaptadorMetodoPago {
    public MetodoPagoDTO convertirTarjetaADTO(MetodoPago metodoPago);
    public MetodoPago convertirTarjetaDTOAEntidad(MetodoPago metodoPago);
    public MetodoPagoDTO convertirEfectivoADTO(MetodoPago metodoPago);
    public MetodoPago convertirEfectivoAEntidad(MetodoPago metodoPago);

}
