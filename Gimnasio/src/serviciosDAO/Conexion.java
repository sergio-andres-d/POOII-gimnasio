/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviciosDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author estudiante
 */
public class Conexion {

    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("con.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/gimnasio", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
            }
        }
        return conexion;
    }

    public static void close() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
            }
        }
    }
}
