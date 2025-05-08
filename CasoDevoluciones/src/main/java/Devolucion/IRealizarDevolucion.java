package Devolucion;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import Exception.DevolucionException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IRealizarDevolucion {

    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucionDTO) throws DevolucionException;

    public List<DevolucionDTO> consultarDevoluciones() throws DevolucionException;

    public List<DevolucionDTO> consultarDevolucionesPorFiltro(CrearDevolucionDTO devolucionDTO) throws DevolucionException;

    public boolean validarTicket(String ticket);

    public void validarProductoRepetido();

    public void validarCamposLlenos();

    public void calcularResumen();

    public void validarValoresCampos();
}
