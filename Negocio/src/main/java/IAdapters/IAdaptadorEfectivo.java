/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.NuevoEfectivoDTO;
import entidades.Efectivo;

/**
 *
 * @author HP
 */
public interface IAdaptadorEfectivo {
    public NuevoEfectivoDTO convertirADTO(Efectivo efectivo);
    public Efectivo convertirAEntdiad(NuevoEfectivoDTO efectivoDTO);

}
