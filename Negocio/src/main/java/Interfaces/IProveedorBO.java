/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ProveedorDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IProveedorBO {
    public List<ProveedorDTO> cargarProveedores() throws NegocioException;
    public void registrarProveedor(ProveedorDTO proveedor)throws NegocioException;
}
