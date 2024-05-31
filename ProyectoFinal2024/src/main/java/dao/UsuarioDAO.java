/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oscar Rivera
 */
public class UsuarioDAO {

    private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_USUARIOS = "SELECT * FROM usuarios";
   // private final String SELECT_USUARIOS_ACCESO = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
    private final String INSERT_USUARIOS = "INSERT INTO usuarios (nombre, apellido,email,password,telefono,dpi,direccion,rol_id) VALUES(?,?,?,?,?,?,?,?)";
    private final String UPDATE_USUARIOS = "UPDATE usuarios SET nombre = ?, apellido = ?,email = ?, password = ?, telefono = ?, dpi = ?, direccion = ?, rol_id = ? WHERE   id = ?";
    private final String DELETE_USER = "DELETE FROM usuarios WHERE id = ?";

   public List<Usuario> readAll() {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(SELECT_FROM_USUARIOS);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setDpi(resultSet.getString("dpi"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setRoleID(resultSet.getInt("rol_id"));
                listaDeUsuarios.add(usuario);
            }
        } catch (SQLException e) {
        }
        return listaDeUsuarios;
    }

    public void save(Usuario usuario) {
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(INSERT_USUARIOS);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getPassword());
            preparedStatement.setString(5, usuario.getTelefono());
            preparedStatement.setString(6, usuario.getDpi());
            preparedStatement.setString(7, usuario.getDireccion());
            preparedStatement.setInt(8, usuario.getRoleID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public boolean delete(int id) {
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        }return true;
    }

    public boolean update(Usuario usuario) {
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(UPDATE_USUARIOS);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getTelefono());
            preparedStatement.setString(4, usuario.getPassword());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setInt(6, usuario.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
    
    
    
}





