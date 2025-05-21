package observerVentas;

import DTOs.VentaDTO;
import exception.SalidaException;
import salidas.IRealizarSalida;

/**
 *
 * @author janot
 */
public interface IObservador {
    public void update(VentaDTO venta, IRealizarSalida realizarSalida) throws SalidaException;
}
