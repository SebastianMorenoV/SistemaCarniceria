package DTOs.Devolucion;

import DTOs.EmpleadoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class CrearDevolucionDTO {

    VentaDTO venta;
    EmpleadoCargadoDTO cajeroDevolucion;
    String nombreCompleto;
    String telefono;
    String razon;
    List<ProductoVentaDTO> productosDevueltos;
    LocalDateTime fechaHora;
    int numeroTicket;
    double montoDevuelto;

    public CrearDevolucionDTO() {
    }

    public EmpleadoCargadoDTO getCajeroDevolucion() {
        return cajeroDevolucion;
    }

    public void setCajeroDevolucion(EmpleadoCargadoDTO cajeroDevolucion) {
        this.cajeroDevolucion = cajeroDevolucion;
    }

    
    public VentaDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaDTO venta) {
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
        return "CrearDevolucionDTO{" + "venta=" + venta + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", razon=" + razon + ", productosDevueltos=" + productosDevueltos + ", fechaHora=" + fechaHora + ", numeroTicket=" + numeroTicket + ", montoDevuelto=" + montoDevuelto + '}';
    }

}
