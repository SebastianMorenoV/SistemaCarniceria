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
    int iDProveedor;
    String nombreProveedor;
    String telefono;

    public ProveedorDTO(int iDProveedor, String nombreProveedor, String telefono) {
        this.iDProveedor = iDProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
    }

    public ProveedorDTO() {
    }

    public int getiDProveedor() {
        return iDProveedor;
    }

    public void setiDProveedor(int iDProveedor) {
        this.iDProveedor = iDProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     @Override
    public String toString() {
        return "ProveedorDTO{" + "iDProveedor=" + iDProveedor + ", nombreProveedor=" + nombreProveedor + ", telefono=" + telefono + '}';
    }
    
}
