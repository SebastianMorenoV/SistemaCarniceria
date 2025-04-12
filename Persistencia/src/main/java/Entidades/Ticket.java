/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

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
    
    
}
