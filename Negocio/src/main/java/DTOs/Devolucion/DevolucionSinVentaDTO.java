/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.Devolucion;

import DTOs.ProductoVentaDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionSinVentaDTO {

    String nombreCompleto;
    String telefono;
    LocalDateTime fechaInicio;
    LocalDateTime fechaFin;

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public DevolucionSinVentaDTO() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "DevolucionSinVentaDTO{" + "nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

  
    
}
