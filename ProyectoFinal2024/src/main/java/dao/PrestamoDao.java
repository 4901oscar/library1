/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import modelo.Prestamo;

/**
 *
 * @author Oscar Rivera
 */
public class PrestamoDao {

    private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_PRESTAMO = "SELECT * FROM prestamos";
    private final String INSERT_INTO_PRESTAMO = "INSERT INTO prestamos (usuario_id, libro_id, fecha_prestamo, fecha_devolucion_esperada) VALUES (?, ?, ?, ?)";
    private final String UPDATE_PRESTAMO = "UPDATE prestamos SET fecha_devolucion_real = ?, multa = ? WHERE id = ?";

    public List<Prestamo> readAll() {
        List<Prestamo> prestamos = new ArrayList<>();
        try {
            preparedStatement = Conexion.getConnection().prepareStatement(SELECT_FROM_PRESTAMO);
            preparedStatement.execute();
            preparedStatement.getResultSet();
            while (preparedStatement.getResultSet().next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(preparedStatement.getResultSet().getInt("id"));
                prestamo.setUsuarioID(preparedStatement.getResultSet().getInt("usuario_id"));
                prestamo.setIsbn(preparedStatement.getResultSet().getInt("libro_id"));
                prestamo.setFechaPrestamo(preparedStatement.getResultSet().getDate("fecha_prestamo"));
                prestamo.setFechaVencimiento(preparedStatement.getResultSet().getDate("fecha_devolucion_esperada"));
                prestamo.setFechaDevolucion(preparedStatement.getResultSet().getDate("fecha_devolucion_real"));
                prestamo.setMulta(preparedStatement.getResultSet().getDouble("multa"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
        }
        return prestamos;
    }

    public void save(Prestamo prestamo) {
        Date fechaPrestamo = new Date(System.currentTimeMillis());
        Date fechaVencimiento = new Date(System.currentTimeMillis() + 604800000);

        try {
            preparedStatement = Conexion.getConnection().prepareStatement(INSERT_INTO_PRESTAMO);
            preparedStatement.setInt(1, prestamo.getUsuarioID());
            preparedStatement.setInt(2, prestamo.getIsbn());
            preparedStatement.setDate(3, fechaPrestamo);
            preparedStatement.setDate(4, fechaVencimiento);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public boolean update(int prestamoID) {
        Date fechaDevolucion = new Date(System.currentTimeMillis());
        Prestamo prestamo = Prestamo.listaDePrestamos.stream()
                .filter(p -> p.getId() == prestamoID)
                .findFirst()
                .orElse(null);

        if (fechaDevolucion.compareTo(prestamo.getFechaVencimiento()) > 0) {
            long msDiff = fechaDevolucion.getTime() - prestamo.getFechaVencimiento().getTime();
            long daysLate = TimeUnit.MILLISECONDS.toDays(msDiff);

            if (daysLate > 0) {
                double multa = daysLate * 10.0;
                prestamo.setMulta(multa);
            }
        }

        try {

            preparedStatement = Conexion.getConnection().prepareStatement(UPDATE_PRESTAMO);
            preparedStatement.setDate(1, fechaDevolucion);
            preparedStatement.setDouble(2, prestamo.getMulta());
            preparedStatement.setInt(3, prestamoID);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

}
