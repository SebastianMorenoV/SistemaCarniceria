/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ProveedorDTO {
    int id;
    String nombre;
    String telefono;

    public ProveedorDTO(int iDProveedor, String nombreProveedor, String telefono) {
        this.id = iDProveedor;
        this.nombre = nombreProveedor;
        this.telefono = telefono;
    }

    public ProveedorDTO() {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     @Override
    public String toString() {
        return "ProveedorDTO{" + "iDProveedor=" + id + ", nombreProveedor=" + nombre + ", telefono=" + telefono + '}';
    }
    
}
