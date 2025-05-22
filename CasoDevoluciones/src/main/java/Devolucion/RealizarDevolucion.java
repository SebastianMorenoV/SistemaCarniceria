package Devolucion;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.Devolucion.DevolucionSinVentaDTO;
import DTOs.VentaDTO;
import Exception.DevolucionException;
import Exception.NegocioException;
import Interfaces.IDevolucionBO;
import Interfaces.IVentaBO;
import java.util.List;


/**
 * Esta clase representa el caso de uso para realizar una devolucion.
 * Aclaracion : Cuando un cliente quiere devolver uno o mas productos dentro de su venta.
 * solo se acepta una devolucion por venta.
 * @author Sebastian Moreno
 */
public class RealizarDevolucion implements IRealizarDevolucion {

    private IDevolucionBO devolucionBO = manejadoresBO.ManejadorObjetosNegocio.crearDevolucionesBO();
    private IVentaBO ventaBO = manejadoresBO.ManejadorObjetosNegocio.crearVentasBO();

    VentaDTO ventaTemporal = new VentaDTO();
    DevolucionDTO devolucionTemporal = new DevolucionDTO();
    /**
     * Metodo para registrar una devolucion.
     * Valida que los campos no sean nulos y que cumplan con ciertos valores estrictos los campos.
     * @param devolucionDTO es la nueva devolucion pasada por la presentacion para su creacion.
     * @return una DevolucionDTO ya ingresada en la base de datos
     * @throws DevolucionException si existe algun error registrando la devolucion.
     */
    @Override
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucionDTO) throws DevolucionException {
        try {
            String nombre = devolucionDTO.getNombreCompleto();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                throw new DevolucionException("El nombre completo solo debe contener letras y espacios, sin números ni caracteres especiales.");
            }
            
            String razon = devolucionDTO.getRazon();
            if (razon == null || !razon.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                throw new DevolucionException("La razón solo debe contener letras y espacios, sin números ni caracteres especiales.");
            }

            String telefono = devolucionDTO.getTelefono();
            if (telefono == null || !telefono.matches("^\\d{10}$")) {
                throw new DevolucionException("El teléfono debe contener exactamente 10 dígitos numéricos.");
            }

            return devolucionBO.registrarDevolucion(devolucionDTO);
        } catch (NegocioException ex) {
            throw new DevolucionException("Error al registrar la devolución: " + ex.getMessage());
        }
    }
    /**
     * Metodo para consultar todas las devoluciones.
     * @return Lista de devolucionesDTO consultadas.
     * @throws DevolucionException si exsite un error buscando.
     */
    @Override
    public List<DevolucionDTO> consultarDevoluciones() throws DevolucionException {
        try {
            return devolucionBO.consultarDevoluciones();
        } catch (NegocioException ex) {
            throw new DevolucionException("Ocurrio un error encontrando devoluciones ." + ex.getMessage());
        }
    }
    /**
     * Metodo para consultar las devoluciones por filtro.
     * Este metodo es dinamico , lo cual se ejecuta muchas veces , dependiendo de
     * la devolucionDTO pasada como parametro.
     * @param devolucionDTO es una devolucion con ciertos valores , por los cual se va filtrar.
     * puede venir 0 o muchos de los filtros necesarios.
     * @return Lista de DevolucionDTO consultada.
     * @throws DevolucionException si ocurrio un error consultando las devoluciones por filtro.
     */
    @Override
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(DevolucionSinVentaDTO devolucionDTO) throws DevolucionException {
        try {
            return devolucionBO.consultarDevolucionesPorFiltro(devolucionDTO);
        } catch (NegocioException ex) {
            throw new DevolucionException("Ocurrio un error encontrando devoluciones por filtro." + ex.getMessage());
        }
    }
    /**
     * Metodo para buscar una devolucion por su id.
     * @param id el id de la devolucion a buscar.
     * @return una DevolucionDTO consultada.
     * @throws DevolucionException si existe algun error.
     */
    public DevolucionDTO consultarDevolucionPorID(String id) throws DevolucionException {
        try {
            return devolucionBO.consultarDevolucionPorID(id);
        } catch (NegocioException ex) {
            throw new DevolucionException("Error al buscar una devolucion por id :" + ex.getMessage());
        }
    }
    /**
     * Metodo para validar el ticket de la venta pasada a la devolucion.
     * Este metodo valida que el ticket no este vacio , no tenga ninguna devolucion asociada,
     * que el numero de el ticket sea valido.
     * @param ticket el numero de el ticket asociado a una venta.
     * @return la VentaDTO asociada al numero de ticket para realizar la devolucion.
     * @throws DevolucionException si existe un error valiando el ticket.
     */
    @Override
    public VentaDTO validarTicket(String ticket) throws DevolucionException {

        if (ticket == null || ticket.trim().isEmpty()) {
            throw new DevolucionException("Debe proporcionar un número de ticket válido.");
        }

        try {
            ventaTemporal = ventaBO.obtenerVentaPorTicket(ticket);
            if (ventaTemporal == null) {
                throw new DevolucionException("No se encontró ninguna venta asociada al ticket ingresado.");
            }

            boolean tieneDevolucion = ventaBO.validarVentaConDevolucion(ventaTemporal.getId());

            if (tieneDevolucion == false) {
                throw new DevolucionException("La venta ya tiene una devolución registrada y no puede devolverse nuevamente.");
            }

            return ventaTemporal;
        } catch (NegocioException ex) {
            throw new DevolucionException("Error al buscar el ticket: " + ex.getMessage());
        }
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
