package Interfaces;

import DTOs.FechaDTO;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IDevolucionBO {

    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucion) throws NegocioException;

    public List<DevolucionDTO> consultarDevoluciones() throws NegocioException;

    public List<DevolucionDTO> consultarDevolucionesPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws NegocioException;

    public DevolucionDTO consultarDevolucionPorID(String id) throws NegocioException;

}
