/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Conexion {

    private static Conexion instancia;
    private Connection conexion;
    private final String url = "jdbc:mysql://localhost:3306/carniceria";
    private final String usuario = "root";
    private final String contrasenia = "itson";

    private Conexion() throws SQLException {
        try {
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (SQLException ex) {
            throw new SQLException("Error al conectar a la base de datos", ex);
        }
    }

    public static Conexion obtenerInstancia() throws SQLException {
        if (instancia == null || instancia.getConexion().isClosed()) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
