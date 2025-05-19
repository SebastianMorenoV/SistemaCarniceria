/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.ProductoDAO;
import DTOs.ProductoCargadoDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IProductoBO {
    
    static IProductoDAO obtenerInstanciaDAO(){
        return new ProductoDAO();
    }
    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException;
    
    public ProductoCargadoDTO agregarProducto(ProductoCargadoDTO producto);
    
}
