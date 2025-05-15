package BO;

import Adapters.AdaptadorDevolucion;
import DTOs.FechaDTO;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import Exception.NegocioException;
import IAdapters.IAdaptadorDevolucion;
import Interfaces.IDevolucionBO;
import Interfaces.IDevolucionDAO;
import entidades.Devolucion;
import fabrica.ICreadorDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        System.out.println("Devolucion antes de mapper  BOOOO" + devolucion.getVenta().getId());
        Devolucion devolucionEntidad = adaptadorDevolucion.convertirAEntidad(devolucion);
        System.out.println("Devolucion desde la bo: + " + devolucionEntidad.getVenta().getId());
        Devolucion devolucionInsertada = devolucionDAO.registrarDevolucion(devolucionEntidad);
        DevolucionDTO devolucionDTO = adaptadorDevolucion.convertirADTO(devolucionEntidad);
        return devolucionDTO;
    }

    @Override
    public List<DevolucionDTO> consultarDevoluciones() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws NegocioException {
        
        Devolucion devolucionEntidad = new Devolucion();
        devolucionEntidad.setNombreCompleto(devolucionDTO.getNombreCompleto());
        devolucionEntidad.setTelefono(devolucionDTO.getTelefono());
        System.out.println(devolucionDTO.getFechaInicio());
        System.out.println(devolucionDTO.getFechaFin());
        
        List<Devolucion> devolucionesEncontradas = devolucionDAO.buscarDevolucionPorFiltro(devolucionEntidad, devolucionDTO.getFechaInicio(), devolucionDTO.getFechaFin());
        List<DevolucionDTO> devolucionesEncontradasDTO = new ArrayList<>();

        for (Devolucion devolucionesEncontrada : devolucionesEncontradas) {
            DevolucionDTO devolucion = adaptadorDevolucion.convertirADTO(devolucionesEncontrada);
            devolucionesEncontradasDTO.add(devolucion);
        }
        return devolucionesEncontradasDTO;
    }
    
    public DevolucionDTO consultarDevolucionPorID(String id) throws NegocioException{ // poner throws
        Devolucion devolucion = devolucionDAO.buscarPorID(id);
        DevolucionDTO devolucionDTO = adaptadorDevolucion.convertirADTO(devolucion);
        return devolucionDTO;
    }
}
