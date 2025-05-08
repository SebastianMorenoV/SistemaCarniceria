package BO;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import Exception.NegocioException;
import Interfaces.IDevolucionBO;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionBO implements IDevolucionBO {
    // adapater
    // dao

    //constructorFabrica
    @Override
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucion) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
