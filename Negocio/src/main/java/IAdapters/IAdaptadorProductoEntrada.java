/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.ProductoEntradaDTO;
import entidades.ProductoEntrada;

/**
 *
 * @author HP
 */
public interface IAdaptadorProductoEntrada {
    public ProductoEntrada convertirAEntidad(ProductoEntradaDTO producto); 
    public ProductoEntradaDTO convertirADTO(ProductoEntrada producto); 
}
