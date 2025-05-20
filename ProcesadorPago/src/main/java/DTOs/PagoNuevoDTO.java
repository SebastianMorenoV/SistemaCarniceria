package DTOs;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author janot
 */
public class PagoNuevoDTO {
    LocalDateTime fechaHora;
    MetodoPagoDTO metodoPago;
    double monto;
    String estado;

    public PagoNuevoDTO(LocalDateTime fechaHora, MetodoPagoDTO metodoPago, double monto) {
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.monto = monto;
    }

    
    
    public PagoNuevoDTO(LocalDateTime fechaHora, MetodoPagoDTO metodoPago, double monto , String estado) {
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estado = estado;
    }

    public PagoNuevoDTO() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MetodoPagoDTO getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoDTO metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "PagoNuevoDTO{" + "fechaHora=" + fechaHora + ", metodoPago=" + metodoPago + ", monto=" + monto + '}';
    }
    
}
