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
    public int id;
    public Producto producto;
    public double unidades;
    public double PrecioCompra;

    public ProductoEntrada(int id, Producto producto, double unidades, double PrecioCompra) {
        this.id = id;
        this.producto = producto;
        this.unidades = unidades;
        this.PrecioCompra = PrecioCompra;
    }

    public ProductoEntrada(Producto producto, double unidades, double PrecioCompra) {
        this.producto = producto;
        this.unidades = unidades;
        this.PrecioCompra = PrecioCompra;
    }

    public ProductoEntrada() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getUnidades() {
        return unidades;
    }

    public void setUnidades(double unidades) {
        this.unidades = unidades;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

}