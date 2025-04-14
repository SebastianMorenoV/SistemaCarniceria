/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import ADAPTER.Producto.AdaptadorProducto;
import DTOs.ProductoCargadoDTO;
import Entidades.Producto;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IProductoBO;
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
public class ProductoBO implements IProductoBO {

    private final IProductoDAO productoDAO;
    private final AdaptadorProducto adaptadorProducto;

    public ProductoBO(ICreadorDAO fabrica) {
        this.productoDAO = fabrica.crearProductoDAO();
        this.adaptadorProducto = new AdaptadorProducto();
    }

    @Override
    public List<ProductoCargadoDTO> cargarProductos() throws NegocioException {
        List<ProductoCargadoDTO> listaProductosDTO = new ArrayList<>();

        try {
            List<Producto> listaProductos = productoDAO.consultarProductos();

            //usar el adaptador para convertir los Producto a ProductoDTO
            for (Producto producto : listaProductos) {
                ProductoCargadoDTO dto = adaptadorProducto.convertirADTO(producto);  //convertir usando el adaptador
                listaProductosDTO.add(dto);
            }

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo consultar los productos: " + ex.getMessage(), ex);
        }

        return listaProductosDTO;
    }
}
