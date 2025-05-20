package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.PagoNuevoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public interface IProcesadorPago {

    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;

    public boolean validarPago(PagoNuevoDTO pago) throws ProcesadorPagoException;
    
    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws ProcesadorPagoException ;
}
