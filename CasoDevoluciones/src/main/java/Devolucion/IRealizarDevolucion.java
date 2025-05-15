package Devolucion;

import DTOs.FechaDTO;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import DTOs.VentaDTO;
import Exception.DevolucionException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IRealizarDevolucion {

    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucionDTO) throws DevolucionException;

    public List<DevolucionDTO> consultarDevoluciones() throws DevolucionException;

    public List<DevolucionDTO> consultarDevolucionesPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws DevolucionException;

    public DevolucionDTO consultarDevolucionPorID(String id) throws DevolucionException;

    public VentaDTO validarTicket(String ticket);

    public void validarProductoRepetido();

    public void validarCamposLlenos();

    public void calcularResumen();

    public void validarValoresCampos();
}
