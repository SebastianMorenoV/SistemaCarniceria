/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Sebastian Moreno
 */
public class Pago {

    Long id;
    MetodoPago metodoPago;
    LocalDateTime fechaHora;
    double monto;
    String estado;

    public Pago() {
    }

    public Pago(Long id, MetodoPago metodoPago, LocalDateTime fechaHora, double monto, String estado) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.estado = estado;
    }

    public Pago(MetodoPago metodoPago, LocalDateTime fechaHora, double monto, String estado) {
        this.metodoPago = metodoPago;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
