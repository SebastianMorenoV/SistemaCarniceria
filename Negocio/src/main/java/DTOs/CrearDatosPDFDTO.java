/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CrearDatosPDFDTO {
    String titulo;
    LocalDate fechaGasto;
    List<String> listaDatos;

    public CrearDatosPDFDTO() {
    }

    public CrearDatosPDFDTO(String titulo, LocalDate fechaGasto, List<String> listaDatos) {
        this.titulo = titulo;
        this.fechaGasto = fechaGasto;
        this.listaDatos = listaDatos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(LocalDate fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public List<String> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<String> listaDatos) {
        this.listaDatos = listaDatos;
    }
    
    
}
