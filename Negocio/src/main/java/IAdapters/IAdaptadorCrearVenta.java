/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.CrearVentaDTO;
import entidades.CrearVenta;

/**
 *
 * @author HP
 */
public interface IAdaptadorCrearVenta {
    public CrearVentaDTO convertirADTO(CrearVenta crearVenta);
    public CrearVenta convertirAEntdiad(CrearVentaDTO crearVenta);

}
