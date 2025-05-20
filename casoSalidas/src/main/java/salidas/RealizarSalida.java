package salidas;

import DTOs.SalidaDTO;
import DTOs.Salidas.NuevaSalidaDTO;
import Exception.NegocioException;
import Interfaces.IProductoBO;
import Interfaces.ISalidaBO;
import exception.SalidaException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public class RealizarSalida implements IRealizarSalida{
    private ISalidaBO salidaBO = manejadoresBO.ManejadorObjetosNegocio.crearSalidaBO();
    private IProductoBO productoBO = manejadoresBO.ManejadorObjetosNegocio.crearProductoBO();
    
    @Override
    public SalidaDTO agregarNuevaSalida(NuevaSalidaDTO nuevaSalida) throws SalidaException {
        try {
            return salidaBO.agregarNuevaSalida(nuevaSalida);
        } catch (NegocioException e) {
            throw new SalidaException("Error al agregar salida",e);
        }
    }

    @Override
    public List<SalidaDTO> cargarTodasLasSalidas() throws SalidaException {
        try {
            return salidaBO.consultarSalidasBuscador(null, null, null);
        } catch (NegocioException e) {
            throw new SalidaException("Error al cargar todas las salidas", e);
        }
    }

    @Override
    public List<SalidaDTO> filtrarSalidas(String nombre, Date fechaDesde, Date fechaHasta) throws SalidaException {
                try {
            return salidaBO.consultarSalidasBuscador(nombre, fechaDesde, fechaHasta);
        } catch (NegocioException e) {
            throw new SalidaException("Error al filtrar las salidas", e);
        }
    }
    
}
