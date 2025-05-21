package observerVentas;

import DTOs.VentaDTO;
import exception.SalidaException;
import salidas.IRealizarSalida;

/**
 *
 * @author janot
 */
public interface IObservable {
    public void addObserver(IObservador observador);
    
    public void deleteObserver(IObservador observador);
    
    public void notifyObservers(VentaDTO venta, IRealizarSalida realizarSalida) throws SalidaException;
    
}
