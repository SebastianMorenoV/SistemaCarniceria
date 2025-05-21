package Interfaces;

import DTOs.NuevaSalidaDTO;
import DTOs.SalidaDTO;
import Exception.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public interface ISalidaBO {
    public SalidaDTO agregarNuevaSalida(NuevaSalidaDTO salida) throws NegocioException;
    
    public List<SalidaDTO> consultarSalidasBuscador(String nombre, Date fechaDesde, Date fechaHasta) throws NegocioException;
}
