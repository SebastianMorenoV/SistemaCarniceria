/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Adapters.AdaptadorCrearEntrada;
import DTOs.CrearEntradaDTO;
import DTOs.EntradaDTO;
import DTOs.ProductosEntradaDTO;
import Exception.NegocioException;
import IAdapters.IAdaptadorCrearEntrada;
import Interfaces.IEntradaBO;
import entidades.CrearEntrada;
import entidades.Entrada;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EntradaBO implements IEntradaBO{
    private final IAdaptadorCrearEntrada adaptadorEntrada = new AdaptadorCrearEntrada();
//    private final IAdaptadorProducto adaptadorProducto = new AdaptadorProducto();
//    private final IAdaptadorProductoVenta adaptadorProductoVenta = new adaptadorProductoVenta();

    @Override
    public EntradaDTO RegistrarEntrada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductosEntradaDTO obtenerProductosVenta() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}
