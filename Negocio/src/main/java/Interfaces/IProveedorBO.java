/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.CrearProveedorDTO;
import DTOs.ProveedorDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IProveedorBO {
    
    public ProveedorDTO agregarProveedor(CrearProveedorDTO proveedor) throws NegocioException;

    public ProveedorDTO agregarProveedorEntrada(ProveedorDTO proveedor) throws NegocioException;
    
    public List<ProveedorDTO> consultarProveedores() throws NegocioException;
    
}
