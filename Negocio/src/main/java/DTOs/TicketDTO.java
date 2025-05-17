/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class TicketDTO {
    Long id;
    List<ProductoVentaDTO> listaProductosVenta;
    LocalDateTime fechaHora;
    EmpleadoCargadoDTO cajero;
    double subtotal,total,iva;

    public TicketDTO() {
    }

    public TicketDTO(Long id, List<ProductoVentaDTO> listaProductosVenta, LocalDateTime fechaHora, EmpleadoCargadoDTO cajero, double subtotal, double total, double iva) {
        this.id = id;
        this.listaProductosVenta = listaProductosVenta;
        this.fechaHora = fechaHora;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.total = total;
        this.iva = iva;
    }
    

        public TicketDTO(List<ProductoVentaDTO> listaProductosVenta, LocalDateTime fechaHora, double iva, EmpleadoCargadoDTO cajero, double subtotal, double total) {
        this.listaProductosVenta = listaProductosVenta;
        this.fechaHora = fechaHora;
        this.iva = iva;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.total = total;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductoVentaDTO> getListaProductosVenta() {
        return listaProductosVenta;
    }

    public void setListaProductosVenta(List<ProductoVentaDTO> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EmpleadoCargadoDTO getCajero() {
        return cajero;
    }

    public void setCajero(EmpleadoCargadoDTO cajero) {
        this.cajero = cajero;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    

}
