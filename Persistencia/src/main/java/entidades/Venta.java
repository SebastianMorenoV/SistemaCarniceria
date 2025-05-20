package entidades;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author Sebastian Moreno
 */
public class Venta {

    @BsonId
    private ObjectId _id; // Este es el ID que MongoDB usa internamente
    @BsonProperty("codigo")
    Integer id;
    LocalDateTime fechaHora;
    Empleado cajero;
    double subtotal;
    double iva;
    double total;
    Pago pago;
    List<ProductoVenta> listaProductosVenta;

    public Venta() {
    }

    public Venta(Integer id, LocalDateTime fechaHora, Empleado cajero, double subtotal, double iva, double total, Pago pago, List<ProductoVenta> listaProductosVenta) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.pago = pago;
        this.listaProductosVenta = listaProductosVenta;
    }

    public Venta(LocalDateTime fechaHora, Empleado cajero, double subtotal, double iva, double total, Pago pago) {
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.pago = pago;
    }

    public Venta(LocalDateTime fechaHora, Empleado cajero, double subtotal, double iva, double total, Pago pago, List<ProductoVenta> listaProductosVenta) {
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.pago = pago;
        this.listaProductosVenta = listaProductosVenta;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<ProductoVenta> getListaProductosVenta() {
        return listaProductosVenta;
    }

    public void setListaProductosVenta(List<ProductoVenta> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fechaHora=" + fechaHora + ", cajero=" + cajero + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", pago=" + pago + ", listaProductosVenta=" + listaProductosVenta + '}';
    }

}
