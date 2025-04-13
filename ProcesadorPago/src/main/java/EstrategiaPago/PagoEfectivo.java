package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevoEfectivoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public class PagoEfectivo implements IProcesadorPago{
    
    /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO  A LOS METODOS , POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo mandaremos.
     * @return
     * @throws ProcesadorPagoException 
     */
    @Override
    public double procesarPago() throws ProcesadorPagoException {
        NuevoEfectivoDTO nuevoEfectivoDTO = new NuevoEfectivoDTO(0, 0);
        System.out.println("Se proceso pago desde efectivo correctamente.");
        return nuevoEfectivoDTO.getPagoCon() - nuevoEfectivoDTO.getMonto();
    }
     /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO  A LOS METODOS , POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo mandaremos.
     * @return
     * @throws ProcesadorPagoException 
     */
    @Override
    public boolean validarPago() throws ProcesadorPagoException {
        NuevoEfectivoDTO nuevoEfectivoDTO = new NuevoEfectivoDTO(0, 0);
        return nuevoEfectivoDTO.getPagoCon() >= nuevoEfectivoDTO.getMonto();
    }
}
