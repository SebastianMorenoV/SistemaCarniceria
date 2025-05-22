/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ProductoEntrada {

    public Producto producto;
    public double stock;
    public double PrecioCompra;
    

    public ProductoEntrada(Producto producto, double unidades, double PrecioCompra) {
        this.producto = producto;
        this.stock = unidades;
        this.PrecioCompra = PrecioCompra;
    }

    public ProductoEntrada() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    @Override
    public String toString() {
        return "ProductoEntrada{" + "producto=" + producto + ", unidades=" + stock + ", PrecioCompra=" + PrecioCompra + '}';
    }

}
