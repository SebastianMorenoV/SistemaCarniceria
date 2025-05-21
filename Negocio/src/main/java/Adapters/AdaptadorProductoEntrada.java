/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adapters;

import DTOs.ProductoCargadoDTO;
import DTOs.ProductoEntradaDTO;
import IAdapters.IAdaptadorProductoEntrada;
import entidades.Producto;
import entidades.ProductoEntrada;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorProductoEntrada implements IAdaptadorProductoEntrada{

    @Override
    public ProductoEntrada convertirAEntidad(ProductoEntradaDTO producto) {
        AdaptadorProducto adaptador = new AdaptadorProducto();
        Producto productoEntidad = adaptador.convertirAEntidad(producto.getProductoEntrada());
        return new ProductoEntrada (productoEntidad, producto.getUnidad(),producto.getPrecioCompra());
    }

    @Override
    public ProductoEntradaDTO convertirADTO(ProductoEntrada producto) {
        AdaptadorProducto adaptador = new AdaptadorProducto();
        System.out.println("Producto a entidad llega a convertir a DTO " + producto);
        ProductoCargadoDTO productoDTO = adaptador.convertirADTO(producto.getProducto());
        System.out.println("PRODUCTO DESDE PRODUCTOentrada convertir a DTO" + productoDTO);
        return new ProductoEntradaDTO(
            productoDTO,
            producto.getUnidades(),
            producto.getPrecioCompra()
        );
    }

}
