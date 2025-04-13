package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public interface IProcesadorPago {

    public double procesarPago(MetodoPagoDTO metodoPago) throws ProcesadorPagoException;

    public boolean validarPago(MetodoPagoDTO metodoPago) throws ProcesadorPagoException;
}
