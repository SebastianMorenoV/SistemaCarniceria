package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevoEfectivoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public class PagoEfectivo implements IProcesadorPago{
    
    @Override
    public double procesarPago(MetodoPagoDTO efectivo) throws ProcesadorPagoException {
        NuevoEfectivoDTO nuevoEfectivoDTO = efectivo.getNuevoEfectivo();
        return nuevoEfectivoDTO.getPagoCon() - nuevoEfectivoDTO.getMonto();
    }

    @Override
    public boolean validarPago(MetodoPagoDTO efectivo) throws ProcesadorPagoException {
        NuevoEfectivoDTO nuevoEfectivoDTO = efectivo.getNuevoEfectivo();
        return nuevoEfectivoDTO.getPagoCon() >= nuevoEfectivoDTO.getMonto();
    }
}
