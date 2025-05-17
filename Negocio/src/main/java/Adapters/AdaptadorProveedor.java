/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adapters;

import DTOs.ProveedorDTO;
import IAdapters.IAdaptadorProveedor;
import entidades.Proveedor;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorProveedor implements IAdaptadorProveedor {

    @Override
    public ProveedorDTO convertirADTO(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO(proveedor.getId(), proveedor.getNombre(), proveedor.getTelefono());
        return proveedorDTO;
    }

    @Override
    public Proveedor convertirAEntidad(ProveedorDTO proveedor) {
        Proveedor proveedorEntidad = new Proveedor(proveedor.getId(), proveedor.getNombre(), proveedor.getTelefono());
        return proveedorEntidad;
    }

}
