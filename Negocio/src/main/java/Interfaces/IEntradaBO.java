/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;


import DAOS.EntradaDAO;
import DTOs.EntradaDTO;
import DTOs.ProductoCargadoDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEntradaBO {
    static IEntradaDAO obtenerInstanciaDAO(){
        return new EntradaDAO();
    }
    // ¿¿¿Agregar como parametro ProductoEntradaDTO producto??? para persistir el producto
    
    public EntradaDTO RegistrarEntrada(EntradaDTO entrada)throws NegocioException;
    
    public List<ProductoCargadoDTO> obtenerProductosEntrada() throws NegocioException;
}