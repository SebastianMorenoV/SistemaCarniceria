/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.ProveedorDTO;
import entidades.Proveedor;

/**
 *
 * @author HP
 */
public interface IAdaptadorProveedor {
    public ProveedorDTO convertirADTO(Proveedor proveedor);
    public Proveedor convertirAEntidad(ProveedorDTO proveedor);
    
}
