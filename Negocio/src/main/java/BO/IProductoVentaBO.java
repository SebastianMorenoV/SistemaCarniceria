/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.NuevoProductoVentaDTO;
import DTOs.ProductoCargadoDTO;
import ADAPTERS.IAdaptadorProductoEntidadAproductoVentaDTO;

/**
 *
 * @author HP
 */
public class IProductoVentaBO implements IAdaptadorProductoEntidadAproductoVentaDTO{
    public IAdaptadorProductoEntidadAproductoVentaDTO productoVentaDAO;

    @Override
    public NuevoProductoVentaDTO convertirProductoEntidadAproductoVentaDTO(ProductoCargadoDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoCargadoDTO convertirproductoVentaDTOAProductoEntidad(NuevoProductoVentaDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
