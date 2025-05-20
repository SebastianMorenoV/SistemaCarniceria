package Adapters;

import DTOs.SalidaDTO;
import DTOs.Salidas.NuevaSalidaDTO;
import IAdapters.IAdaptadorSalida;
import entidades.Salida;
import java.util.Date;

/**
 *
 * @author janot
 */
public class AdaptadorSalida implements IAdaptadorSalida{

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

    @Override
    public Salida convertirAEntidad(NuevaSalidaDTO salidaDTO) {
        return new Salida(null, salidaDTO.getProducto(), new Date(), salidaDTO.getMotivo(), salidaDTO.getStockAntes(), salidaDTO.getCantidadSalida(), salidaDTO.getStockDespues());
    }
    
}
