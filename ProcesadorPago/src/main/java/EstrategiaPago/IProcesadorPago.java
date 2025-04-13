package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public interface IProcesadorPago {

    public double procesarPago() throws ProcesadorPagoException;

    public boolean validarPago() throws ProcesadorPagoException;
}
