/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import entidades.Gasto;
import Exception.NegocioException;

/**
 *
 * @author Admin
 */
public interface IAdapterGasto {
    public GastoDTO ConvertirADTO(Gasto gasto);
    
    public Gasto ConvertirAEntidad(CrearGastoDTO gastoDTO);
    
    public Gasto ConvertirAEntidad(GastoDTO gastoDTO);
    
    public GastoDTO ConvertirADTO1(Gasto gasto);
}
