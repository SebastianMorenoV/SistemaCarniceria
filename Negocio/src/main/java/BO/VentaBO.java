/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import IAdapters.IAdaptadorProducto;
import Adapters.AdaptadorProducto;
import IAdapters.IAdaptadorProductoVenta;
import Adapters.adaptadorProductoVenta;
import Adapters.AdaptadorTarjeta;
import DTOs.VentaDTO;
import IAdapters.IAdaptadorVenta;
import DTOs.CrearVentaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.ProductosVentaDTO;
import entidades.ProductoVenta;
import entidades.Venta;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IVentaBO;
import Interfaces.IVentaDAO;
import fabrica.ICreadorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manejador de conversion de objetos. Recibe un una fabrica , para crear la
 * DAO. se espera utilizar la DAO para acceder a la base de datos.
 *
 * @author HP
 */
public class VentaBO implements IVentaBO {

    private final IAdaptadorVenta adaptadorVenta = new AdaptadorTarjeta();
    private final IAdaptadorProducto adaptadorProducto = new AdaptadorProducto();
    private final IAdaptadorProductoVenta adaptadorProductoVenta = new adaptadorProductoVenta();
    
    private final IVentaDAO ventaDAO;

    public VentaBO(ICreadorDAO fabrica) {
        this.ventaDAO = fabrica.crearVentaDAO();
    }

    //CREAR VENTADTO COMO PARAMETRO DE EL METODO... EN VEZ DE VENTADTO , TENER EL MISMO DTO PARA DATOS CONSULTADOS PUEDE SER CONFUSO.
    //CREAR VENTADTO COMO PARAMETRO DE EL METODO... EN VEZ DE VENTADTO , TENER EL MISMO DTO PARA DATOS CONSULTADOS PUEDE SER CONFUSO.
    @Override
    public VentaDTO registrarVenta(VentaDTO ventaDTO) throws NegocioException {

        Venta venta = adaptadorVenta.convertirAVenta(ventaDTO);

        try {
            venta = ventaDAO.registrarVenta(venta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(VentaBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        VentaDTO ventaMapeada = adaptadorVenta.convertirADTO(venta);
        return ventaMapeada;
    }

    @Override
    public ProductosVentaDTO obtenerProductosVenta() throws NegocioException {
        try {
            List<ProductoVenta> productosVentaConsultado = ventaDAO.consultarProductosVenta();
            ProductosVentaDTO productosVentaDTO = new ProductosVentaDTO();
            // sustituido por mapper
            for (ProductoVenta productoVenta : productosVentaConsultado) {
                ProductoCargadoDTO productoDTO = adaptadorProducto.convertirADTO(productoVenta.getProducto());

                ProductoVentaDTO productoVentaDTO =  adaptadorProductoVenta.convertirProductoVentaADTO(productoVenta);
               
                productosVentaDTO.addProductoVenta(productoVentaDTO);
            }

            return productosVentaDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Hubo un error consultado los productos venta", ex.getCause());
        }
    }

}
