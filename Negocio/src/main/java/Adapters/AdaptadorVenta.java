/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.CrearVentaDTO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.MetodoPagoDTO;
import DTOs.NuevoProductoVentaDTO;
import DTOs.PagoViejoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import IAdapters.IAdaptadorEmpleado;
import IAdapters.IAdaptadorMetodoPago;
import IAdapters.IAdaptadorPago;
import IAdapters.IAdaptadorProductoVenta;
import IAdapters.IAdaptadorVenta;
import entidades.Empleado;
import entidades.MetodoPago;
import entidades.Pago;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class AdaptadorVenta implements IAdaptadorVenta {

    IAdaptadorEmpleado empleadoAdapter = new AdaptadorEmpleado();
    IAdaptadorProductoVenta productoVentaAdapter = new AdaptadorProductoVenta();
    IAdaptadorMetodoPago metodoPagoAdapter = new AdaptadorMetodoPago();
    IAdaptadorPago adaptadorPago = new AdaptadorPago();

    @Override
    public VentaDTO convertirADTO(Venta venta) {
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(venta.getId());

        EmpleadoCargadoDTO empleado = empleadoAdapter.convertirADTO(venta.getCajero());
        ventaDTO.setEmpleado(empleado);
        ventaDTO.setFechaHora(venta.getFechaHora());

        List<ProductoVenta> productosVenta = venta.getListaProductosVenta();
        List<ProductoVentaDTO> productosVentaDTO = new ArrayList<>();
        for (ProductoVenta productoVenta : productosVenta) {

            ProductoVentaDTO dto = productoVentaAdapter.convertirProductoVentaADTO(productoVenta);
            productosVentaDTO.add(dto);
        }

        ventaDTO.setListadoProductosVenta(productosVentaDTO);

        Pago pago = venta.getPago();
        PagoViejoDTO pagoDTO = adaptadorPago.convertirADTO(pago);
        if (pagoDTO != null) {
            ventaDTO.setPago(pagoDTO);
        }

        ventaDTO.setIva(venta.getIva());
        ventaDTO.setSubtotal(venta.getSubtotal());
        ventaDTO.setTotal(venta.getTotal());
        return ventaDTO;
    }

    @Override
    public Venta convertirAVenta(VentaDTO ventaDTO) {
        if (ventaDTO == null) {
            throw new IllegalArgumentException("El objeto ventaDTO es null en AdaptadorVenta.convertirAVenta");
        }
        Venta venta = new Venta();
        venta.setId(ventaDTO.getId());
        venta.setIva(ventaDTO.getIva());
        venta.setTotal(venta.getTotal());
        venta.setSubtotal(venta.getSubtotal());
        //setear el empleado
        EmpleadoCargadoDTO empleadoDTO = ventaDTO.getEmpleado();
        Empleado empleado = empleadoAdapter.convertirAEntidad(empleadoDTO);
        venta.setCajero(empleado);

        venta.setFechaHora(ventaDTO.getFechaHora());
        PagoViejoDTO pagoDTO = ventaDTO.getPago();

        Pago pago = adaptadorPago.convertirAEntidad(pagoDTO);

        venta.setPago(pago);

        List<ProductoVentaDTO> productosVentaDTO = ventaDTO.getListadoProductosVenta();
        List<ProductoVenta> productosVenta = productoVentaAdapter.convertirListaDTOAEntidad(productosVentaDTO);
        venta.setListaProductosVenta(productosVenta);

        return venta;
    }

    @Override
    public CrearVentaDTO VentaACrearVentaDTO(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta CrearVentaDTOAVenta(CrearVentaDTO ventaDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
