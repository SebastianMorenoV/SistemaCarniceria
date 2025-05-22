package salidas;

import DTOs.ProductoCargadoDTO;
import DTOs.SalidaDTO;
import DTOs.NuevaSalidaDTO;
import Exception.NegocioException;
import Interfaces.IProductoBO;
import Interfaces.ISalidaBO;
import exception.SalidaException;
import java.util.Date;
import java.util.List;
import observerVentas.IObservador;
import observerVentas.Observador;

/**
 *
 * @author janot
 */
public class RealizarSalida implements IRealizarSalida{
    //Objeto SalidaBO para manejar las acciones de negocio
    private ISalidaBO salidaBO = manejadoresBO.ManejadorObjetosNegocio.crearSalidaBO();
    //Objeto productoBO para manejar las acciones de negocio
    private IProductoBO productoBO = manejadoresBO.ManejadorObjetosNegocio.crearProductoBO();
    
    //Observador Al cual se le notificara si hay una venta realizada
    private IObservador observador = new Observador();

    /**
     * Agrega una NuevaSalidaDTO 
     * 
     * @param nuevaSalida Nueva Salida que se agregara
     * @return SalidaDTO
     * @throws SalidaException Si en las validaciones no son correctads
     */
    @Override
    public SalidaDTO agregarNuevaSalida(NuevaSalidaDTO nuevaSalida) throws SalidaException {
        if (nuevaSalida.getProducto() == null) {
            throw new SalidaException("El Producto no puede estar vacio");
        }
        if(nuevaSalida.getMotivo() == null || nuevaSalida.getMotivo().trim().isEmpty()) {
            throw new SalidaException("El motivo no puede estar vacio");
        }
        if(nuevaSalida.getCantidadSalida() < 0){
            throw new SalidaException("La salida no puede ser negativa");
        }
        
        if(nuevaSalida.getCantidadSalida() == 0){
            throw new SalidaException("La salida no puede ser igual a 0");
        }
        
        if(nuevaSalida.getCantidadSalida() > nuevaSalida.getProducto().getStock()){
            throw new SalidaException("La salida no puede ser mayor al stock actual");
        }
        
        try {
            return salidaBO.agregarNuevaSalida(nuevaSalida);
        } catch (NegocioException e) {
            throw new SalidaException("Error al agregar salida",e);
        }
    }

    /**
     * Obtiene una lista con todas las salidas
     * @return Una lista con salidas
     * @throws SalidaException 
     */
    @Override
    public List<SalidaDTO> cargarTodasLasSalidas() throws SalidaException {
        try {
            return salidaBO.consultarSalidasBuscador(null, null, null);
        } catch (NegocioException e) {
            throw new SalidaException("Error al cargar todas las salidas", e);
        }
    }

    /**
     * Obtiene todas las salidas que son filtradas por los parametros
     * 
     * @param nombre
     * @param fechaDesde
     * @param fechaHasta
     * @return Una lista con salidas
     * @throws SalidaException 
     */
    @Override
    public List<SalidaDTO> filtrarSalidas(String nombre, Date fechaDesde, Date fechaHasta) throws SalidaException {
        try {
            return salidaBO.consultarSalidasBuscador(nombre, fechaDesde, fechaHasta);
        } catch (NegocioException e) {
            throw new SalidaException("Error al filtrar las salidas", e);
        }
    }

    /**
     * Devuelve una lista de ProductosCargadosDTO que coincidan con el nombre del parametro
     * @param nombre Nombre con el que se quieren encontrar coincidencias
     * @return Lista con ProductoCargadoDTO
     * @throws SalidaException 
     */
    @Override
    public List<ProductoCargadoDTO> buscadorProductos(String nombre) throws SalidaException {
        try {
            return productoBO.buscadorProducto(nombre);
        } catch (NegocioException e) {
            throw new SalidaException("Error al realizar la busqueda",e);
        }
    }

    /**
     * Sirve para obtener el objeto observer
     * @return IObserver
     */
    @Override
    public IObservador getObserver() {
        return observador;
    }

    /**
     * Resta el stock del producto
     * @param salida La cantidad que se le desea restar
     * @param codigo Codigo del producto
     * @return True si se logra restar y false en caso contrario
     * @throws SalidaException 
     */
    @Override
    public boolean restarStockAProducto(Double salida, Integer codigo) throws SalidaException {
        try {
            return productoBO.restarStockAProducto(salida, codigo);
        } catch (NegocioException e) {
            throw new SalidaException("Error al restar el stock", e);
        }
    }
    

}
