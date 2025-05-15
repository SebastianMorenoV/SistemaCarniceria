
package DTOs;

import java.time.LocalDateTime;

/**
 *
 * @author Sebastian Moreno
 */
public class FechaDTO {
    LocalDateTime fechaInicio;
    LocalDateTime fechaFin;

    public FechaDTO() {
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    

    @Override
    public String toString() {
        return "FechaDTO{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
    
    
}
