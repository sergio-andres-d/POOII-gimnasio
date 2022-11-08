/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviciosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import modeloVO.ClaseVO;

/**
 *
 * @author estudiante
 */
public class ClaseDAO {

    public ArrayList<String> llenarIns(String e, String h, JButton bo) throws SQLException {
        String er, hr;
        ArrayList<String> listaIns = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement select = conexion.prepareStatement("SELECT * FROM instructor where especialidad=?,hora=?");
            select.setString(2, h);
            select.setString(1, e);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                listaIns.add(rs.getString("codigo"));
                bo.setEnabled(true);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return listaIns;
    }

    public void insertar(Connection conexion, ClaseVO clase) throws SQLException {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO clase VALUES(?,?,?,?)");
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
}
