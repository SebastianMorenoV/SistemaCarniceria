package BO;

import Adapters.AdaptadorDevolucion;
import DTOs.FechaDTO;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import Exception.NegocioException;
import Exception.PersistenciaException;
import IAdapters.IAdaptadorDevolucion;
import Interfaces.IDevolucionBO;
import Interfaces.IDevolucionDAO;
import entidades.Devolucion;
import fabrica.ICreadorDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            Devolucion devolucionInsertada = devolucionDAO.registrarDevolucion(devolucionEntidad);
        } catch (PersistenciaException ex) {
            Logger.getLogger(DevolucionBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DevolucionDTO devolucionDTO = adaptadorDevolucion.convertirADTO(devolucionEntidad);
        return devolucionDTO;
    }

    @Override
    public List<DevolucionDTO> consultarDevoluciones() throws NegocioException {
        try {
            List<Devolucion> devolucionesEncontradas = devolucionDAO.buscarDevoluciones();
            List<DevolucionDTO> devolucionesEncontradasDTO = new ArrayList<>();

            for (Devolucion devolucion : devolucionesEncontradas) {
                DevolucionDTO dto = adaptadorDevolucion.convertirADTO(devolucion);
                devolucionesEncontradasDTO.add(dto);
            }

            return devolucionesEncontradasDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(DevolucionBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al consultar devoluciones", ex);
        }
    }

    @Override
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws NegocioException {

        try {
            Devolucion devolucionEntidad = new Devolucion();
            devolucionEntidad.setNombreCompleto(devolucionDTO.getNombreCompleto());
            devolucionEntidad.setTelefono(devolucionDTO.getTelefono());

            List<Devolucion> devolucionesEncontradas = devolucionDAO.buscarDevolucionPorFiltro(devolucionEntidad, devolucionDTO.getFechaInicio(), devolucionDTO.getFechaFin());
            List<DevolucionDTO> devolucionesEncontradasDTO = new ArrayList<>();

            for (Devolucion devolucionesEncontrada : devolucionesEncontradas) {
                DevolucionDTO devolucion = adaptadorDevolucion.convertirADTO(devolucionesEncontrada);
                devolucionesEncontradasDTO.add(devolucion);
            }
            return devolucionesEncontradasDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(DevolucionBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DevolucionDTO consultarDevolucionPorID(String id) throws NegocioException {
        try {
            // poner throws
            Devolucion devolucion = devolucionDAO.buscarPorID(id);
            DevolucionDTO devolucionDTO = adaptadorDevolucion.convertirADTO(devolucion);
            return devolucionDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(DevolucionBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
