/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DTOs.NuevoProductoVentaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoVentaDTO;
import entidades.Producto;
import entidades.ProductoVenta;

import IAdapters.IAdaptadorProductoVenta;
import java.util.List;

/**
 *
 * @author HP
 */
public class IProductoVentaBO implements IAdaptadorProductoVenta{
    public IAdaptadorProductoVenta productoVentaDAO;
    @Override
    public ProductoVentaDTO convertirProductoVentaADTO(ProductoVenta producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NuevoProductoVentaDTO convertirADTO(ProductoVenta producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoVenta convertirAEntidad(NuevoProductoVentaDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NuevoProductoVentaDTO> convertirListaADTO(List<ProductoVenta> listaProductoVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoVenta> convertirListaDTOAEntidad(List<NuevoProductoVentaDTO> listaProductoVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
