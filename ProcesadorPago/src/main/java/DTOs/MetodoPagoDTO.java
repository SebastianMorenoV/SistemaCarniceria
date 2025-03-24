package DTOs;

/**
 *
 * @author janot
 */

public class MetodoPagoDTO {
    NuevaTarjetaDTO nuevaTarjeta;
    NuevoEfectivoDTO nuevoEfectivo;

    public MetodoPagoDTO() {
    }
    

    public MetodoPagoDTO(NuevaTarjetaDTO nuevaTarjeta) {
        this.nuevaTarjeta = nuevaTarjeta;
    }

    public MetodoPagoDTO(NuevoEfectivoDTO nuevoEfectivo) {
        this.nuevoEfectivo = nuevoEfectivo;
    }

    public NuevaTarjetaDTO getNuevaTarjeta() {
        return nuevaTarjeta;
    }

    public void setNuevaTarjeta(NuevaTarjetaDTO nuevaTarjeta) {
        this.nuevaTarjeta = nuevaTarjeta;
    }

    public NuevoEfectivoDTO getNuevoEfectivo() {
        return nuevoEfectivo;
    }

    public void setNuevoEfectivo(NuevoEfectivoDTO nuevoEfectivo) {
        this.nuevoEfectivo = nuevoEfectivo;
    }

    @Override
    public String toString() {
        return "MetodoPagoDTO{" + "nuevaTarjeta=" + nuevaTarjeta + ", nuevoEfectivo=" + nuevoEfectivo + '}';
    }
    
    

}