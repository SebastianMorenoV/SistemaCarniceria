/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.EntradaDTO;
import entidades.Entrada;

/**
 *
 * @author HP
 */
public interface IAdaptadorEntrada {
    public EntradaDTO convertirADTO(Entrada entrada);
    public Entrada convertirAEntidad(EntradaDTO entrada);
}
