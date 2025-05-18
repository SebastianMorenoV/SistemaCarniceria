/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DatosPDF {
    String id;
    String titulo;
    LocalDate fecha;
    List<String> listaDatos;

    public DatosPDF() {
    }

    public DatosPDF(String id, String titulo, LocalDate fecha, List<String> listaDatos) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.listaDatos = listaDatos;
    }

    public DatosPDF(String titulo, LocalDate fecha, List<String> listaDatos) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.listaDatos = listaDatos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<String> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<String> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public String toString() {
        return "DatosPDF{" + "id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", listaDatos=" + listaDatos + '}';
    }
    
    
   
}
