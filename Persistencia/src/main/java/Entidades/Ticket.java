/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class Ticket {

    Long id;
    List<ProductoVenta> listaProductosVenta;
    LocalDateTime fechaHora;
    double iva;
    Empleado cajero;
    double subtotal;
    double total;

    public Ticket() {
    }

    public Ticket(Long id, List<ProductoVenta> listaProductosVenta, LocalDateTime fechaHora, double iva, Empleado cajero, double subtotal, double total) {
        this.id = id;
        this.listaProductosVenta = listaProductosVenta;
        this.fechaHora = fechaHora;
        this.iva = iva;
        this.cajero = cajero;
        this.subtotal = subtotal;
        this.total = total;
    }

    public Ticket(List<ProductoVenta> listaProductosVenta, LocalDateTime fechaHora, double iva, Empleado cajero, double subtotal, double total) {
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

    public List<ProductoVenta> getListaProductosVenta() {
        return listaProductosVenta;
    }

    public void setListaProductosVenta(List<ProductoVenta> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Empleado getCajero() {
        return cajero;
    }

    public void setCajero(Empleado cajero) {
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

}
