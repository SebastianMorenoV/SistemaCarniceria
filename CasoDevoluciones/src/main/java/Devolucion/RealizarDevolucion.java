package Devolucion;

import DTOs.FechaDTO;
import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import DTOs.VentaDTO;
import Exception.DevolucionException;
import Exception.NegocioException;
import Interfaces.IDevolucionBO;
import Interfaces.IVentaBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class RealizarDevolucion implements IRealizarDevolucion {
    private IDevolucionBO devolucionBO = manejadoresBO.ManejadorObjetosNegocio.crearDevolucionesBO();
    private IVentaBO ventaBO = manejadoresBO.ManejadorObjetosNegocio.crearVentasBO();

    VentaDTO ventaTemporal = new VentaDTO();
    DevolucionDTO devolucionTemporal = new DevolucionDTO();

    @Override
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucionDTO) throws DevolucionException {
        try {
            // validaciones necesarias.
            System.out.println("id desde caso uso" + devolucionDTO.getVenta().getId());
            return devolucionBO.registrarDevolucion(devolucionDTO);
        } catch (NegocioException ex) {
            Logger.getLogger(RealizarDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<DevolucionDTO> consultarDevoluciones() throws DevolucionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws DevolucionException {
        try {
           return devolucionBO.consultarDevolucionesPorFiltro(devolucionDTO);
        } catch (NegocioException ex) {
            throw new DevolucionException("Ocurrio un error encontrando devoluciones por filtro." + ex.getMessage());
        }
    }
    
    public DevolucionDTO consultarDevolucionPorID(String id) throws DevolucionException {
        try {
            return devolucionBO.consultarDevolucionPorID(id);
        } catch (NegocioException ex) {
            throw new DevolucionException("Error al buscar una devolucion por id :" + ex.getMessage());
        }
    }
        
    @Override
    public VentaDTO validarTicket(String ticket) {
        //logica para validar el ticket
        // regex, etc.

        if (ticket != null) {
            try {
                ventaTemporal = ventaBO.obtenerVentaPorTicket(ticket);
                return ventaTemporal;
            } catch (NegocioException ex) {
                Logger.getLogger(RealizarDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    @Override
    public void validarProductoRepetido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarCamposLlenos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void calcularResumen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarValoresCampos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public VentaDTO getVentaTemporal() {
        return ventaTemporal;
    }

    public void setVentaTemporal(VentaDTO venta) {
        this.ventaTemporal = venta;
    }

    public DevolucionDTO getDevolucionTemporal() {
        return devolucionTemporal;
    }

    public void setDevolucionTemporal(DevolucionDTO devolucionTemporal) {
        this.devolucionTemporal = devolucionTemporal;
    }
    
    

}
