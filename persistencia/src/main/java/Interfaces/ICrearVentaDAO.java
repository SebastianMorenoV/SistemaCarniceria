/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.CrearVentaDAO;
import Exception.PersistenciaException;
import entidades.CrearVenta;

/**
 *
 * @author HP
 */
public interface ICrearVentaDAO {
    
    static ICrearVentaDAO obtenerInstanciaDAO() {
        return new CrearVentaDAO(); // o podrías usar singleton aquí
    }

    public CrearVenta crearVenta() throws PersistenciaException;

    public CrearVenta consultarVentaPorId(Long id) throws PersistenciaException;
}

