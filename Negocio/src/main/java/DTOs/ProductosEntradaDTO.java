/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ProductosEntradaDTO {
    List<ProductoEntradaDTO> listaProductosEntrada;
    
    public ProductosEntradaDTO(List<ProductoEntradaDTO> listaProductosEntrada) {
        this.listaProductosEntrada = listaProductosEntrada;
    }

    public ProductosEntradaDTO() {
    }

    public List<ProductoEntradaDTO> getListaProductosEntrada() {
        return listaProductosEntrada;
    }

    public void setListaProductosEntrada(List<ProductoEntradaDTO> listaProductosEntrada) {
        this.listaProductosEntrada = listaProductosEntrada;
    }
}
