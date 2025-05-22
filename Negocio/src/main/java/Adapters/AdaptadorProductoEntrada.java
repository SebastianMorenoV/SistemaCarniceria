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
        Producto productoEntidad = adaptador.convertirAEntidadStock(producto.getProductoEntrada());
        System.out.println("Return el metodo ProductoEntradaEntidad desde convertirAEntidad ProductoEntrada : " + productoEntidad.toString() +"   Stock el Proucto aqui : " +  productoEntidad.getStock());
        return new ProductoEntrada (productoEntidad, producto.getStock(),producto.getPrecioCompra());
    }

    @Override
    public ProductoEntradaDTO convertirADTO(ProductoEntrada producto) {
        AdaptadorProducto adaptador = new AdaptadorProducto();
        System.out.println("ProductoEntidad llega a convertiraDTO :" + producto.toString());
        ProductoCargadoDTO productoDTO = adaptador.convertirADTO(producto.getProducto());
        System.out.println("ProuctoCargadoDTO dese ProcductoEntraaDTO convertirADTO : " + productoDTO.toString());
        return new ProductoEntradaDTO(
            productoDTO,
            producto.getStock(),
            producto.getPrecioCompra()
        );
    }

}
