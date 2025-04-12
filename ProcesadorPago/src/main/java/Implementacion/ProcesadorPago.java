package Implementacion;

import DTOs.NuevaTarjetaDTO;
import DTOs.NuevoEfectivoDTO;
import DTOs.PagoNuevoDTO;
import DTOs.PagoViejoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public class ProcesadorPago implements IProcesadorPago {
    IProcesadorPago metodoPago;
    
    public void seleccionarProcesadorPago(IProcesadorPago metodoPago){
        this.metodoPago = metodoPago;
    }
    
    @Override
    public boolean procesarPago() {
        return metodoPago.procesarPago();
    }

    @Override
    public boolean validarPago() {
        return metodoPago.validarPago();
    }
    
    private boolean validarTarjeta(NuevaTarjetaDTO tarjeta) {
        return tarjeta.getNumeroTarjeta() != null
                && tarjeta.getNumeroTarjeta().length() == 16
                && // Simulación de validación de tarjeta
                tarjeta.getCvv() > 99 && tarjeta.getCvv() < 1000;
    }

    public boolean validarEfectivo(NuevoEfectivoDTO efectivo) {
        return efectivo.getPagoCon() >= efectivo.getMonto(); // El efectivo debe ser suficiente para el pago
    }
    
    public double procesarPagoEfectivo(NuevoEfectivoDTO efectivo){
        return efectivo.getPagoCon() - efectivo.getMonto();
    }


    public boolean verificarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        if (pago == null) {
            throw new ProcesadorPagoException("El pago no puede ser nulo.");
        }
        if (pago.getMonto() <= 0) {
            throw new ProcesadorPagoException("El monto debe ser mayor a 0.");
        }
        if (pago.getMetodoPago() == null) {
            throw new ProcesadorPagoException("El método de pago no puede ser nulo.");
        }

        if (pago.getMetodoPago().getNuevaTarjeta() != null) {
            if (pago.getMetodoPago().getNuevaTarjeta().getSaldoDisponible() > pago.getMonto()) {
                return true;
            }
            return false;

        }

        return false;
    }

}
