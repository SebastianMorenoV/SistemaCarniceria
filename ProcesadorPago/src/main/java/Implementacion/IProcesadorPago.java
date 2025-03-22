package Implementacion;

import DTOs.PagoNuevoDTO;
import DTOs.PagoViejoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public interface IProcesadorPago {
    public PagoViejoDTO registrarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;
    
    public boolean verificarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;
}
