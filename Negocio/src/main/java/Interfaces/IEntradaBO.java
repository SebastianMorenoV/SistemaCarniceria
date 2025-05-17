/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.EntradaDAO;
import DTOs.EntradaDTO;
import DTOs.ProductosEntradaDTO;
import Exception.NegocioException;

/**
 *
 * @author HP
 */
public interface IEntradaBO {
    static IEntradaDAO obtenerInstanciaDAO(){
        return new EntradaDAO();
    }
    public EntradaDTO RegistrarEntrada(EntradaDTO entrada);
    public ProductosEntradaDTO obtenerProductosEntrada() throws NegocioException;
}
