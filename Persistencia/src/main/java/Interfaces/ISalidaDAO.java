package Interfaces;

import Exception.PersistenciaException;
import entidades.Salida;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public interface ISalidaDAO {
    public Salida agregarNuevaSalida(Salida salida) throws PersistenciaException;
    
    public List<Salida> consultarSalidasBuscador(String nombre, Date fechaDesde, Date fechaHasta) throws PersistenciaException;
    
}
