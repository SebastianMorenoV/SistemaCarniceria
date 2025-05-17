/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.EntradaDTO;
import entidades.CrearEntrada;
import entidades.Entrada;
import DTOs.CrearEntradaDTO;
import DTOs.ProductosEntradaDTO;
import Exception.NegocioException;

/**
 *
 * @author HP
 */
public interface IEntradaBO {
    // va en los adapter
//    public EntradaDTO convertirADTO(Entrada entrada);
//    public Entrada convertirAEntidad(EntradaDTO entrada);
//    public CrearEntradaDTO EntradaACrearEntradaDTO(Entrada entrada);
//    public CrearEntrada CrearEntradaDTOAEntidad(CrearEntradaDTO ventaDTO);
    public EntradaDTO RegistrarEntrada();
    public ProductosEntradaDTO obtenerProductosVenta() throws NegocioException;
}
