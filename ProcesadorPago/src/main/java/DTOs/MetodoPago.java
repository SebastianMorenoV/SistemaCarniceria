package DTOs;

/**
 *
 * @author janot
 */
class MetodoPago {
    NuevaTarjetaDTO tarjeta;
    NuevoEfectivoDTO efectivo;

    public MetodoPago(NuevaTarjetaDTO tarjeta, NuevoEfectivoDTO efectivo) {
        this.tarjeta = tarjeta;
        this.efectivo = efectivo;
    }    

    public NuevaTarjetaDTO getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(NuevaTarjetaDTO tarjeta) {
        this.tarjeta = tarjeta;
    }

    public NuevoEfectivoDTO getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(NuevoEfectivoDTO efectivo) {
        this.efectivo = efectivo;
    }
    
}
