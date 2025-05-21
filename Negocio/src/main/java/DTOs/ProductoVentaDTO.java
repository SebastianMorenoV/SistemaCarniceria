/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Sebastian Moreno
 */
public class ProductoVentaDTO {
    ProductoCargadoDTO producto;
    double cantidad;
    double precioUnitario;
    double importe;

    public ProductoVentaDTO() {
    }

    public ProductoVentaDTO(ProductoCargadoDTO producto, double cantidad, double precioUnitario, double importe) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.importe = importe;
    }

    public ProductoCargadoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoCargadoDTO producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "ProductoVentaDTO{" + "producto=" + producto.getCodigo() + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", importe=" + importe + '}';
    }

    
    
    
}
