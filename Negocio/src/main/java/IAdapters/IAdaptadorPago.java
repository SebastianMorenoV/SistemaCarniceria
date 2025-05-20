/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.PagoNuevoDTO;
import DTOs.PagoViejoDTO;
import entidades.Pago;

/**
 *
 * @author Sebastian Moreno
 */
public interface IAdaptadorPago {

    public PagoViejoDTO convertirADTO(Pago pago);

    public Pago convertirAEntidad(PagoViejoDTO pago);
}
