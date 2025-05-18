/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.CrearProveedorDTO;
import DTOs.ProveedorDTO;
import entidades.Proveedor;
import Exception.NegocioException;
import IAdapters.IAdaptadorProveedor;

/**
 *
 * @author Admin
 */
public class AdaptadorProveedor implements IAdaptadorProveedor{

    @Override
    public ProveedorDTO ConvertirADTO(Proveedor proveedor){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setNombre(proveedor.getNombre());
        return proveedorDTO;
    }

    @Override
    public Proveedor ConvertirAEntidad(CrearProveedorDTO proveedorDTO){
        Proveedor proveedorEntidad = new Proveedor();
        proveedorEntidad.setNombre(proveedorDTO.getNombre());
        return proveedorEntidad;
    }
    
}
