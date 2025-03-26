package DTOs;

/**
 *
 * @author janot
 */
public class NuevoEfectivoDTO {
    double monto;
    double pagoCon;

    public NuevoEfectivoDTO(double monto, double pagoCon) {
        this.monto = monto;
        this.pagoCon = pagoCon;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getPagoCon() {
        return pagoCon;
    }

    public void setPagoCon(double pagoCon) {
        this.pagoCon = pagoCon;
    }
    
}
