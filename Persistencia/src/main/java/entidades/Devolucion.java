
package entidades;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Sebastian Moreno
 */
    public class Devolucion {
        private ObjectId _id;
        private Integer id;
        private Venta venta;
        private String nombreCompleto;
        private String telefono;
        private String razon;
        private List<ProductoVenta> listadoProductosDevueltos;
        private LocalDateTime fechaHora;
        private String numeroDeTicket;
        private double montoDevuelto;

        public Devolucion() {
        }

    public Devolucion(ObjectId id, Venta venta, String nombreCompleto, String telefono, String razon, List<ProductoVenta> listadoProductosDevueltos, LocalDateTime fechaHora, String numeroDeTicket, double montoDevuelto) {
        this._id = id;
        this.venta = venta;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.razon = razon;
        this.listadoProductosDevueltos = listadoProductosDevueltos;
        this.fechaHora = fechaHora;
        this.numeroDeTicket = numeroDeTicket;
        this.montoDevuelto = montoDevuelto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer codigo) {
        this.id = codigo;
    }

    public ObjectId get_Id() {
        return _id;
    }

    public void set_Id(ObjectId id) {
        this._id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public List<ProductoVenta> getListadoProductosDevueltos() {
        return listadoProductosDevueltos;
    }

    public void setListadoProductosDevueltos(List<ProductoVenta> listadoProductosDevueltos) {
        this.listadoProductosDevueltos = listadoProductosDevueltos;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroDeTicket() {
        return numeroDeTicket;
    }

    public void setNumeroDeTicket(String numeroDeTicket) {
        this.numeroDeTicket = numeroDeTicket;
    }

    public double getMontoDevuelto() {
        return montoDevuelto;
    }

    public void setMontoDevuelto(double montoDevuelto) {
        this.montoDevuelto = montoDevuelto;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "id=" + _id + ", venta=" + venta + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", razon=" + razon + ", listadoProductosDevueltos=" + listadoProductosDevueltos + ", fechaHora=" + fechaHora + ", numeroDeTicket=" + numeroDeTicket + ", montoDevuelto=" + montoDevuelto + '}';
    }
    
    
    
}
