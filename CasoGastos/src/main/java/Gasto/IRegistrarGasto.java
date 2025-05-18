/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Gasto;

import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import Exception.GastoException;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IRegistrarGasto {
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws GastoException;

    public void eliminarGasto(String folio) throws GastoException;

    public GastoDTO modificarGasto(CrearGastoDTO gastoDTO) throws GastoException;

    public List<GastoDTO> consultarGastos() throws GastoException;
    
    public void vaidarGastoDuplicado() throws GastoException;
    
}
