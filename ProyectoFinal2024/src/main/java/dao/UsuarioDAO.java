/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.Conexion;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Oscar Rivera
 */
public class UsuarioDAO {
    
    private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_USUARIOS = "SELECT * FROM usuarios";
    private final String INSERT_INTO_USUARIOS = "INSERT INTO usuarios (nombre,apellido,email,password,telefono,dpi,direccion,rol_id) VALUES(?,?,?,?,?,?,?,?)";
    private final String UPDATE_USUARIO = "UPDATE usuarios SET cantidad_disponible = cantidad_disponible - 1 WHERE isbn = ?";
    private final String UPDATE_LIBRO_DEVOLUCION = "UPDATE libros SET cantidad_disponible = cantidad_disponible + 1 WHERE isbn = ?";
    private final String DELETE_FROM_LIBROS = "DELETE FROM libros WHERE isbn = ?";

    public Usuario<Usuario> listarUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(SELECT_FROM_USUARIOS);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                libro.setIsbn(resultSet.getInt("isbn"));
                libro.setTitulo(resultSet.getString("titulo"));
                libro.setAutor(resultSet.getString("autor"));
                libro.setAnioPublicacion(resultSet.getInt("anio_publicacion"));
                libro.setEditorial(resultSet.getString("editorial"));
                libro.setCantidadDisponible(resultSet.getInt("cantidad_disponible"));
                usuario.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return libros;
        }
        return libros;
    }

    public boolean guardarLibro(Libro libro) {
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(INSERT_INTO_LIBROS);
            preparedStatement.setInt(1, libro.getIsbn());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setString(4, libro.getEditorial());
            preparedStatement.setInt(5, libro.getAnioPublicacion());
            preparedStatement.setInt(6, libro.getCantidadDisponible());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarLibro(int isbn, String tipoSolicitud) {
        try {
            switch (tipoSolicitud) {
                case "prestamo":
                    preparedStatement = Conexion.getConnection().prepareStatement(UPDATE_LIBRO_PRESTAMO);
                    break;
                case "devolucion":
                    preparedStatement = Conexion.getConnection().prepareStatement(UPDATE_LIBRO_DEVOLUCION);
                    break;
                default:
                    break;
            }
            preparedStatement.setInt(1, isbn);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
}
