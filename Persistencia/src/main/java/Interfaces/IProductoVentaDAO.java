/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.VentaDAO;

/**
 *
 * @author Sebastian Moreno
 */
public interface IProductoVentaDAO {
    static IVentaDAO obtenerInstanciaDAO() {
        return new VentaDAO(); // o podrías usar singleton aquí
    }
}
