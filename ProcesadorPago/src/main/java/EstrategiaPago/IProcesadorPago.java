package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.PagoNuevoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public interface IProcesadorPago {

    public boolean procesarPago() throws ProcesadorPagoException;

    public boolean validarPago() throws ProcesadorPagoException;
}
