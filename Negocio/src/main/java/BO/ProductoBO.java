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
//    //Codigo para setear el stock despues de una entrada o una salida... 1.1 
//    //ocupo un metodo en la DAO para consultar al producto por id o por nombre... tambien un metodo de setStockProducto?? para simplificar aqui?
//        public void setStockProducto(ProductoCargadoDTO producto,double unidades) throws NegocioException {
//        double stockNuevo ; //para ver el nuevo stock una vez agregada la entrada? pero no se utiliza para nada mejor lo dejare en void
//        ProductoCargadoDTO producto = new ProductoCargadoDTO(); //para regresar el producto??
//        try {
//            Producto productoEncontrado = productoDAO.ConsultarProductoPorId(Producto.getId());
//            //En entidad Producto falta metodo setStock...
//            productoEncontrado.setStock(unidades);
//
//        } catch (PersistenciaException ex) {
//            throw new NegocioException("No se pudo consultar los productos: " + ex.getMessage(), ex);
//        }
//
//    }
}
