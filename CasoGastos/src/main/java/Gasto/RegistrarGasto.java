/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gasto;

import Adapters.AdaptadorGasto;
import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import Exception.GastoException;
import Exception.NegocioException;
import IAdapters.IAdapterGasto;
import Interfaces.IGastoBO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RegistrarGasto implements IRegistrarGasto {

    private final IGastoBO gastoBO = manejadoresBO.ManejadorObjetosNegocio.crearGastoBO();
    private final IAdapterGasto adaptadorGasto = new AdaptadorGasto(); // Asegúrate de que este adaptador esté correctamente inicializado (quizás con el adaptador de proveedor)
    CrearGastoDTO gastoPasable;

    @Override
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws GastoException {
        try {
            // Aquí podrías agregar validaciones de negocio antes de llamar al BO
//        if (gastoDTO == null) {
//            throw new NegocioException("Los datos del gasto no pueden ser nulos.");
//        }
//        // Ejemplo de validación de campos requeridos
//        if (gastoDTO.getFolio() == null || gastoDTO.getFolio().isEmpty()) {
//            throw new NegocioException("El folio del gasto es obligatorio.");
//        }
//        if (gastoDTO.getMontoGasto() == null || gastoDTO.getMontoGasto() <= 0) {
//            throw new NegocioException("El monto del gasto debe ser mayor que cero.");
//        }
// ... otras validaciones

// Llama al Business Object para realizar la lógica de negocio y persistencia
            return gastoBO.agregarGasto(gastoDTO);
        } catch (NegocioException ex) {
            throw new GastoException("Error al agregar gasto" + ex.getLocalizedMessage());
        }
    }

    @Override
    public void eliminarGasto(String folio) throws GastoException {
        try {
            gastoBO.eliminarGasto(folio);
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    @Override
    public GastoDTO modificarGasto(GastoDTO gastoDTO) throws GastoException {
        try {
            return gastoBO.modificarGasto(gastoDTO);
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    @Override
    public List<GastoDTO> consultarGastos() throws GastoException {
        try {
            return gastoBO.consultarGastos();
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

    @Override
    public List<GastoDTO> consultarGastosFiltrados(CrearGastoDTO gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws GastoException {
        try {
            return gastoBO.consultarGastosFiltrados(gastoFiltro, fechaInicio, fechaFin);
        } catch (NegocioException e) {
            throw new GastoException("Error al consultar gastos filtrados" + e.getLocalizedMessage());
        }
    }

    @Override
    public void vaidarGastoDuplicado() throws GastoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public CrearGastoDTO getGastoPasable() {
        return gastoPasable;
    }

    public void setGastoPasable(CrearGastoDTO gastoPasable) {
        this.gastoPasable = gastoPasable;
    }

    @Override
    public GastoDTO buscarPorFolio(String folio) throws GastoException {
        try {
            return gastoBO.buscarPorFolio(folio);
        } catch (NegocioException ex) {
            throw new GastoException("Error al consultar gastos" + ex.getLocalizedMessage());
        }
    }

}
