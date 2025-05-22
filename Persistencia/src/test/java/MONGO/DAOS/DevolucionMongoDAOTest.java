/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MONGO.DAOS;

import Interfaces.IDevolucionDAO;
import entidades.Devolucion;
import entidades.Empleado;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sebastian Moreno
 */
public class DevolucionMongoDAOTest {
//
//    private IDevolucionDAO devolucionDAO;
//    private Devolucion devolucion;
//
//    @Before
//    public void setUp() throws Exception {
//        devolucionDAO = new DevolucionMongoDAO();
//
//        // Limpieza previa para evitar errores por folio repetido
//        Devolucion existente = devolucionDAO.buscarPorID("1747779367");
//        if (existente != null) {
//            System.out.println(existente);
//        }
//
//    }
////
////    /**
////     * Test of registrarDevolucion method, of class DevolucionMongoDAO.
////     */
////    @Test
////    public void testRegistrarDevolucion() throws Exception {
////        System.out.println("registrarDevolucion");
////        Devolucion devolucion = new Devolucion();
////        devolucion.setNombreCompleto("Hola");
////        devolucion.setCajeroDevolucion(new Empleado("Juanito", "Cajero"));
////        devolucion.setFechaHora(LocalDateTime.now());
////        DevolucionMongoDAO instance = new DevolucionMongoDAO();
////    
////        Devolucion result = instance.registrarDevolucion(devolucion);
////        assertNotNull(result);
////   
////        System.out.println("Se registro correctamente.");
////   
////    }
//
//    /**
//     * Test of buscarDevolucionPorFiltro method, of class DevolucionMongoDAO.
//     */
//    @Test
//    public void testBuscarDevolucionPorFiltro() {
//        System.out.println("buscarDevolucionPorFiltro - caso exitoso");
//
//        // Crear un filtro básico: por ejemplo, solo el nombre o código
//        Devolucion filtro = new Devolucion();
//        filtro.setId(1747901280); // Asegúrate que exista este código en la base de datos
//
//        // Definir un rango de fechas que abarque devoluciones registradas
//        LocalDateTime inicio = LocalDateTime.of(2023, 1, 1, 0, 0);
//        LocalDateTime fin = LocalDateTime.of(2025, 12, 31, 23, 59);
//
//        DevolucionMongoDAO instance = new DevolucionMongoDAO();
//
//        // Ejecutar búsqueda
//        List<Devolucion> result = instance.buscarDevolucionPorFiltro(filtro, inicio, fin);
//
//        // Verificar que el resultado no es nulo y tiene al menos un resultado
//        assertNotNull(result.getFirst().toString(), "La lista de devoluciones no debe ser nula");
//
//        // Imprimir el primer resultado para verificación visual
//        System.out.println("Primera devolución encontrada: " + result.getFirst().toString());
//    }
//
//
//    /**
//     * Test of buscarDevoluciones method, of class DevolucionMongoDAO.
//     */
//    @Test
//    public void testBuscarDevoluciones() {
//        System.out.println("buscarDevoluciones caso exito.");
//        DevolucionMongoDAO instance = new DevolucionMongoDAO();
//        List<Devolucion> expResult = null;
//        List<Devolucion> result = instance.buscarDevoluciones();
//
//        List<Devolucion> d = instance.buscarDevoluciones();
//        assertNotNull(d.getFirst().toString(), "No debe ser nulo.");
//
//    }
//
//    /**
//     * Test of buscarPorID method, of class DevolucionMongoDAO.
//     */
//    @Test
//    public void testBuscarPorID() throws Exception {
//        System.out.println("buscarPorID");
//
//        // Suponiendo que ya existe una Devolucion en la colección con este código
//        String id = "1747901280";
//
//        // Instancia del DAO
//        // Ejecutamos el método
//        Devolucion result = devolucionDAO.buscarPorID(id);
//
//        // Verificamos que el resultado no sea nulo
//        assertNotNull(result.getNombreCompleto(), "No debe ser nulo");
//
//        // Puedes imprimir o comparar algún campo específico si lo deseas
//        System.out.println("Nombre completo encontrado: " + result.getNombreCompleto());
//    }
//
//    /**
//     * Test of buscarPorID method, of class DevolucionMongoDAO.
//     */
//    @Test
//    public void testBuscarPorIDInvalido() throws Exception {
//        System.out.println("buscarPorID Invalido");
//
//        // Suponiendo que ya existe una Devolucion en la colección con este código
//        String id = "1747901282";
//
//        // Instancia del DAO
//        // Ejecutamos el método
//        Devolucion result = devolucionDAO.buscarPorID(id);
//
//        // Verificamos que el resultado no sea nulo
//        assertEquals(result, null);
//
//        System.out.println("La devolucion no es encontrada.");
//
//    }

}
