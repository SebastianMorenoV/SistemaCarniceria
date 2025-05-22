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
    //Adaptador de salidas 
    private final IAdaptadorSalida adaptadorSalida = new AdaptadorSalida();
    
    //Salida DAO
    private final ISalidaDAO salidaDAO;
    
    //Constructor que tiene como parametro una fabrica de creadores DAO
    public SalidaBO(ICreadorDAO fabrica){
        this.salidaDAO = fabrica.crearSalidaDAO();
    }
    
    /**
     * Agrega una nueva salida a la base de datos
     * 
     * @param salida NuevaSalidaDTO 
     * @return La entidad Salida
     * @throws NegocioException Si no se logra hacer la insercion
     */
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

    /**
     * Funciona como un buscador de salidas, acepta nulos en cualquier parametro
     * 
     * @param nombre Nombre del producto que se desea buscar.
     * @param fechaDesde Fecha desde la que se desea saber las salidas
     * @param fechaHasta Fecha hasta la que se desea saber las salidas
     * @return Una lista con las salidas que cumplen el parametro.
     * 
     * @throws NegocioException Si no se logra hacer la busqueda
     */
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

