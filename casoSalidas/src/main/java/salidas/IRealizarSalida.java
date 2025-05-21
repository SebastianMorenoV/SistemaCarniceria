package salidas;

import DTOs.ProductoCargadoDTO;
import DTOs.SalidaDTO;
import DTOs.NuevaSalidaDTO;
import exception.SalidaException;
import java.util.Date;
import java.util.List;
import observerVentas.IObservador;

/**
 *
 * @author janot
 */
public interface IRealizarSalida {
    public SalidaDTO agregarNuevaSalida(NuevaSalidaDTO nuevaSalida) throws SalidaException;
    
    public List<SalidaDTO> cargarTodasLasSalidas() throws SalidaException;
    
    public List<SalidaDTO> filtrarSalidas(String nombre, Date fechaDesde, Date fechaHasta) throws SalidaException;
    
    public List<ProductoCargadoDTO> buscadorProductos(String nombre) throws SalidaException;
    
    public boolean restarStockAProducto(Double salida, Integer codigo) throws SalidaException;
    
    public IObservador getObserver();
}
