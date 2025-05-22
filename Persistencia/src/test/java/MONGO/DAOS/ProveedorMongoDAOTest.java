package MONGO.DAOS;

import Exception.PersistenciaException;
import Interfaces.IProveedorDAO;
import entidades.Proveedor;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Admin
 */
public class ProveedorMongoDAOTest { //comentada por que se persisten las cosas en cada clean n build
//
//    private IProveedorDAO dao;
//
//    @Before
//    public void setUp() {
//        dao = new ProveedorMongoDAO();
//    }
//
//    
//    @Test
//    public void testAgregarProveedorCasoExito() throws Exception {
//        Proveedor proveedor = new Proveedor();
//        proveedor.setNombre("ProveedorTest");
//        proveedor.setNumero("6441090909");
//
//        Proveedor resultado = dao.agregarProveedor(proveedor);
//
//        assertNotNull("El proveedor no debe ser null", resultado);
//        assertNotNull("El ID del proveedor debe estar asignado", resultado.getId());
//        assertEquals("El nombre debe coincidir", "ProveedorTest", resultado.getNombre());
//    }
//
//    @Test(expected = PersistenciaException.class)
//    public void testAgregarProveedorCasoError() throws Exception {
//        // Forzamos un error con un proveedor null
//        dao.agregarProveedor(null);
//    }
//
//    @Test
//    public void testConsultarProveedoresCasoExito() throws Exception {
//        // Insertar un proveedor para asegurar que haya al menos uno
//        Proveedor proveedor = new Proveedor();
//        proveedor.setNombre("ProveedorConsulta");
//        proveedor.setNumero("6442136294");
//        dao.agregarProveedor(proveedor);
//
//        List<Proveedor> proveedores = dao.consultarProveedores();
//
//        assertNotNull("La lista no debe ser null", proveedores);
//        assertTrue("Debe contener al menos un proveedor", proveedores.size() > 0);
//    }
//
//    @Test
//    public void testBuscarPorNombreCasoExito() throws Exception {
//        String nombre = "ProveedorBusqueda";
//        Proveedor proveedor = new Proveedor();
//        proveedor.setNombre(nombre);
//        dao.agregarProveedor(proveedor);
//
//        Proveedor encontrado = dao.buscarPorNombre(nombre);
//
//        assertNotNull("Debe encontrar el proveedor", encontrado);
//        assertEquals("El nombre debe coincidir", nombre, encontrado.getNombre());
//    }
//
//    @Test
//    public void testBuscarPorNombreCasoNoEncontrado() throws Exception {
//        Proveedor resultado = dao.buscarPorNombre("NombreInexistente12345");
//        assertNull("No debe encontrar un proveedor", resultado);
//    }
}
