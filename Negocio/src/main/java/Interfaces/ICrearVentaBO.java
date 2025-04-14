/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.CrearVentaDTO;
import Exception.NegocioException;

/**
 *
 * @author HP
 */
public interface ICrearVentaBO {
    public CrearVentaDTO crearVentaDTO()throws NegocioException;
    public CrearVentaDTO registrarCrearVentaDTO(CrearVentaDTO creadorVenta)throws NegocioException;

}
