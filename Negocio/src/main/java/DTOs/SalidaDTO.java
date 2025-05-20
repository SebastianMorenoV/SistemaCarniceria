package DTOs;

import entidades.Producto;
import java.util.Date;

/**
 *
 * @author janot
 */
public class SalidaDTO {
    private Date fecha;
    private Producto producto;
    private String motivo;
    private Double stockAntes;
    private Double cantidadSalida;
    private Double stockDespues;

    public SalidaDTO(Date fecha, Producto producto, String motivo, Double stockAntes, Double cantidadSalida, Double stockDespues) {
        this.fecha = fecha;
        this.producto = producto;
        this.motivo = motivo;
        this.stockAntes = stockAntes;
        this.cantidadSalida = cantidadSalida;
        this.stockDespues = stockDespues;
    }

    public Date getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getMotivo() {
        return motivo;
    }

    public Double getStockAntes() {
        return stockAntes;
    }

    public Double getCantidadSalida() {
        return cantidadSalida;
    }

    public Double getStockDespues() {
        return stockDespues;
    }
    
    
}
