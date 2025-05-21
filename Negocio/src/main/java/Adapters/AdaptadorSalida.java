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
        return new Salida(null, adaptadorProducto.convertirAEntidad(salidaDTO.getProducto()), new Date(), salidaDTO.getMotivo(), salidaDTO.getStockAntes(), salidaDTO.getCantidadSalida(), salidaDTO.getStockDespues());
    }
    
}
