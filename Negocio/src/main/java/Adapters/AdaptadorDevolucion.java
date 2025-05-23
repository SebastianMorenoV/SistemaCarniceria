package Adapters;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import IAdapters.IAdaptadorDevolucion;
import IAdapters.IAdaptadorEmpleado;
import IAdapters.IAdaptadorProductoVenta;
import IAdapters.IAdaptadorVenta;
import entidades.Devolucion;
import entidades.Empleado;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class AdaptadorDevolucion implements IAdaptadorDevolucion {

    IAdaptadorProductoVenta productoVentaAdapter = new AdaptadorProductoVenta();
    IAdaptadorVenta ventaAdapter = new AdaptadorVenta();
    IAdaptadorEmpleado empleadoAdapter = new AdaptadorEmpleado();

    @Override
    public DevolucionDTO convertirADTO(Devolucion devolucion) {
        DevolucionDTO devolucionDTO = new DevolucionDTO();
        devolucionDTO.setId(devolucion.getId());
        EmpleadoCargadoDTO empleadoDTO = empleadoAdapter.convertirADTO(devolucion.getCajeroDevolucion());
        devolucionDTO.setCajeroDevolucion(empleadoDTO);
        devolucionDTO.setNombreCompleto(devolucion.getNombreCompleto());
        devolucionDTO.setMontoDevuelto(devolucion.getMontoDevuelto());
        devolucionDTO.setNumeroTicket(devolucion.getId());

        devolucionDTO.setFechaHora(devolucion.getFechaHora());
        devolucionDTO.setRazon(devolucion.getRazon());
        devolucionDTO.setTelefono(devolucion.getTelefono());

        Venta venta = devolucion.getVenta();
        VentaDTO ventaDTO = ventaAdapter.convertirADTO(venta);
        devolucionDTO.setVenta(ventaDTO);

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
        Empleado empleado = empleadoAdapter.convertirAEntidad(devolucionDTO.getCajeroDevolucion());
        devolucion.setCajeroDevolucion(empleado);
        devolucion.setMontoDevuelto(devolucionDTO.getMontoDevuelto());
        devolucion.setFechaHora(devolucionDTO.getFechaHora());
        devolucion.setRazon(devolucionDTO.getRazon());
        devolucion.setTelefono(devolucionDTO.getTelefono());

        VentaDTO ventaDTO = devolucionDTO.getVenta();
        Venta venta = ventaAdapter.convertirAVenta(ventaDTO);

        devolucion.setVenta(venta);
        // Validar que la lista no sea null
        List<ProductoVentaDTO> productosDevueltosDTO = devolucionDTO.getProductosDevueltos();
        List<ProductoVenta> productosDevueltos = new ArrayList<>();

        if (productosDevueltosDTO != null && !productosDevueltosDTO.isEmpty()) {
            for (ProductoVentaDTO dto : productosDevueltosDTO) {
                ProductoVenta entidad = productoVentaAdapter.convertirProductoVentaAEntidad(dto);
                productosDevueltos.add(entidad);
            }
        }

        devolucion.setListadoProductosDevueltos(productosDevueltos);

        return devolucion;
    }

}
