package IAdapters;

import DTOs.NuevaSalidaDTO;
import DTOs.SalidaDTO;
import entidades.Salida;

/**
 *
 * @author janot
 */
public interface IAdaptadorSalida {
    public SalidaDTO convertirADTO(Salida salida);
    
    public Salida convertirAEntidad(NuevaSalidaDTO salidaDTO);
}
