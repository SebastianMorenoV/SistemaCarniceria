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
    public List<Gasto> consultarGastos() throws PersistenciaException {
        List<Gasto> listaGastos = new ArrayList<>();

        Proveedor proveedor1 = new Proveedor("Super Carnes La Norteña", "141223");
        Proveedor proveedor2 = new Proveedor("Abarrotes El Güero",  "141223");
        Proveedor proveedor3 = new Proveedor("MrSteaks777",  "141223");

        LocalDate fecha1 = LocalDate.of(2025, 5, 10);
        byte[] comprobante1 = "comprobante1.pdf".getBytes();
        Gasto gasto1 = new Gasto("GC001", fecha1, "Alimentos", proveedor1, "Compra de carne para resurtir", 1250.50, comprobante1, "Tarjeta");
        listaGastos.add(gasto1);

        LocalDate fecha2 = LocalDate.of(2025, 5, 12);
        byte[] comprobante2 = "ticket_abarrotes.jpg".getBytes();
        Gasto gasto2 = new Gasto("GC002", fecha2, "Insumos", proveedor2, "Compra de café, azúcar y leche", 325.80, comprobante2, "Efectivo");
        listaGastos.add(gasto2);

        LocalDate fecha3 = LocalDate.of(2025, 5, 13);
        byte[] comprobante3 = null; // Simular un gasto sin comprobante
        Gasto gasto3 = new Gasto("GC003", fecha3, "Mantenimiento", proveedor3, "Compra de herramientas menores", 89.99, comprobante3, "Tarjeta");
        listaGastos.add(gasto3);

        LocalDate fecha4 = LocalDate.of(2025, 5, 14);
        byte[] comprobante4 = "factura_agua.pdf".getBytes();
        Gasto gasto4 = new Gasto("GC004", fecha4, "Servicios", proveedor1, "Pago de recibo de agua", 560.25, comprobante4, "Efectivo");
        listaGastos.add(gasto4);

        return listaGastos;
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
