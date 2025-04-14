/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADAPTER.Efectivo;

import DTOs.NuevoEfectivoDTO;
import Entidades.Efectivo;

/**
 *
 * @author HP
 */
public interface IAdaptadorEfectivo {
    public NuevoEfectivoDTO convertirADTO(Efectivo efectivo);
    public Efectivo convertirAEntdiad(NuevoEfectivoDTO efectivoDTO);

}
