/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gasto;

import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import Exception.GastoException;
import Exception.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IRegistrarGasto {
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws GastoException;

    public void eliminarGasto(String folio) throws GastoException;

    public GastoDTO modificarGasto(GastoDTO gastoDTO) throws GastoException;

    public List<GastoDTO> consultarGastos() throws GastoException;
    
    
    public List<GastoDTO> consultarGastosFiltrados(CrearGastoDTO gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws GastoException;
    
    public GastoDTO buscarPorFolio(String folio) throws GastoException;
    
}
