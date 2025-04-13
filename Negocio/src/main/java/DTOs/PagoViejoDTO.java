/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author HP
 */
public class PagoViejoDTO{       
    int idPago;
    Date fechaHora;
    double monto;
    MetodoPagoDTO metodoPago;
    String estado;

    public PagoViejoDTO(int idPago, Date fechaHora, double monto, MetodoPagoDTO metodoPago, String estado) {
        this.idPago = idPago;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
    }
    
    public PagoViejoDTO() {
    }
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public MetodoPagoDTO getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoDTO metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
  

