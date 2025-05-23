package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.NuevoEfectivoDTO;
import DTOs.PagoNuevoDTO;
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
    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        NuevoEfectivoDTO nuevoEfectivoDTO = pago.getMetodoPago().getNuevoEfectivo();
        return nuevoEfectivoDTO.getPagoCon() - pago.getMonto();
    }
     /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO  A LOS METODOS , POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo mandaremos.
     * @return
     * @throws ProcesadorPagoException 
     */
    @Override
    public boolean validarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        NuevoEfectivoDTO nuevoEfectivoDTO = pago.getMetodoPago().getNuevoEfectivo();
        return nuevoEfectivoDTO.getPagoCon() >= pago.getMonto();
    }

    @Override
    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws ProcesadorPagoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
