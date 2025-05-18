/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proveedor;

import DTOs.CrearProveedorDTO;
import DTOs.ProveedorDTO;
import Exception.GastoException;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IRegistrarProveedor {
    public ProveedorDTO agregarProveedor(CrearProveedorDTO proveedorDTO) throws GastoException;
    
    public List<ProveedorDTO> consultarProveedores() throws GastoException;
}
