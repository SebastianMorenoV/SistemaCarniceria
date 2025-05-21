package observerVentas;

import DTOs.VentaDTO;
import exception.SalidaException;
import java.util.ArrayList;
import java.util.List;
import salidas.IRealizarSalida;

/**
 *
 * @author janot
 */
public class Observable implements IObservable{
    List<IObservador> listaObservadores = new ArrayList<>();
    
    @Override
    public void addObserver(IObservador observador) {
        listaObservadores.add(observador);
    }

    @Override
    public void deleteObserver(IObservador observador) {
        listaObservadores.remove(observador);
    }

    @Override
    public void notifyObservers(VentaDTO venta, IRealizarSalida realizarSalida) throws SalidaException{
        for (IObservador observador : listaObservadores) {
            try {
                observador.update(venta, realizarSalida);
            } catch (SalidaException e) {
                throw new SalidaException(e.getMessage());
            }
            
        }
    }
}
