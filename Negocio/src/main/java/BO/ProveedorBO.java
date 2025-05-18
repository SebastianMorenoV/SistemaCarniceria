/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Adapters.AdaptadorProveedor;
import DTOs.ProveedorDTO;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IProveedorBO;
import Interfaces.IProveedorDAO;
import entidades.Proveedor;
import fabrica.ICreadorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ProveedorBO implements IProveedorBO{
    private AdaptadorProveedor adaptadorProveedor;
    private IProveedorDAO proveedorDAO;

    public ProveedorBO(ICreadorDAO fabrica) {
        this.proveedorDAO = fabrica.crearProveedorDAO();
        this.adaptadorProveedor = new AdaptadorProveedor();
    }

    @Override
    public List<ProveedorDTO> cargarProveedores() throws NegocioException {
        List<ProveedorDTO> listaProveedoresDTO = new ArrayList<>();
        try {
            List<Proveedor> listaProveedores = proveedorDAO.ConsultarProveedores();

            for (Proveedor proveedor : listaProveedores) {
                ProveedorDTO dto = adaptadorProveedor.convertirADTO(proveedor);  //convertir usando el adaptador
                listaProveedoresDTO.add(dto);
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo consultar los productos: " + ex.getMessage(), ex);
        }

        return listaProveedoresDTO;
    }

    @Override
    public void registrarProveedor(ProveedorDTO proveedor)throws NegocioException {
        try {
            Proveedor provedorEntidad =  adaptadorProveedor.convertirAEntidad(proveedor);
            proveedorDAO.registrarProveedor(provedorEntidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo consultar los productos: " + ex.getMessage(), ex);
        } 
    }
}
