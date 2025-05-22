package BO;

import IAdapters.IAdaptadorProducto;
import Adapters.AdaptadorProducto;
import IAdapters.IAdaptadorProductoVenta;
import Adapters.AdaptadorProductoVenta;
import Adapters.AdaptadorVenta;
import DTOs.VentaDTO;
import IAdapters.IAdaptadorVenta;
import entidades.Venta;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IVentaBO;
import Interfaces.IVentaDAO;
import fabrica.ICreadorDAO;

/**
 * Manejador de conversion de objetos. Recibe un una fabrica , para crear la
 * DAO, se espera utilizar la DAO para acceder a la base de datos.
 *
 * @author Sebastian Moreno
 */
public class VentaBO implements IVentaBO {

    //Adapters necesarios para la ventaBO
    private final IAdaptadorVenta adaptadorVenta = new AdaptadorVenta();
    private final IAdaptadorProducto adaptadorProducto = new AdaptadorProducto();
    private final IAdaptadorProductoVenta adaptadorProductoVenta = new AdaptadorProductoVenta();
    
    //Venta DAO
    private final IVentaDAO ventaDAO;
    
    // Fabrica de Venta DAO
    public VentaBO(ICreadorDAO fabrica) {
        this.ventaDAO = fabrica.crearVentaDAO();
    }
    /**
     * Metodo para registrar una Venta en la BD.
     * @param ventaDTO el objeto VentaDTO pasado desde el CU. 
     * @return una VentaDTO convertida para su uso en capas superiores.
     * @throws NegocioException si existe un error registrando la venta.
     */
    @Override
    public VentaDTO registrarVenta(VentaDTO ventaDTO) throws NegocioException {

        Venta venta = adaptadorVenta.convertirAVenta(ventaDTO);

        try {
            venta = ventaDAO.registrarVenta(venta);
            VentaDTO ventaMapeada = adaptadorVenta.convertirADTO(venta);
            return ventaMapeada;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ocurrio un error registrando una venta en la base de datos." + ex.getMessage());
        }
    }
    /**
     * Metodo para obtener una venta por su numero de ticket asociado.
     * @param numeroTicket el numero de ticket asociado a la venta.
     * @return una VentaDTO convertida para su uso en capas superiores.
     * @throws NegocioException  si existe un error obteniendo la venta.
     */
    @Override
    public VentaDTO obtenerVentaPorTicket(String numeroTicket) throws NegocioException {

        try {
            Venta venta = ventaDAO.consultarVentaPorTicket(numeroTicket);
            VentaDTO ventaDTO = adaptadorVenta.convertirADTO(venta);
            return ventaDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ocurrio un error obteniendo la venta por ticket." + ex.getLocalizedMessage());
        }
    }
    /**
     * Metodo para validar si venta cuenta ya con una devolucion asignada.
     * @param codigoVenta el codigo de el ticket de la venta asignada.
     * @return true si la venta cuenta con devolucion , false si la venta no tiene devolucion.
     * @throws NegocioException Si existe un error consultando la venta.
     */
    @Override
    public boolean validarVentaConDevolucion(int codigoVenta)throws NegocioException{
  
        try {
            boolean venta = ventaDAO.buscarVentaSinDevolucion(codigoVenta);
            return venta;
        } catch (PersistenciaException ex) {
           throw new NegocioException("Ocurrio un error consultando la venta con devolucion." + ex.getMessage());
        }
    }

}
