package DTOs;

import java.util.Date;

/**
 *
 * @author janot
 */
public class PagoNuevoDTO {
    Date fechaHora;
    MetodoPagoDTO metodoPago;
    double monto;

    public PagoNuevoDTO(Date fechaHora, MetodoPagoDTO metodoPago, double monto) {
        this.fechaHora = fechaHora;
        this.metodoPago = metodoPago;
        this.monto = monto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
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
