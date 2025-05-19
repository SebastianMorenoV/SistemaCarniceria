package DTOs;


import DTOs.ProductoCargadoDTO;
import DTOs.ProductoCargadoDTO;


public class ProductoEntradaDTO {

    private ProductoCargadoDTO productoEntrada;
    private double unidad, precioCompra;

    public ProductoEntradaDTO(ProductoCargadoDTO productoEntrada, double unidades, double precioCompra) {
        this.productoEntrada = productoEntrada;
        this.unidad = unidades;
        this.precioCompra = precioCompra;
    }

    public ProductoEntradaDTO() {
    }

    public ProductoCargadoDTO getProductoEntrada() {
        return productoEntrada;
    }

    public void setProductoEntrada(ProductoCargadoDTO productoEntrada) {
        this.productoEntrada = productoEntrada;
    }

    public double getUnidad() {
        return unidad;
    }

    public void setUnidad(double unidad) {
        this.unidad = unidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
}
