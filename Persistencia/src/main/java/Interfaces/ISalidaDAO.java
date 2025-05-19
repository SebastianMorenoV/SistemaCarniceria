package Interfaces;

import Exception.PersistenciaException;
import entidades.Salida;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author janot
 */
public interface ISalidaDAO {
    public Salida agregarNuevaSalida(Salida salida) throws PersistenciaException;
    
    public List<Salida> consultarSalidasPorNombre(String nombre) throws PersistenciaException;
    
    public List<Salida> consultarSalidasPorFecha(LocalDateTime fecha) throws PersistenciaException;
    
    public List<Salida> consultarSalidasPorMes(int mes, int año) throws PersistenciaException;
    
}
