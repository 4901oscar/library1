/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dbconnection.Conexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;

/**
 *
 * @author Oscar Rivera
 */
public class RolDao {
     private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_ROL = "SELECT * FROM roles";

    public List<Rol> readAll() {
        List<Rol> listaDeRoles = new ArrayList<>();
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_FROM_ROL);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Rol rol = new Rol();
                rol.setId(resultSet.getInt("id"));
                rol.setNombre(resultSet.getString("nombre"));
                listaDeRoles.add(rol);
            }
        } catch (SQLException e) {
        }
        return listaDeRoles;
    }
}
