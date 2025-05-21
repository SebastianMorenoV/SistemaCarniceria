package entidades;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author Luis Carlos
 */
public class Entrada {

    @BsonId
    private ObjectId _id;
    @BsonProperty("codigo")
    private Integer id;
    private LocalDateTime FechaHora;
    private Empleado Empleado;
    private Proveedor Proveedor;
    private double subtotal = 0.0, total = 0.0;
    private List<ProductoEntrada> listaProductosEntrada;

    public Entrada(Integer id, LocalDateTime FechaHora, Empleado Empleado, Proveedor Proveedor, List listaProductosEntrada) {
        this.id = id;
        this.FechaHora = FechaHora;
        this.Empleado = Empleado;
        this.Proveedor = Proveedor;
        this.listaProductosEntrada = listaProductosEntrada;
    }

    public Entrada(LocalDateTime FechaHora, Empleado Empleado, Proveedor Proveedor, List listaProductosEntrada) {
        this.FechaHora = FechaHora;
        this.Empleado = Empleado;
        this.Proveedor = Proveedor;
        this.listaProductosEntrada = listaProductosEntrada;
    }

    public Entrada() {
    }

    public ObjectId get_Id() {
        return _id;
    }

    public void set_Id(ObjectId id) {
        this._id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(LocalDateTime FechaHora) {
        this.FechaHora = FechaHora;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }

    public Proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(Proveedor Proveedor) {
        this.Proveedor = Proveedor;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ProductoEntrada> getListaProductosEntrada() {
        return listaProductosEntrada;
    }

    public void setListaProductosEntrada(List listaProductosEntrada) {
        this.listaProductosEntrada = listaProductosEntrada;
    }

    @Override
    public String toString() {
        return "Entrada{" + "_id=" + _id + ", id=" + id + ", FechaHora=" + FechaHora + ", Empleado=" + Empleado + ", Proveedor=" + Proveedor + ", subtotal=" + subtotal + ", total=" + total + ", listaProductosEntrada=" + listaProductosEntrada + '}';
    }

}
