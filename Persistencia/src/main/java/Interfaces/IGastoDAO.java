/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exception.PersistenciaException;
import MONGO.DAOS.GastoMongoDAO;
import entidades.Gasto;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGastoDAO {
    
    static IGastoDAO obtenerInstanciaDAO() {
        return new GastoMongoDAO(); // o podrías usar singleton aquí
    }
    
    public Gasto agregarGasto(Gasto gasto) throws PersistenciaException;
    
    public void eliminarGasto(String folio) throws PersistenciaException;
    
    public Gasto modificarGasto(Gasto gasto) throws PersistenciaException;
    
    public List<Gasto> consultarGastosFiltrados(Gasto gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException;
    
    public Gasto buscarPorFolio(String folio) throws PersistenciaException;
}
