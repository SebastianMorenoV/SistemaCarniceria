/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Exception.PersistenciaException;
import Interfaces.ICrearVentaDAO;
import entidades.CrearVenta;

/**
 *
 * @author HP
 */
public class CrearVentaDAO implements ICrearVentaDAO{
    private static CrearVentaDAO crearVentaDAO;

    public CrearVentaDAO() {
    }
    
    public static CrearVentaDAO CrearVentaDAO(){
        if (crearVentaDAO == null) {
            crearVentaDAO = new CrearVentaDAO();
        }

        return crearVentaDAO;
    }

    @Override
    public CrearVenta crearVenta() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CrearVenta consultarVentaPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


   
}
