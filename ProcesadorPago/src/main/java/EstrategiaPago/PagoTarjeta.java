package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public class PagoTarjeta implements IProcesadorPago{
    

    @Override
    public double procesarPago(MetodoPagoDTO tarjeta) throws ProcesadorPagoException {
        return 0.0;
    }

    @Override
    public boolean validarPago(MetodoPagoDTO tarjeta) throws ProcesadorPagoException {
        NuevaTarjetaDTO nuevaTarjeta = tarjeta.getNuevaTarjeta();
        return nuevaTarjeta.getNumeroTarjeta() != null
                && nuevaTarjeta.getNumeroTarjeta().length() == 16
                && nuevaTarjeta.getCvv() > 99 && nuevaTarjeta.getCvv() < 1000;
    }

   
}
