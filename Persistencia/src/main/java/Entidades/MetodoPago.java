/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Sebastian Moreno
 */
public class MetodoPago {
    Tarjeta tarjeta;
    Efectivo efectivo;

    public MetodoPago() {
    }

    public MetodoPago(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public MetodoPago(Efectivo efectivo) {
        this.efectivo = efectivo;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Efectivo getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Efectivo efectivo) {
        this.efectivo = efectivo;
    }
            
    
}
