
package DTOs.Devolucion;

import DTOs.ProductoVentaDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionDTO {

    Long id;
    String nombreCompleto;
    String telefono;
    String razon;
    List<ProductoVentaDTO> productosDevueltos;
    LocalDateTime fechaHora;
    int numeroTicket;
    double montoDevuelto;

    public DevolucionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ProductoVentaDTO> getProductosDevueltos() {
        return productosDevueltos;
    }

    public void setProductosDevueltos(List<ProductoVentaDTO> productosDevueltos) {
        this.productosDevueltos = productosDevueltos;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public double getMontoDevuelto() {
        return montoDevuelto;
    }

    public void setMontoDevuelto(double montoDevuelto) {
        this.montoDevuelto = montoDevuelto;
    }

    @Override
    public String toString() {
        return "DevolucionDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", razon=" + razon + ", productosDevueltos=" + productosDevueltos + ", fechaHora=" + fechaHora + ", numeroTicket=" + numeroTicket + ", montoDevuelto=" + montoDevuelto + '}';
    }

    
}
