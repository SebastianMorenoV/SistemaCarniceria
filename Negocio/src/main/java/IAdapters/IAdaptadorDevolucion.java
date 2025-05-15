
package IAdapters;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import entidades.Devolucion;

/**
 *
 * @author Sebastian Moreno
 */
public interface IAdaptadorDevolucion {
    public DevolucionDTO convertirADTO(Devolucion devolucion);
    public Devolucion convertirAEntidad(CrearDevolucionDTO devolucion);
    
    
}
