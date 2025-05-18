/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Admin
 */
public class Proveedor {
    int id;
    String nombre;
    String numero;

    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }
    
    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    
    public Proveedor(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
