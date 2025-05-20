package EstrategiaPago;

import DTOs.MetodoPagoDTO;
import DTOs.NuevaTarjetaDTO;
import DTOs.PagoNuevoDTO;
import excepciones.ProcesadorPagoException;

/**
 *
 * @author janot
 */
public class PagoTarjeta implements IProcesadorPago {

    /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO A LOS METODOS ,
     * POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo
     * mandaremos.
     *
     * @return
     * @throws ProcesadorPagoException
     */
    @Override
    public double procesarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        System.out.println("Se proceso el pago por tarjeta correctamente.");
        return 0.0;
    }

    /**
     * Aqui deberemos pasarle talvez un pagoDTO O MetodoPAGODTO A LOS METODOS ,
     * POR EL MOMENTO LO DEJO ASI. dependiendo de la estrategia se lo
     * mandaremos.
     *
     * @return
     * @throws ProcesadorPagoException
     */
    @Override
    public boolean validarPago(PagoNuevoDTO pago) throws ProcesadorPagoException {
        if (pago == null || pago.getMetodoPago() == null) {
            return false;
        }

        NuevaTarjetaDTO nuevaTarjeta = pago.getMetodoPago().getNuevaTarjeta();
        if (nuevaTarjeta == null) {
            return false;
        }

        String numeroTarjeta = nuevaTarjeta.getNumeroTarjeta();
        int cvv = nuevaTarjeta.getCvv();

        return numeroTarjeta != null
                && numeroTarjeta.matches("\\d{16}") // Asegura que sean exactamente 16 dígitos
                && cvv >= 100 && cvv <= 999;

    }

    @Override
    public NuevaTarjetaDTO buscarTarjeta(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) throws ProcesadorPagoException {
        if (titular.equals("Luciano") && numeroTarjeta.equals("4152000011112222") && fechaVencimiento.equals("02/28") && cvv == 123) {
            NuevaTarjetaDTO tarjeta1 = new NuevaTarjetaDTO();
            tarjeta1.setTitular("Luciano");
            tarjeta1.setNumeroTarjeta("4152000011112222");
            tarjeta1.setFechaVencimiento("02/28");
            tarjeta1.setCvv(123);
            tarjeta1.setSaldoDisponible(5000);
            return tarjeta1;

        } else if (titular.equals("Sebastian") && numeroTarjeta.equals("5404000000000001") && fechaVencimiento.equals("06/26") && cvv == 456) {
            NuevaTarjetaDTO tarjeta2 = new NuevaTarjetaDTO();
            tarjeta2.setTitular("Sebastian");
            tarjeta2.setNumeroTarjeta("5404000000000001");
            tarjeta2.setFechaVencimiento("06/26");
            tarjeta2.setCvv(456);
            tarjeta2.setSaldoDisponible(10000);
            return tarjeta2;

        } else if (titular.equals("Maria") && numeroTarjeta.equals("371449635398431") && fechaVencimiento.equals("12/25") && cvv == 789) {
            NuevaTarjetaDTO tarjeta3 = new NuevaTarjetaDTO();
            tarjeta3.setTitular("Maria");
            tarjeta3.setNumeroTarjeta("371449635398431");
            tarjeta3.setFechaVencimiento("12/25");
            tarjeta3.setCvv(789);
            tarjeta3.setSaldoDisponible(20000);
            return tarjeta3;

        } else {
            throw new ProcesadorPagoException("Tarjeta no encontrada o datos invalidos.");
        }
    }

}
