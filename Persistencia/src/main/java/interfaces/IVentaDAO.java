/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.VentaDAO;
import entidades.ProductoVenta;
import entidades.Venta;
import Exception.PersistenciaException;
import java.util.List;

/**
 * Esta clase representa la interfaz de la dao Venta se encarga de crear la DAO.
 *
 * @author Sebastian Moreno
 */
public interface IVentaDAO {

    static IVentaDAO obtenerInstanciaDAO() {
        return new VentaDAO(); // o podrías usar singleton aquí
    }

    public Venta registrarVenta(Venta venta) throws PersistenciaException;

    public Venta consultarVenta(Long id) throws PersistenciaException;

    public List<ProductoVenta> consultarProductosVenta() throws PersistenciaException;

}
