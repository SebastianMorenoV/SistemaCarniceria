package Adapters;

import DTOs.NuevaSalidaDTO;
import DTOs.SalidaDTO;
import IAdapters.IAdaptadorProducto;
import IAdapters.IAdaptadorSalida;
import entidades.Salida;
import java.util.Date;

/**
 *
 * @author janot
 */
public class AdaptadorSalida implements IAdaptadorSalida{
    private final IAdaptadorProducto adaptadorProducto = new AdaptadorProducto();
    
    /**
     * Convierte una entidad Salida a SalidaDTO
     * 
     * @param salida Salida que se desea convertir
     * @return Objeto SalidaDTO con los datos de salida
     */
    @Override
    public SalidaDTO convertirADTO(Salida salida) {
        return new SalidaDTO(
                salida.getFecha(), 
                salida.getProducto(), 
                salida.getMotivo(), 
                salida.getStockAntes(), 
                salida.getCantidadSalida(), 
                salida.getStockDespues()
        );
    }

    /**
     * Convierte un SalidaDTO a Salida
     * 
     * @param salidaDTO que se desea convertir a entidad
     * @return Salida con los datos de SalidaDTO
     */
    @Override
    public Salida convertirAEntidad(NuevaSalidaDTO salidaDTO) {
        return new Salida(null, adaptadorProducto.convertirAEntidad(salidaDTO.getProducto()), new Date(), salidaDTO.getMotivo(), salidaDTO.getStockAntes(), salidaDTO.getCantidadSalida(), salidaDTO.getStockDespues());
    }
    
}
