package DTOs;

import DTOs.ProductoCargadoDTO;
import entidades.Producto;
import java.util.Date;

/**
 *
 * @author janot
 */
public class NuevaSalidaDTO {
    private ProductoCargadoDTO producto;
    private String motivo;
    private Double stockAntes;
    private Double cantidadSalida;
    private Double stockDespues;

    public NuevaSalidaDTO(ProductoCargadoDTO producto, String motivo, Double stockAntes, Double cantidadSalida, Double stockDespues) {
        this.producto = producto;
        this.motivo = motivo;
        this.stockAntes = stockAntes;
        this.cantidadSalida = cantidadSalida;
        this.stockDespues = stockDespues;
    }

    public ProductoCargadoDTO getProducto() {
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
