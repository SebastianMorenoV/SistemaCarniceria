/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 * Esta clase representa una entidad Producto en el sistema.
 * @author Sebastian Moreno
 */
public class Producto {
    Long id;
    String nombre;
    String descripcion;
    double precio;
    boolean esPesable;
    double unidad;
    String texto;

    public Producto() {
    }
    
    public Producto(Long id, String nombre, String descripcion, double precio, boolean esPesable, double unidad, String texto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esPesable = esPesable;
        this.unidad = unidad;
        this.texto = texto;
    }

    public Producto(String nombre, String descripcion, double precio, boolean esPesable, double unidad, String texto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esPesable = esPesable;
        this.unidad = unidad;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsPesable() {
        return esPesable;
    }

    public void setEsPesable(boolean esPesable) {
        this.esPesable = esPesable;
    }

    public double getUnidad() {
        return unidad;
    }

    public void setUnidad(double unidad) {
        this.unidad = unidad;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
}
