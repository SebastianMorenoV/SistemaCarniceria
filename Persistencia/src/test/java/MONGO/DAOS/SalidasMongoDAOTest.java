package MONGO.DAOS;

import entidades.Producto;
import entidades.Salida;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janot
 */
public class SalidasMongoDAOTest {
    
    public SalidasMongoDAOTest() {
    }

    /**
     * Test of agregarNuevaSalida method, of class SalidasMongoDAO.
     */
    @Test
    public void testAgregarNuevaSalida() throws Exception {
        System.out.println("agregarNuevaSalida");
        Salida salida = new Salida();
        SalidasMongoDAO instance = new SalidasMongoDAO();
        Salida expResult = salida;
        Salida result = instance.agregarNuevaSalida(salida);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarSalidasBuscador method, of class SalidasMongoDAO.
     */
    @Test
    public void testConsultarSalidasBuscador() throws Exception {
        System.out.println("consultarSalidasBuscador");
        String nombre = "Coca";
        Date fechaDesde = null;
        Date fechaHasta = null;
        SalidasMongoDAO instance = new SalidasMongoDAO();
        Object expResult = ArrayList.class;
        Object result = instance.consultarSalidasBuscador(nombre, fechaDesde, fechaHasta).getClass();
        assertEquals(expResult, result);
    }
    
}
