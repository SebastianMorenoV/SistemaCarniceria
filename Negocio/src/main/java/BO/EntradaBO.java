/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Adapters.AdaptadorEntrada;
import DAOS.EntradaDAO;
import DTOs.EntradaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductoEntradaDTO;
import Exception.NegocioException;
import Exception.PersistenciaException;
import IAdapters.IAdaptadorEntrada;
import Interfaces.IEntradaBO;
import Interfaces.IEntradaDAO;
import entidades.Entrada;
import fabrica.ICreadorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EntradaBO implements IEntradaBO{
    private final IAdaptadorEntrada adaptadorEntrada = new AdaptadorEntrada();

    private final IEntradaDAO entradaDAO;
    
    public EntradaBO(ICreadorDAO fabrica){
        this.entradaDAO = fabrica.crearEntradaDAO();
    }
    
    @Override
    public EntradaDTO registrarEntrada(EntradaDTO entrada) {
        List<ProductoEntradaDTO> p = entrada.getListaProductosEntrada();
      
        Entrada entradaARegistrar = adaptadorEntrada.convertirAEntidad(entrada);
        try {
            entradaARegistrar = entradaDAO.registrarEntrada(entradaARegistrar);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EntradaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntradaDTO entradaMapeada = adaptadorEntrada.convertirADTO(entradaARegistrar);
        return entradaMapeada;
        
    }

    @Override
    public List<ProductoCargadoDTO> obtenerProductosEntrada() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
