/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author Admin
 */
public class Proveedor {
    ObjectId _id;
    String nombre;
    String numero;

    public Proveedor() {
    }

    public Proveedor(ObjectId id, String nombre, String numero) {
        this._id = id;
        this.nombre = nombre;
        this.numero = numero;
    }
    
    public Proveedor(ObjectId id, String nombre) {
        this._id = id;
        this.nombre = nombre;
    }
    
    
    public Proveedor(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
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
        return "Proveedor{" + "id=" + _id + ", nombre=" + nombre + '}';
    }
    
    
}
