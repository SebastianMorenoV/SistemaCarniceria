/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Adapters.AdaptadorProveedor;
import DTOs.CrearProveedorDTO;
import DTOs.ProveedorDTO;
import entidades.Proveedor;
import Exception.NegocioException;
import Exception.PersistenciaException;
import IAdapters.IAdaptadorProveedor;
import Interfaces.IProveedorBO;
import Interfaces.IProveedorDAO;
import fabrica.ICreadorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProveedorBO implements IProveedorBO{
    
    private final IAdaptadorProveedor adaptadorProveedor = new AdaptadorProveedor();
    private final IProveedorDAO proveedorDAO;
    
    public ProveedorBO(ICreadorDAO fabrica) {
        this.proveedorDAO = fabrica.crearProveedorDAO();
        
    }

    @Override
    public ProveedorDTO agregarProveedor(CrearProveedorDTO proveedorDTO) throws NegocioException{
        
        Proveedor proveedor = adaptadorProveedor.ConvertirAEntidad(proveedorDTO);

        try {
            proveedor = proveedorDAO.agregarProveedor(proveedor);
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        ProveedorDTO proveedorMapeado = adaptadorProveedor.ConvertirADTO(proveedor);
        
        return proveedorMapeado;
        
    }

    @Override
    public List<ProveedorDTO> consultarProveedores() throws NegocioException {
        List<Proveedor> proveedores = null;
        List<ProveedorDTO> proveedoresDTO = new ArrayList<>();
        
        try {
            proveedores = proveedorDAO.consultarProveedores();
            for (Proveedor proveedor : proveedores) {
                ProveedorDTO proveedorDTO = adaptadorProveedor.ConvertirADTOEntrada(proveedor);
                proveedoresDTO.add(proveedorDTO);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proveedoresDTO;
    }

    @Override
    public ProveedorDTO agregarProveedorEntrada(ProveedorDTO proveedor) throws NegocioException {
                
        Proveedor proveedorEntidad = adaptadorProveedor.ConvertirAEntidad(proveedor);

        try {
            proveedorEntidad = proveedorDAO.agregarProveedor(proveedorEntidad);
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        ProveedorDTO proveedorMapeado = adaptadorProveedor.ConvertirADTO(proveedorEntidad);
        
        return proveedorMapeado;
    }
    
}
