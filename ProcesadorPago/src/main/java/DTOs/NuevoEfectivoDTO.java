package DTOs;

/**
 *
 * @author janot
 */
public class NuevoEfectivoDTO {
    double pagoCon;

    public NuevoEfectivoDTO(double pagoCon) {
        this.pagoCon = pagoCon;
    }

    public NuevoEfectivoDTO() {
    }
    

    public double getPagoCon() {
        return pagoCon;
    }

    public void setPagoCon(double pagoCon) {
        this.pagoCon = pagoCon;
    }

    @Override
    public String toString() {
        return "NuevoEfectivoDTO{" + "pagoCon=" + pagoCon + '}';
    }
    
}
