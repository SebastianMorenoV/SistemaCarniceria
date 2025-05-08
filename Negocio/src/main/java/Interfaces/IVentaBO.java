/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ProductosVentaDTO;
import DTOs.VentaDTO;
import Exception.NegocioException;

/**
 *
 * @author Sebastian Moreno
 */
public interface IVentaBO {

    public VentaDTO registrarVenta(VentaDTO ventaDTO) throws NegocioException;

    public ProductosVentaDTO obtenerProductosVenta() throws NegocioException;
    
    public VentaDTO obtenerVentaPorTicket()throws NegocioException;
}
