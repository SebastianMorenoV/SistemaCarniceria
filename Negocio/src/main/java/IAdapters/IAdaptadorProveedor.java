/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.CrearProveedorDTO;
import DTOs.ProveedorDTO;
import entidades.Proveedor;
import Exception.NegocioException;

/**
 *
 * @author Admin
 */
public interface IAdaptadorProveedor {
    public ProveedorDTO ConvertirADTO(Proveedor proveedor);
    
    public Proveedor ConvertirAEntidad(CrearProveedorDTO proveedorDTO);
}
