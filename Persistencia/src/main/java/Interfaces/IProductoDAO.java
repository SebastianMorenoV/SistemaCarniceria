/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.ProductoDAO;
import Entidades.Producto;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public interface IProductoDAO {
    
     static IProductoDAO obtenerInstanciaDAO() {
        return new ProductoDAO(); // o podrías usar singleton aquí
    }
    public List<Producto> consultarProductos() throws PersistenciaException;
}
