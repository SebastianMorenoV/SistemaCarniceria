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
    int codigo;
    String nombre;
    String descripcion;
    double decimal;

    public ProductoCargadoDTO(int codigo, String nombre, String descripcion, double decimal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.decimal = decimal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return codigo + " " + nombre + descripcion + "  $" + decimal;
    }
    
    
}
