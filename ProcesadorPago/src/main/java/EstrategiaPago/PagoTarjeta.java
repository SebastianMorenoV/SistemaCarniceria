package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.PagoNuevoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public class PagoTarjeta implements IProcesadorPago {

    /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO A LOS METODOS ,
     * POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo
     * mandaremos.
     *
     * @return
     * @throws ProcesadorPagoException
     */
    @Override
    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        System.out.println("Se proceso el pago por tarjeta correctamente.");
        return 0.0;
    }

    /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO A LOS METODOS ,
     * POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo
     * mandaremos.
     *
     * @return
     * @throws ProcesadorPagoException
     */
    @Override
    public boolean validarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        NuevaTarjetaDTO nuevaTarjeta = pago.getMetodoPago().getNuevaTarjeta();
        return nuevaTarjeta.getNumeroTarjeta() != null
                && nuevaTarjeta.getNumeroTarjeta().length() == 16
                && nuevaTarjeta.getCvv() > 99 && nuevaTarjeta.getCvv() < 1000;
    }

}
