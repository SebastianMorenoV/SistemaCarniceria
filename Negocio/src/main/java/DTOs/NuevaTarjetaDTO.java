/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author HP
 */
public class NuevaTarjetaDTO {
        String titular;
    String numeroTarjeta; //En el diagrama viene int pero se me hace mejor utilizando String
    String fechaVencimiento;
    int cvv;
    double saldoDisponible; // Cantidad de saldo disponible en 

    public NuevaTarjetaDTO(String titular, String numeroTarjeta, String fechaVencimiento, int cvv , double  saldo) {
        super();
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.saldoDisponible = saldo;
    }
    
    public NuevaTarjetaDTO(String titular, String numeroTarjeta, String fechaVencimiento, int cvv) {
        super();
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    public NuevaTarjetaDTO() {
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "NuevaTarjetaDTO{" + "titular=" + titular + ", numeroTarjeta=" + numeroTarjeta + ", fechaVencimiento=" + fechaVencimiento + ", cvv=" + cvv + ", saldoDisponible=" + saldoDisponible + '}';
    }


}
