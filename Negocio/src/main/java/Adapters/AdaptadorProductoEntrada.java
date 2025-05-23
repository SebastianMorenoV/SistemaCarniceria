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
        return new ProductoEntrada (productoEntidad, producto.getStock(),producto.getPrecioCompra());
    }

    @Override
    public ProductoEntradaDTO convertirADTO(ProductoEntrada producto) {
        AdaptadorProducto adaptador = new AdaptadorProducto();
        ProductoCargadoDTO productoDTO = adaptador.convertirADTO(producto.getProducto());
        return new ProductoEntradaDTO(
            productoDTO,
            producto.getStock(),
            producto.getPrecioCompra()
        );
    }

}
