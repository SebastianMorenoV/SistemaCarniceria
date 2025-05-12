package BO;

import Adapters.AdaptadorDevolucion;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import Exception.NegocioException;
import IAdapters.IAdaptadorDevolucion;
import Interfaces.IDevolucionBO;
import Interfaces.IDevolucionDAO;
import entidades.Devolucion;
import fabrica.ICreadorDAO;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionBO implements IDevolucionBO {

    // adapater
    private final IAdaptadorDevolucion adaptadorDevolucion = new AdaptadorDevolucion();
    // dao
    private final IDevolucionDAO devolucionDAO;
    //constructorFabrica

    public DevolucionBO(ICreadorDAO fabrica) {
        this.devolucionDAO = fabrica.crearDevolucionDAO();
    }

    @Override
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucion) throws NegocioException {
        Devolucion devolucionEntidad = adaptadorDevolucion.convertirAEntidad(devolucion);
        Devolucion devolucionInsertada = devolucionDAO.registrarDevolucion(devolucionEntidad);
        DevolucionDTO devolucionDTO = adaptadorDevolucion.convertirADTO(devolucionEntidad);
        return devolucionDTO;
    }

    @Override
    public List<DevolucionDTO> consultarDevoluciones() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(CrearDevolucionDTO devolucionDTO) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
