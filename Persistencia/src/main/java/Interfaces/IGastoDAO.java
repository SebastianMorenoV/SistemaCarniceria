/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exception.PersistenciaException;
import entidades.Gasto;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGastoDAO {
    public Gasto agregarGasto(Gasto gasto) throws PersistenciaException;
    
    public void eliminarGasto(String folio) throws PersistenciaException;
    
    public Gasto modificarGasto(Gasto gasto) throws PersistenciaException;
    
    public List<Gasto> consultarGastos() throws PersistenciaException;
    
    public List<Gasto> consultarGastosFiltrados(Gasto gastoFiltro) throws PersistenciaException;
}
