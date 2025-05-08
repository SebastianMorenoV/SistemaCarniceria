
package Interfaces;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IDevolucionBO {
    
    
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucion) throws NegocioException;
    
    public List<DevolucionDTO> consultarDevoluciones() throws NegocioException;

    public List<DevolucionDTO> consultarDevolucionesPorFiltro(CrearDevolucionDTO devolucionDTO) throws NegocioException;


}
