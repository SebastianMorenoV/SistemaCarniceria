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
    public GastoDTO agregarGasto(CrearGastoDTO gastoDTO) throws NegocioException{

        Gasto gasto = adaptadorGasto.ConvertirAEntidad(gastoDTO);

        try {
            gasto = gastoDAO.agregarGasto(gasto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        GastoDTO gastoMapeado = adaptadorGasto.ConvertirADTO(gasto);
        return gastoMapeado;
    }

    @Override
    public void eliminarGasto(String folio) throws NegocioException{

        try {
            gastoDAO.eliminarGasto(folio);
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public GastoDTO modificarGasto(CrearGastoDTO gastoDTO) throws NegocioException{
        Gasto gasto = adaptadorGasto.ConvertirAEntidad(gastoDTO);

        try {
            gasto = gastoDAO.modificarGasto(gasto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        GastoDTO gastoMapeado = adaptadorGasto.ConvertirADTO(gasto);
        return gastoMapeado;
    }

    @Override
    public List<GastoDTO> consultarGastos() throws NegocioException{
        List<Gasto> gastos = null;
        List<GastoDTO> gastosDTO = new ArrayList<>();

        try {
            gastos = gastoDAO.consultarGastos();
            for (Gasto gasto : gastos) {
                GastoDTO gastoDTO = adaptadorGasto.ConvertirADTO(gasto);
                gastosDTO.add(gastoDTO);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(GastoBO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>(); // Retornar una lista vacia para evitar NullPointerException
        }

        return gastosDTO;
    }

}
