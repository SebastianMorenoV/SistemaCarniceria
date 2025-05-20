/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import DTOs.ProveedorDTO;
import entidades.Gasto;
import entidades.Proveedor;
import Exception.NegocioException;
import IAdapters.IAdaptadorEmpleado;
import IAdapters.IAdaptadorProveedor;
import IAdapters.IAdapterGasto;

/**
 *
 * @author Admin
 */
public class AdaptadorGasto implements IAdapterGasto {

    IAdaptadorProveedor adapter = new AdaptadorProveedor();

    @Override
    public GastoDTO ConvertirADTO(Gasto gasto) {
        GastoDTO gastoDTO = new GastoDTO();
        gastoDTO.setFolio(gasto.getFolio());
        gastoDTO.setFechaGasto(gasto.getFechaGasto());
        gastoDTO.setCategoria(gasto.getCategoria());

        gastoDTO.setProveedor(adapter.ConvertirADTO(gasto.getProveedor()));

        gastoDTO.setConcepto(gasto.getConcepto());
        gastoDTO.setMontoGasto(gasto.getMontoGasto());
        gastoDTO.setComprobante(gasto.getComprobante());
        gastoDTO.setMetodoPago(gasto.getMetodoPago());

        return gastoDTO;
    }

    @Override
    public Gasto ConvertirAEntidad(CrearGastoDTO gastoDTO) {
        Gasto gastoEntidad = new Gasto();
        gastoEntidad.setFolio(gastoDTO.getFolio());
        gastoEntidad.setFechaGasto(gastoDTO.getFechaGasto());
        gastoEntidad.setCategoria(gastoDTO.getCategoria());

        gastoEntidad.setProveedor(adapter.ConvertirAEntidad(gastoDTO.getProveedor()));

        gastoEntidad.setConcepto(gastoDTO.getConcepto());
        gastoEntidad.setMontoGasto(gastoDTO.getMontoGasto());
        gastoEntidad.setComprobante(gastoDTO.getComprobante());
        gastoEntidad.setMetodoPago(gastoDTO.getMetodoPago());

        return gastoEntidad;
    }

    @Override
    public Gasto ConvertirAEntidad(GastoDTO gastoDTO) {
        Gasto gastoEntidad = new Gasto();
        gastoEntidad.setId(gastoDTO.getId());
        gastoEntidad.setFolio(gastoDTO.getFolio());
        gastoEntidad.setFechaGasto(gastoDTO.getFechaGasto());
        gastoEntidad.setCategoria(gastoDTO.getCategoria());

        gastoEntidad.setProveedor(adapter.ConvertirAEntidad(gastoDTO.getProveedor()));

        gastoEntidad.setConcepto(gastoDTO.getConcepto());
        gastoEntidad.setMontoGasto(gastoDTO.getMontoGasto());
        gastoEntidad.setComprobante(gastoDTO.getComprobante());
        gastoEntidad.setMetodoPago(gastoDTO.getMetodoPago());

        return gastoEntidad;
    }

    public GastoDTO ConvertirADTO1(Gasto gasto) {
        GastoDTO gastoDTO = new GastoDTO();
        gastoDTO.setId(gasto.getId());
        gastoDTO.setFolio(gasto.getFolio());
        gastoDTO.setFechaGasto(gasto.getFechaGasto());
        gastoDTO.setCategoria(gasto.getCategoria());

        gastoDTO.setProveedor(adapter.ConvertirADTO(gasto.getProveedor()));

        gastoDTO.setConcepto(gasto.getConcepto());
        gastoDTO.setMontoGasto(gasto.getMontoGasto());
        gastoDTO.setComprobante(gasto.getComprobante());
        gastoDTO.setMetodoPago(gasto.getMetodoPago());

        return gastoDTO;
    }

}
