/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Venta;
import Exception.PersistenciaException;

/**
 * Esta clase representa la interfaz de la dao Venta
 * @author Sebastian Moreno
 */
public interface IVentaDAO {

    public Venta registrarVenta(Venta venta) throws PersistenciaException;

    public Venta consultarVenta(Long id) throws PersistenciaException;

}
