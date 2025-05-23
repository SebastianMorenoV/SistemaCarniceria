/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class CrearVentaDTO {

    private double total, subtotal, iva;
    private LocalDateTime fechaHora;
    private EmpleadoCargadoDTO empleado;
    private List<NuevoProductoVentaDTO> listadoProductosVenta;
    private MetodoPagoDTO metodoPago;

    public CrearVentaDTO() {
    }

    public CrearVentaDTO(double total, double subtotal, double iva, LocalDateTime fechaHora, EmpleadoCargadoDTO empleado, List<NuevoProductoVentaDTO> listadoProductosVenta, MetodoPagoDTO metodoPago) {
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.fechaHora = fechaHora;
        this.empleado = empleado;
        this.listadoProductosVenta = listadoProductosVenta;
        this.metodoPago = metodoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EmpleadoCargadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoCargadoDTO empleado) {
        this.empleado = empleado;
    }

    public List<NuevoProductoVentaDTO> getListadoProductosVenta() {
        return listadoProductosVenta;
    }

    public void setListadoProductosVenta(List<NuevoProductoVentaDTO> listadoProductosVenta) {
        this.listadoProductosVenta = listadoProductosVenta;
    }

    public MetodoPagoDTO getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoDTO metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    
}
