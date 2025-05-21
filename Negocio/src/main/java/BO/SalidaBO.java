package BO;

import Adapters.AdaptadorSalida;
import DTOs.NuevaSalidaDTO;
import DTOs.SalidaDTO;
import Exception.NegocioException;
import Exception.PersistenciaException;
import IAdapters.IAdaptadorSalida;
import Interfaces.ISalidaBO;
import Interfaces.ISalidaDAO;
import entidades.Salida;
import fabrica.ICreadorDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janot
 */
public class SalidaBO implements ISalidaBO{
    private final IAdaptadorSalida adaptadorSalida = new AdaptadorSalida();
    
    private final ISalidaDAO salidaDAO;
    
    public SalidaBO(ICreadorDAO fabrica){
        this.salidaDAO = fabrica.crearSalidaDAO();
    }
    
    @Override
    public SalidaDTO agregarNuevaSalida(NuevaSalidaDTO salida) throws NegocioException {
        Salida salidaNueva = adaptadorSalida.convertirAEntidad(salida);
        
        try {
            Salida salidaGuardada = salidaDAO.agregarNuevaSalida(salidaNueva);
            return adaptadorSalida.convertirADTO(salidaGuardada);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar nueva salida",e);
        }
    }

    @Override
    public List<SalidaDTO> consultarSalidasBuscador(String nombre, Date fechaDesde, Date fechaHasta) throws NegocioException {
        List<SalidaDTO> listaSalidaDTO = new ArrayList<>();
        
        try {
            List<Salida> listaSalidas = salidaDAO.consultarSalidasBuscador(nombre, fechaDesde, fechaHasta);
            for (Salida salida : listaSalidas) {
                SalidaDTO salidaDTO = adaptadorSalida.convertirADTO(salida);
                listaSalidaDTO.add(salidaDTO);
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al realizar el filtro", e);
        }
        
        return listaSalidaDTO;
    }
    
}

