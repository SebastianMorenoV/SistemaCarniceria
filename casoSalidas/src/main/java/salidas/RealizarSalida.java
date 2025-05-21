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

/**
 *
 * @author janot
 */
public class RealizarSalida implements IRealizarSalida{
    private ISalidaBO salidaBO = manejadoresBO.ManejadorObjetosNegocio.crearSalidaBO();
    private IProductoBO productoBO = manejadoresBO.ManejadorObjetosNegocio.crearProductoBO();
    
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

    @Override
    public List<SalidaDTO> cargarTodasLasSalidas() throws SalidaException {
        try {
            return salidaBO.consultarSalidasBuscador(null, null, null);
        } catch (NegocioException e) {
            throw new SalidaException("Error al cargar todas las salidas", e);
        }
    }

    @Override
    public List<SalidaDTO> filtrarSalidas(String nombre, Date fechaDesde, Date fechaHasta) throws SalidaException {
                try {
            return salidaBO.consultarSalidasBuscador(nombre, fechaDesde, fechaHasta);
        } catch (NegocioException e) {
            throw new SalidaException("Error al filtrar las salidas", e);
        }
    }

    @Override
    public List<ProductoCargadoDTO> buscadorProductos(String nombre) throws SalidaException {
        try {
            return productoBO.buscadorProducto(nombre);
        } catch (NegocioException e) {
            throw new SalidaException("Error al realizar la busqueda",e);
        }
    }
}
