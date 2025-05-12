package Devolucion;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
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

    @Override
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucionDTO) throws DevolucionException {
        try {
            // validaciones necesarias.
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
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(CrearDevolucionDTO devolucionDTO) throws DevolucionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

}
