
package entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class Venta {
    int id;
    LocalDateTime fechaHora;
    Empleado cajero;
    double subtotal;
    double iva;
    double total;
    MetodoPago metodoPago;
    List<ProductoVenta> listaProductosVenta;

    public Venta() {
    }

    public Venta(int id, LocalDateTime fechaHora, Empleado cajero, double subtotal, double iva, double total, MetodoPago metodoPago, List<ProductoVenta> listaProductosVenta) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.metodoPago = metodoPago;
        this.listaProductosVenta = listaProductosVenta;
    }

    public Venta(LocalDateTime fechaHora, Empleado cajero, double subtotal, double iva, double total, MetodoPago metodoPago) {
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public Venta(LocalDateTime fechaHora, Empleado cajero, double subtotal, double iva, double total, MetodoPago metodoPago, List<ProductoVenta> listaProductosVenta) {
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.metodoPago = metodoPago;
        this.listaProductosVenta = listaProductosVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Empleado getCajero() {
        return cajero;
    }

    public void setCajero(Empleado cajero) {
        this.cajero = cajero;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<ProductoVenta> getListaProductosVenta() {
        return listaProductosVenta;
    }

    public void setListaProductosVenta(List<ProductoVenta> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fechaHora=" + fechaHora + ", cajero=" + cajero + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", metodoPago=" + metodoPago + ", listaProductosVenta=" + listaProductosVenta + '}';
    }
    
    
    
    
    
}
