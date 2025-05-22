/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Exception.PersistenciaException;
import entidades.Gasto;
import Interfaces.IGastoDAO;
import entidades.Proveedor;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Admin
 */
public class GastoDAO implements IGastoDAO {

    @Override
    public Gasto agregarGasto(Gasto gasto) throws PersistenceException {
        
        try {
            LocalDate fechaGasto = LocalDate.of(2025, 1, 1);
            Proveedor proveedor = new Proveedor("MrSteaks777", "141223");
            byte[] comprobante = null;           
            return new Gasto("asd123", fechaGasto, "Utencilios", proveedor, "compra de cuchillos", 750.0, comprobante, "Efectivo");
        } catch (Exception e) {
            throw new PersistenceException("Error al persistir gasto " + e.getMessage());
        }
    }

    @Override
    public void eliminarGasto(String folio) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gasto modificarGasto(Gasto gasto) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Gasto> consultarGastosFiltrados(Gasto gastoFiltro, LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gasto buscarPorFolio(String folio) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
