/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author Sebastian Moreno
 */
public class ProductoCargadoDTO {
    Long codigo;
    String nombre;
    String descripcion, categoria;
    double unidad;
    double precio; 
    boolean esPesable;

    public ProductoCargadoDTO(Long codigo, String nombre, String descripcion, String categoria, double unidad, double precio, boolean esPesable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.unidad = unidad;
        this.precio = precio;
        this.esPesable = esPesable;
    }

    public ProductoCargadoDTO() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getUnidad() {
        return unidad;
    }

    public void setUnidad(double unidad) {
        this.unidad = unidad;
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

    @Override
    public String toString() {
        return "ProductoCargadoDTO{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", unidad=" + unidad + ", precio=" + precio + ", esPesable=" + esPesable + '}';
    }
  
}

