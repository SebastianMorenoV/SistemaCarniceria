package DTOs;

/**
 *
 * @author janot
 */
public class NuevoEfectivoDTO {
    double monto;
    double cambio;

    public NuevoEfectivoDTO(double monto, double cambio) {
        this.monto = monto;
        this.cambio = cambio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
}
