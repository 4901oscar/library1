package dao;

import dbconnection.Conexion;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;

public class LibroDAO {

    private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_LIBROS = "SELECT * FROM libros";
    private final String INSERT_INTO_LIBROS = "INSERT INTO libros (isbn, titulo, autor, editorial, anio_publicacion, cantidad_disponible) VALUES(?,?,?,?,?,?)";
    private final String UPDATE_LIBRO_PRESTAMO = "UPDATE libros SET cantidad_disponible = cantidad_disponible - 1 WHERE isbn = ?";
    private final String UPDATE_LIBRO_DEVOLUCION = "UPDATE libros SET cantidad_disponible = cantidad_disponible + 1 WHERE isbn = ?";
    private final String DELETE_FROM_LIBROS = "DELETE FROM libros WHERE isbn = ?";

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(SELECT_FROM_LIBROS);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Libro libro = new Libro();
                libro.setIsbn(resultSet.getInt("isbn"));
                libro.setTitulo(resultSet.getString("titulo"));
                libro.setAutor(resultSet.getString("autor"));
                libro.setAnioPublicacion(resultSet.getInt("anio_publicacion"));
                libro.setEditorial(resultSet.getString("editorial"));
                libro.setCantidadDisponible(resultSet.getInt("cantidad_disponible"));
                libros.add(libro);
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
        return true;
    }

    public boolean eliminarLibro(int isbn) {
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(DELETE_FROM_LIBROS);
            preparedStatement.setInt(1, isbn);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//end of the class
}
