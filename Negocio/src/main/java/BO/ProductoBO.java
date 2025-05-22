/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Adapters.AdaptadorProducto;
import DTOs.ProductoCargadoDTO;
import entidades.Producto;
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
    private final IProductoDAO productosDAOMokos;
    private final AdaptadorProducto adaptadorProducto;

    public ProductoBO(ICreadorDAO fabrica) {
        this.productoDAO = fabrica.crearProductoDAO();
        this.adaptadorProducto = new AdaptadorProducto();
        this.productosDAOMokos = fabrica.crearProductoMokosDAO();
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
    
    @Override
    public ProductoCargadoDTO agregarProducto(ProductoCargadoDTO producto) throws NegocioException {
        Producto productoEntidad = adaptadorProducto.convertirAEntidad(producto);
        try {
            System.out.println(producto );
            Producto productoDevuelto = productoDAO.agregarProducto(productoEntidad);
            return adaptadorProducto.convertirADTO(productoDevuelto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar Producto", e);
        }
        
    }

    @Override
    public List<ProductoCargadoDTO> buscadorProducto(String nombre) throws NegocioException {
        List<ProductoCargadoDTO> listaProductosDTO = new ArrayList<>();
        try {
            List<Producto> listaProductos = productoDAO.buscadorProducto(nombre);
            for (Producto producto : listaProductos) {
                ProductoCargadoDTO productoCargadoDTO = adaptadorProducto.convertirADTO(producto);
                listaProductosDTO.add(productoCargadoDTO);
            }
            return listaProductosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al hacer la busqueda",e);
        }
    }

    @Override
    public List<ProductoCargadoDTO> buscaPorNombre(String textoBusqueda) throws NegocioException {
        List<ProductoCargadoDTO> listaProductosDTO = new ArrayList<>();
        try {
            List<Producto> listaProductos = productoDAO.buscarPorNombre(textoBusqueda);
            for (Producto producto : listaProductos) {
                ProductoCargadoDTO productoDTO = adaptadorProducto.convertirADTO(producto);
                listaProductosDTO.add(productoDTO);
            }
            return listaProductosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar productos por nombre", e);
        }
    }
    
    @Override
    public boolean restarStockAProducto(double salida, Integer codigo) throws NegocioException {
        try {
            return productoDAO.restarStockAProducto(salida, codigo);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al restarle el stock", e);
        }
    }

    @Override
    public void sumararStockAProducto(double salida, Integer codigo) throws NegocioException {
        try {
            productoDAO.sumarStockAProducto(salida, codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al sumarle el stock", ex);
        }       
    }
    
}
