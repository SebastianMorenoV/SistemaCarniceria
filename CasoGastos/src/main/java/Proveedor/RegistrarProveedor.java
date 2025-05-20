/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proveedor;

import DTOs.CrearProveedorDTO;
import DTOs.ProveedorDTO;
import Exception.GastoException;
import Exception.NegocioException;
import Interfaces.IProveedorBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RegistrarProveedor implements IRegistrarProveedor{
    
    private final IProveedorBO proveedorBO = manejadoresBO.ManejadorObjetosNegocio.crearProveedorBO();
    

    @Override
    public ProveedorDTO agregarProveedor(CrearProveedorDTO proveedorDTO) throws GastoException {
        
        try {
            //validaciones

            return proveedorBO.agregarProveedor(proveedorDTO);
        } catch (NegocioException ex) {
            throw new GastoException("No se pudo agregar al proveedor"+ ex.getLocalizedMessage());
        }
    }

    @Override
    public List<ProveedorDTO> consultarProveedores() throws GastoException {
        try {
            //validaciones

            return proveedorBO.consultarProveedores();
        } catch (NegocioException ex) {
            throw new GastoException("No se pudieron consultar los proveedores" + ex.getLocalizedMessage());
        }
    }

    @Override
    public ProveedorDTO buscarPorNombre(String nombre) throws GastoException {
                try {
            //validaciones

            return proveedorBO.buscarPorNombre(nombre);
        } catch (NegocioException ex) {
            throw new GastoException("No se pudieron consultar los proveedores" + ex.getLocalizedMessage());
        }
    }
    
    
    
}
