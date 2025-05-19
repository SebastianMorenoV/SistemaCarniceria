/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 * Esta clase representa una entidad Producto en el sistema.
 * @author Sebastian Moreno
 */
public class Producto {
    ObjectId _id;
    int id;
    String nombre;
    String descripcion;
    double precio;
    boolean esPesable;
    double unidad;
    int stock;

    public Producto() {
    }
    
    public Producto(int id, String nombre, String descripcion, double precio, boolean esPesable, double unidad, int texto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esPesable = esPesable;
        this.unidad = unidad;
        this.stock = texto;
    }

    public Producto(String nombre, String descripcion, double precio, boolean esPesable, double unidad, int texto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esPesable = esPesable;
        this.unidad = unidad;
        this.stock = texto;
    }

    public Producto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public ObjectId get_Id() {
        return _id;
    }

    public void set_Id(ObjectId id) {
        this._id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int texto) {
        this.stock = texto;
    }
    
    
    
}
