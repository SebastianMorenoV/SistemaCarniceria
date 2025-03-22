package DTOs;

import java.util.Date;

/**
 *
 * @author janot
 */
public class PagoNuevoDTO {
    Date fechaHora;
    MetodoPago metodoPago;
    double monto;

    public PagoNuevoDTO(Date fechaHora, MetodoPago metodoPago, double monto) {
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

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
