package salidas;

import DTOs.SalidaDTO;
import DTOs.Salidas.NuevaSalidaDTO;
import exception.SalidaException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public interface IRealizarSalida {
    public SalidaDTO agregarNuevaSalida(NuevaSalidaDTO nuevaSalida) throws SalidaException;
    
    public List<SalidaDTO> cargarTodasLasSalidas() throws SalidaException;
    
    public List<SalidaDTO> filtrarSalidas(String nombre, Date fechaDesde, Date fechaHasta) throws SalidaException;
}
