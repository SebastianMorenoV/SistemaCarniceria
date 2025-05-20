package IAdapters;

import DTOs.SalidaDTO;
import DTOs.Salidas.NuevaSalidaDTO;
import entidades.Salida;

/**
 *
 * @author janot
 */
public interface IAdaptadorSalida {
    public SalidaDTO convertirADTO(Salida salida);
    
    public Salida convertirAEntidad(NuevaSalidaDTO salidaDTO);
}
