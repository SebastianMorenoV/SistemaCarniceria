package entidades;

import java.time.LocalDateTime;
import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author janot
 */
public class Salida {
    @BsonId
    private ObjectId _id;
    @BsonProperty("codigo")
    private Integer id;
    private Producto producto;
    private Date fecha;
    private String motivo;
    private Double stockAntes;
    private Double cantidadSalida;
    private Double stockDespues;

    public Salida() {
    }

    public Salida(ObjectId _id, Producto producto, Date fecha, String motivo, Double stockAntes, Double cantidadSalida, Double stockDespues) {
        this._id = _id;
        this.producto = producto;
        this.fecha = fecha;
        this.motivo = motivo;
        this.stockAntes = stockAntes;
        this.cantidadSalida = cantidadSalida;
        this.stockDespues = stockDespues;
    }

    public ObjectId get_Id() {
        return _id;
    }

    public void set_Id(ObjectId _id) {
        this._id = _id;
    }
    
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getStockAntes() {
        return stockAntes;
    }

    public void setStockAntes(Double stockAntes) {
        this.stockAntes = stockAntes;
    }

    public Double getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(Double cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public Double getStockDespues() {
        return stockDespues;
    }

    public void setStockDespues(Double stockDespues) {
        this.stockDespues = stockDespues;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer codigo) {
        this.id = codigo;
    }
    
}
