/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.ProductoCargadoDTO;
import Entidades.Producto;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IProductoDAO;
import fabrica.ICreadorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class ProductoBO {

    private final IProductoDAO productoDAO;

    public ProductoBO(ICreadorDAO fabrica) {
        this.productoDAO = fabrica.crearProductoDAO();
    }
    
    //IMPLEMENTAR MAPPERS
    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException {
        List<ProductoCargadoDTO> listaProductosDTO = new ArrayList<>();

        try {
            List<Producto> listaProductos = productoDAO.consultarProductos();

            for (Producto producto : listaProductos) {
                ProductoCargadoDTO dto = new ProductoCargadoDTO();
                dto.setCodigo(producto.getId().intValue());
                dto.setNombre(producto.getNombre());
                dto.setDescripcion(producto.getDescripcion());
                dto.setPrecio(producto.getPrecio());

                listaProductosDTO.add(dto);
            }

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo consultar los productos: " + ex.getMessage(), ex);
        }

        return listaProductosDTO;
    }
}
