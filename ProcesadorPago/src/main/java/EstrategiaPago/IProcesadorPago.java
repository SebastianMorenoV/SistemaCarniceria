package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.PagoNuevoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public interface IProcesadorPago {

    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;

    public boolean validarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;
}
