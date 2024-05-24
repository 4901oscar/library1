/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Date;
import java.util.List;


public class PrestamoController implements CRUDAbstracto<Prestamo, Integer> {
     private PrestamoDAO prestamoDAO = new PrestamoDAO();
    @Override
    public List<Prestamo> executeReadAll() {
        return prestamoDAO.readAll();
    }

    @Override
    public Prestamo executeCreate(Prestamo entidad) {
        prestamoDAO.save(entidad);
        return entidad;
    }

    @Override
    public Prestamo executeRead(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean executeUpdate(Integer integer) {
       throw new UnsupportedOperationException();
    }

    @Override
    public void executeDelete(Integer integer) {
        throw new UnsupportedOperationException();
    }

    public boolean verificarPrestamosTardios(int isbn, int usuarioID) {

        return Prestamo.listaDePrestamos.stream()
                .anyMatch(prestamo -> prestamo.getUsuarioID() == usuarioID && prestamo.getLibroISBN() == isbn
                        && prestamo.getFechaVencimiento().before(new Date(System.currentTimeMillis()))
                        && prestamo.getFechaDevolucion()==null);
    }

    public void actualizarDevolucion(int id) {
        prestamoDAO.actualizarDevolucion(id);
    }
}
