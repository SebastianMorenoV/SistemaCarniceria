/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.EntradaDAO;
import Exception.PersistenciaException;
import entidades.Entrada;
import entidades.Producto;
import java.util.List;

public interface IEntradaDAO {

    static IEntradaDAO obtenerIntanciaDAO(){
        return new EntradaDAO();
    }
    public Entrada registrarEntrada(Entrada entrada)throws PersistenciaException;

    public List<Producto> ConsultarProductos()throws PersistenciaException;
}