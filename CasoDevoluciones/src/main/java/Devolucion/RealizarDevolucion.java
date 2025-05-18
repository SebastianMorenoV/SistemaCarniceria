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
            // Validar nombreCompleto (no vacío, solo letras y espacios)
            String nombre = devolucionDTO.getNombreCompleto();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                throw new DevolucionException("El nombre completo solo debe contener letras y espacios, sin números ni caracteres especiales.");
            }

            // Validar razón (solo letras y espacios)
            String razon = devolucionDTO.getRazon();
            if (razon == null || !razon.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                throw new DevolucionException("La razón solo debe contener letras y espacios, sin números ni caracteres especiales.");
            }

            // Validar teléfono (solo 10 dígitos)
            String telefono = devolucionDTO.getTelefono();
            if (telefono == null || !telefono.matches("^\\d{10}$")) {
                throw new DevolucionException("El teléfono debe contener exactamente 10 dígitos numéricos.");
            }

            // Si todo es válido, se procede con el registro
            return devolucionBO.registrarDevolucion(devolucionDTO);
        } catch (NegocioException ex) {
            Logger.getLogger(RealizarDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            throw new DevolucionException("Error al registrar la devolución: " + ex.getMessage());
        }
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
    public VentaDTO validarTicket(String ticket) throws DevolucionException {
        // Validar que el ticket no sea null o vacío
        if (ticket == null || ticket.trim().isEmpty()) {
            throw new DevolucionException("Debe proporcionar un número de ticket válido.");
        }

        try {
            ventaTemporal = ventaBO.obtenerVentaPorTicket(ticket);
            if (ventaTemporal == null) {
                throw new DevolucionException("No se encontró ninguna venta asociada al ticket ingresado.");
            }
            return ventaTemporal;
        } catch (NegocioException ex) {
            Logger.getLogger(RealizarDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            throw new DevolucionException("Error al buscar el ticket: " + ex.getMessage());
        }
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
