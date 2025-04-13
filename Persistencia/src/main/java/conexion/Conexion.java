
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase representa un Singleton para crear una conexion y que todos tengan la instancia a un mismo objeto.
 * @author Admin
 */
public class Conexion {

    private static Conexion instancia;
    private static EntityManagerFactory emf;
    private static final String UNIDAD_PERSISTENCIA = "carniceriaPU";

    private Conexion() {
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }

    public static Conexion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public EntityManager crearConexion() {
        return emf.createEntityManager();
    }

    public void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
