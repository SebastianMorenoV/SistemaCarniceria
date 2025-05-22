/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Adapters.AdaptadorGasto;
import DTOs.CrearGastoDTO;
import DTOs.GastoDTO;
import Exception.NegocioException;
import Exception.PersistenciaException;
import entidades.Gasto;
import IAdapters.IAdapterGasto;
import Interfaces.IGastoBO;
import Interfaces.IGastoDAO;
import fabrica.ICreadorDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class GastoBO implements IGastoBO {

    private final IAdapterGasto adaptadorGasto = new AdaptadorGasto();
    private final IGastoDAO gastoDAO;

    public GastoBO(ICreadorDAO fabrica) {
        this.gastoDAO = fabrica.crearGastoDAO();
    }

    @Override
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws NegocioException {

        Gasto gasto = adaptadorGasto.ConvertirAEntidad(gastoDTO);

        try {
            gasto = gastoDAO.agregarGasto(gasto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al agregar gasto: " + ex.getLocalizedMessage());
        }

        GastoDTO gastoMapeado = adaptadorGasto.ConvertirADTO(gasto);
        return gastoMapeado;
    }

    @Override
    public void eliminarGasto(String folio) throws NegocioException {

        try {
            gastoDAO.eliminarGasto(folio);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar gasto: " + ex.getLocalizedMessage());
        }
    }

    @Override
    public GastoDTO modificarGasto(GastoDTO gastoDTO) throws NegocioException {
        Gasto gasto = adaptadorGasto.ConvertirAEntidad(gastoDTO);

        try {
            gasto = gastoDAO.modificarGasto(gasto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al modifcar gasto: " + ex.getLocalizedMessage());
        }

        GastoDTO gastoMapeado = adaptadorGasto.ConvertirADTO(gasto);
        return gastoMapeado;
    }

    @Override
    public List<GastoDTO> consultarGastos() throws NegocioException {
        List<Gasto> gastos = null;
        List<GastoDTO> gastosDTO = new ArrayList<>();

        Gasto gastoVacio = new Gasto();
        try {
            gastos = gastoDAO.consultarGastosFiltrados(gastoVacio, null, null);
            for (Gasto gasto : gastos) {
                GastoDTO gastoDTO = adaptadorGasto.ConvertirADTO(gasto);
                gastosDTO.add(gastoDTO);
            }
        } catch (PersistenciaException ex) {
            return new ArrayList<>(); //lista vacia para evitar NullPointerException
        }

        return gastosDTO;
    }

    @Override
    public List<GastoDTO> consultarGastosFiltrados(CrearGastoDTO gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws NegocioException {
        List<Gasto> gastos = new ArrayList<>();
        List<GastoDTO> gastosDTO = new ArrayList<>();

        try {
            Gasto filtro = adaptadorGasto.ConvertirAEntidad(gastoFiltro);
            gastos = gastoDAO.consultarGastosFiltrados(filtro, fechaInicio, fechaFin);
            for (Gasto gasto : gastos) {
                GastoDTO gastoDTO = adaptadorGasto.ConvertirADTO(gasto);
                gastosDTO.add(gastoDTO);
            }
        } catch (PersistenciaException ex) {
            return new ArrayList<>();//lista vacia para evitar NullPointerException
        }

        return gastosDTO;
    }

    @Override
    public GastoDTO buscarPorFolio(String folio) throws NegocioException {
        try {
            Gasto gasto = gastoDAO.buscarPorFolio(folio);

            if (gasto == null) {
                throw new NegocioException("No se encontró gasto con folio: " + folio);
            }

            return adaptadorGasto.ConvertirADTO1(gasto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar gasto por folio: " + ex.getLocalizedMessage());
        }
    }

}
