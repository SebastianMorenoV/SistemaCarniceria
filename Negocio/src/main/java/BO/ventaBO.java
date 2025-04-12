/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.VentaDTO;
import adapters.IAdaptadorVentaEntidadAVentaDTO;
/**
 *
 * @author HP
 */
public class ventaBO implements IAdaptadorVentaEntidadAVentaDTO{
    IAdaptadorVentaEntidadAVentaDTO ventaDAO;

    @Override
    public VentaDTO convertirVentaEntidadVentaDTO(VentaDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VentaDTO convertirVentaDTOAProductoEntidad(VentaDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }        
}