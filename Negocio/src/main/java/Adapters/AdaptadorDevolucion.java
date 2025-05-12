package Adapters;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.ProductoVentaDTO;
import IAdapters.IAdaptadorDevolucion;
import IAdapters.IAdaptadorProductoVenta;
import entidades.Devolucion;
import entidades.ProductoVenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class AdaptadorDevolucion implements IAdaptadorDevolucion {

    IAdaptadorProductoVenta productoVentaAdapter = new AdaptadorProductoVenta();

    @Override
    public DevolucionDTO convertirADTO(Devolucion devolucion) {
        DevolucionDTO devolucionDTO = new DevolucionDTO();
        devolucionDTO.setNombreCompleto(devolucion.getNombreCompleto());
        devolucionDTO.setMontoDevuelto(devolucion.getMontoDevuelto());
        devolucionDTO.setNumeroTicket(devolucion.getId());

        devolucionDTO.setFechaHora(devolucion.getFechaHora());
        devolucionDTO.setRazon(devolucion.getRazon());
        devolucionDTO.setTelefono(devolucion.getTelefono());

        List<ProductoVenta> productosVenta = devolucion.getListadoProductosDevueltos();
        List<ProductoVentaDTO> productosVentaDTO = new ArrayList<>();
        for (ProductoVenta productoVenta : productosVenta) {

            ProductoVentaDTO dto = productoVentaAdapter.convertirProductoVentaADTO(productoVenta);
            productosVentaDTO.add(dto);
        }

        devolucionDTO.setProductosDevueltos(productosVentaDTO);

        return devolucionDTO;
    }

    @Override
    public Devolucion convertirAEntidad(CrearDevolucionDTO devolucionDTO) {
        Devolucion devolucion = new Devolucion();

        devolucion.setNombreCompleto(devolucionDTO.getNombreCompleto());
        devolucion.setMontoDevuelto(devolucionDTO.getMontoDevuelto());
        devolucion.setId(devolucionDTO.getNumeroTicket()); // o setNumeroTicket si tu entidad lo requiere
        devolucion.setFechaHora(devolucionDTO.getFechaHora());
        devolucion.setRazon(devolucionDTO.getRazon());
        devolucion.setTelefono(devolucionDTO.getTelefono());

        // Convertir productos devueltos
        List<ProductoVentaDTO> productosDevueltosDTO = devolucionDTO.getProductosDevueltos();
        List<ProductoVenta> productosDevueltos = new ArrayList<>();

        for (ProductoVentaDTO dto : productosDevueltosDTO) {
            ProductoVenta entidad = productoVentaAdapter.convertirProductoVentaAEntidad(dto);
            productosDevueltos.add(entidad);
        }

        devolucion.setListadoProductosDevueltos(productosDevueltos);

        return devolucion;
    }

}
