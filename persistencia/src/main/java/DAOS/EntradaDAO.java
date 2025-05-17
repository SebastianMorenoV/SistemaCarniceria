/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAOS;

import Exception.PersistenciaException;
import Interfaces.IEntradaDAO;
import entidades.Entrada;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EntradaDAO implements IEntradaDAO{
    private static EntradaDAO instanceEntradaDAO;
    
    public EntradaDAO(){
        
    }
    public static EntradaDAO getInstanciaDAO(){
        if(instanceEntradaDAO == null){
            instanceEntradaDAO = new EntradaDAO();
        }
        return instanceEntradaDAO;
    }

    @Override
    public Entrada registrarEntrada(Entrada entrada) throws PersistenciaException {
        return new Entrada();
    
    }
    
}
