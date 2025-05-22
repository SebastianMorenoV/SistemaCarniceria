
package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IGastoDAO;
import entidades.Gasto;
import entidades.Proveedor;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GastoMongoDAOTest { //comentada por que se persisten las cosas en cada clean n build
//
//    private IGastoDAO dao;
//    private Gasto gastoPrueba;
//
//    @Before
//    public void setUp() throws Exception {
//        dao = new GastoMongoDAO();
//
//        // Limpieza previa para evitar errores por folio repetido
//        Gasto existente = dao.buscarPorFolio("B701");
//        if (existente != null) {
//            dao.eliminarGasto("B701");
//        }
//
//        Proveedor proveedor = new Proveedor();
//        proveedor.setNombre("Office Depot");
//        proveedor.setNumero("6441234567");
//
//        gastoPrueba = new Gasto();
//        gastoPrueba.setFolio("B701");
//        gastoPrueba.setFechaGasto(LocalDate.now());
//        gastoPrueba.setCategoria("Insumos");
//        gastoPrueba.setProveedor(proveedor);
//        gastoPrueba.setConcepto("Compra de pierna de cerdo fresca");
//        gastoPrueba.setMontoGasto(250.00);
//        gastoPrueba.setComprobante(null); // puede no tener comprobante
//        gastoPrueba.setMetodoPago("Efectivo");
//    }
//
//    @Test
//    public void testAgregarGastoExito() throws Exception {
//        Gasto resultado = dao.agregarGasto(gastoPrueba);
//        System.out.println("resultado = " + resultado);
//        if (resultado != null) {
//            System.out.println("Id: " + resultado.getId());
//            System.out.println("Folio: " + resultado.getFolio());
//        }
//        assertNotNull(resultado);
//        assertNotNull(resultado.getFolio());
//        assertEquals("B701", resultado.getFolio());
//    }
//
//    @Test(expected = PersistenciaException.class)
//    public void testAgregarGastoErrorNulo() throws Exception {
//        dao.agregarGasto(null);
//    }
//
//    @Test
//    public void testEliminarGastoExito() throws Exception {
//        Gasto prueba = new Gasto();
//        Proveedor proveedor = new Proveedor();
//        proveedor.setNombre("PruebaEliminar");
//        proveedor.setNumero("1234567890");
//        prueba = new Gasto();
//        prueba.setFolio("A303");
//        prueba.setFechaGasto(LocalDate.now());
//        prueba.setCategoria("Insumos");
//        prueba.setProveedor(proveedor);
//        prueba.setConcepto("Compra de pierna de cerdo fresca");
//        prueba.setMontoGasto(250.00);
//        prueba.setComprobante(null); // puede no tener comprobante
//        prueba.setMetodoPago("Efectivo");
//        dao.agregarGasto(prueba);
//        dao.eliminarGasto(prueba.getFolio());
//
//        Gasto eliminado = dao.buscarPorFolio(prueba.getFolio());
//        assertNull(eliminado);
//    }
//
//    @Test(expected = PersistenciaException.class)
//    public void testEliminarGastoErrorFolioVacio() throws Exception {
//        dao.eliminarGasto(""); //folio vacio porq no existe vaya
//    }
//
//    @Test
//    public void testModificarGastoExito() throws Exception {
//        Gasto original = dao.agregarGasto(gastoPrueba);
//        original.setConcepto("Compra de pollo muy bueno");
//
//        Gasto modificado = dao.modificarGasto(original);
//        assertEquals("Compra de pollo muy bueno", modificado.getConcepto());
//    }
//
//    @Test(expected = PersistenciaException.class)
//    public void testModificarGastoErrorNull() throws Exception {
//        dao.modificarGasto(null);
//    }
//
//    @Test
//    public void testConsultarGastosFiltradosExito() throws Exception {
//        dao.agregarGasto(gastoPrueba);
//
//        Gasto gastoFiltro = new Gasto();
//        List<Gasto> resultado = dao.consultarGastosFiltrados(gastoFiltro, null, null);
//
//        for (Gasto gasto : resultado) {
//            System.out.println("Gasto encontrado: " + gasto);
//        }
//        assertFalse(resultado.isEmpty());
//    }
//
//    @Test
//    public void testBuscarPorFolioExito() throws Exception {
//        dao.agregarGasto(gastoPrueba);
//        Gasto encontrado = dao.buscarPorFolio("B701");
//        System.out.println("Gasto encontrado: " + encontrado);
//        assertNotNull(encontrado);
//        assertEquals("B701", encontrado.getFolio());
//    }
//
//    @Test
//    public void testBuscarPorFolioErrorNoExiste() throws Exception {
//        Gasto encontrado = dao.buscarPorFolio("NOEXISTE");
//        assertNull(encontrado);
//    }
}
