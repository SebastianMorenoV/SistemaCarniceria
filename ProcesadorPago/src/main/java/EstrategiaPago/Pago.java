package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.NuevoEfectivoDTO;
import DTOs.PagoNuevoDTO;
import DTOs.PagoViejoDTO;
import excepciones.ProcesadorPagoException;

/**
 * Esta clase representa un pago.
 * mediador entre quien lo llama y el cambio de estrategia.
 * no se sabe cual es la estrategia aqui especificamente. 
 * el sistema se encarga de llevar segun la estrategia seleccionada antes.
 * @author janot
 */
public class Pago {

    public double procesarPago(IProcesadorPago estrategia, PagoNuevoDTO pago) throws ProcesadorPagoException {
        return estrategia.procesarPago(pago);
    }

    public boolean validarPago(IProcesadorPago estrategia, PagoNuevoDTO pago) throws ProcesadorPagoException {
        return estrategia.validarPago(pago);
    }
    
    public NuevaTarjetaDTO buscarTarjeta(IProcesadorPago estrategia,String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws ProcesadorPagoException {
        return estrategia.buscarTarjeta(titular, numeroTarjeta, fechaVencimiento, cvv);
    }


}
