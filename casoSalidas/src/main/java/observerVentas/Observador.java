package observerVentas;

import DTOs.NuevaSalidaDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import exception.SalidaException;
import salidas.IRealizarSalida;
import salidas.RealizarSalida;

/**
 *
 * @author janot
 */
public class Observador implements IObservador{ 
    @Override
    public void update(VentaDTO venta, IRealizarSalida realizarSalida) throws SalidaException{
        System.out.println("OOB-S-S--S-S-S-S--SE-E-E-E-E-RVEEEE-E-E-E-ER" + venta);
        System.out.println(venta.getListadoProductosVenta());
        //REGISTRAR LAS SALIDAS
        for (ProductoVentaDTO productoVentaDTO : venta.getListadoProductosVenta()) {
            NuevaSalidaDTO nuevaSalidaDTO = new NuevaSalidaDTO(productoVentaDTO.getProducto(), 
                    "Venta Realizada", 
                    productoVentaDTO.getProducto().getStock(), 
                    productoVentaDTO.getCantidad(), 
                    productoVentaDTO.getProducto().getStock() - productoVentaDTO.getCantidad());
            
            try {
                realizarSalida.agregarNuevaSalida(nuevaSalidaDTO);
                realizarSalida.restarStockAProducto(nuevaSalidaDTO.getCantidadSalida(), productoVentaDTO.getProducto().getCodigo());
            } catch (SalidaException e) {
                throw new SalidaException("Error al registrar la salida de la venta ",e);
            }
            
        }
        
    }
    
}
