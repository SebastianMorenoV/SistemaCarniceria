/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import IAdapters.IAdaptadorEfectivo;
import DTOs.NuevoEfectivoDTO;
import Entidades.Efectivo;

/**
 *
 * @author HP
 */
public class AdaptadorEfectivo implements IAdaptadorEfectivo{
 
@Override
    public NuevoEfectivoDTO convertirADTO(Efectivo efectivo) {
        //NuevoEfectivoDTO EfectivoDTO =  new NuevoEfectivoDTO(efectivo.getMonto(), (efectivo.getMonto()+efectivo.getCambio()));
        //NuevoEfectivoDTO EfectivoDTO2 = new NuevoEfectivoDTO
        return null;
    }

    @Override
    public Efectivo convertirAEntdiad(NuevoEfectivoDTO efectivoDTO) {
        //Efectivo Efectivo =  new Efectivo(efectivoDTO.getMonto(), (efectivoDTO.getPagoCon()-efectivoDTO.getMonto()));
        return null;
    }

}
