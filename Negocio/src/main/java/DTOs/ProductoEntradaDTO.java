package DTOs;


import DTOs.ProductoCargadoDTO;
import DTOs.ProductoCargadoDTO;


public class ProductoEntradaDTO {

    private ProductoCargadoDTO productoEntrada;
    private double stock, precioCompra;

    public ProductoEntradaDTO(ProductoCargadoDTO productoEntrada, double unidades, double precioCompra) {
        this.productoEntrada = productoEntrada;
        this.stock = unidades;
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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock += stock;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Override
    public String toString() {
        return "ProductoEntradaDTO{" + "productoEntrada=" + productoEntrada + ", unidad=" + stock + ", precioCompra=" + precioCompra + '}';
    }
    
    
}
