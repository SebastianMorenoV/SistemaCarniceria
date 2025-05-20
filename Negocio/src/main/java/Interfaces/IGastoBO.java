/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import Exception.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGastoBO {
    
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws NegocioException;
    
    public void eliminarGasto(String folio) throws NegocioException;
    
    public GastoDTO modificarGasto(GastoDTO gastoDTO) throws NegocioException;
    
    public List<GastoDTO> consultarGastos() throws NegocioException;
    
    public List<GastoDTO> consultarGastosFiltrados(CrearGastoDTO gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException;
    
    public GastoDTO buscarPorFolio(String folio) throws NegocioException;
}
