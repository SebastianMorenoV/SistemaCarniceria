/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.VentaDTO;
import ADAPTERS.Venta.IAdaptadorVenta;
import DTOs.CrearVentaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.ProductosVentaDTO;
import Entidades.ProductoVenta;
import Entidades.Venta;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IVentaDAO;
import fabrica.ICreadorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manejador de conversion de objetos.
 * Recibe un una fabrica , para crear la DAO.
 * se espera utilizar la DAO para acceder a la base de datos.
 * @author HP
 */
public class VentaBO {

    private IAdaptadorVenta adaptador;

    private final IVentaDAO ventaDAO;

    public VentaBO(ICreadorDAO fabrica) {
        this.ventaDAO = fabrica.crearVentaDAO();
    }


    //CREAR VENTADTO COMO PARAMETRO DE EL METODO... EN VEZ DE VENTADTO , TENER EL MISMO DTO PARA DATOS CONSULTADOS PUEDE SER CONFUSO.
    //CREAR VENTADTO COMO PARAMETRO DE EL METODO... EN VEZ DE VENTADTO , TENER EL MISMO DTO PARA DATOS CONSULTADOS PUEDE SER CONFUSO.
    public VentaDTO registrarVenta(VentaDTO ventaDTO) throws NegocioException {

        Venta venta = new Venta();
        venta.setIva(ventaDTO.getIva());
        venta.setSubtotal(ventaDTO.getSubtotal());
        venta.setTotal(ventaDTO.getTotal());

        try {
            venta = ventaDAO.registrarVenta(venta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(VentaBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        VentaDTO ventaMapeada = new VentaDTO();
        //AQUI DEBE BUSCAR EL ID , CON LA CREARVENTADTO
        ventaMapeada.setTotal(venta.getTotal());
        ventaMapeada.setIva(venta.getIva());
        return ventaMapeada;
    }

public ProductosVentaDTO obtenerProductosVenta() throws NegocioException {
        try {
            List<ProductoVenta> productosVentaConsultado = ventaDAO.consultarProductosVenta();
            ProductosVentaDTO productosVentaDTO = new ProductosVentaDTO();
            // sustituido por mapper
            for (ProductoVenta productoVenta : productosVentaConsultado) {
                // sustituido por mapper
                ProductoCargadoDTO productoDTO = new ProductoCargadoDTO();
               // productoDTO.setCodigo(productoVenta.getProducto().getId().intValue());
                productoDTO.setPrecio(productoVenta.getProducto().getPrecio());
                productoDTO.setDescripcion(productoVenta.getProducto().getDescripcion());
                productoDTO.setNombre(productoVenta.getProducto().getNombre());

                ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO();
                productoVentaDTO.setProducto(productoDTO);
                productoVentaDTO.setImporte(productoVenta.getImporte());
                productoVentaDTO.setPrecioUnitario(productoDTO.getPrecio());
                productoVentaDTO.setCantidad(1); // SUSTITUIR ESTO , LO HICE PORQUE AUN NO TENEMOS MAPPERS Y EL FOR DEBE SER UN FOR(INT I = 0) EN VEZ DE FOR EACH
                productosVentaDTO.addProductoVenta(productoVentaDTO);
            }
            
            return productosVentaDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Hubo un error consultado los productos venta", ex.getCause());
        }
    }

}
