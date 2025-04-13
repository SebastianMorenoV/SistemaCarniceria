package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
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
    public double procesarPago() throws ProcesadorPagoException {
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
    public boolean validarPago() throws ProcesadorPagoException {
        NuevaTarjetaDTO nuevaTarjeta = new NuevaTarjetaDTO("Juanito Perez", "412313123123", "02/23", 0, 0);
        return nuevaTarjeta.getNumeroTarjeta() != null
                && nuevaTarjeta.getNumeroTarjeta().length() == 16
                && nuevaTarjeta.getCvv() > 99 && nuevaTarjeta.getCvv() < 1000;
    }

}
