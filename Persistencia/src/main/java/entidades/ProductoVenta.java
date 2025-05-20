/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 * Esta clase representa un productoVenta entity.
 * @author Sebastian Moreno
 */
public class ProductoVenta {
    Producto producto;
    double cantidad;
    double importe;
    double precioUnitaro;

    public ProductoVenta() {
    }

    public ProductoVenta(Producto producto, double cantidad, double importe, double precioUnitaro) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
        this.precioUnitaro = precioUnitaro;
    }

    public ProductoVenta(double cantidad, double importe, double precioUnitaro) {
        this.cantidad = cantidad;
        this.importe = importe;
        this.precioUnitaro = precioUnitaro;
    }
    
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getPrecioUnitario() {
        return precioUnitaro;
    }

    public void setPrecioUnitario(double precioUnitaro) {
        this.precioUnitaro = precioUnitaro;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "producto=" + producto + ", cantidad=" + cantidad + ", importe=" + importe + ", precioUnitaro=" + precioUnitaro + '}';
    }
    
    
}
