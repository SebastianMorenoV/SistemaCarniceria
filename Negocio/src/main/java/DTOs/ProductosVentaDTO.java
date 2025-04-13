/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class ProductosVentaDTO {
    List<ProductoVentaDTO> listaProductosVenta = new ArrayList<>();

    public ProductosVentaDTO() {
    }

    public ProductosVentaDTO(List<ProductoVentaDTO> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }

    public List<ProductoVentaDTO> getListaProductosVenta() {
        return listaProductosVenta;
    }
    
    public void setListaProductosVenta(List<ProductoVentaDTO> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }
    
    public void addProductoVenta(ProductoVentaDTO productoVenta){
        this.listaProductosVenta.add(productoVenta);    
    }

    @Override
    public String toString() {
        return "ProductosVentaDTO{" + "listaProductosVenta=" + listaProductosVenta + '}';
    }
    
}
