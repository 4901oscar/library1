/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Interface.CRUD;
import dao.PrestamoDao;
import java.sql.Date;
import java.util.List;
import modelo.Prestamo;


public class PrestamoController implements CRUD<Prestamo> {
     private PrestamoDao prestamoDAO = new PrestamoDao();

    public boolean verificarPrestamosTardios(int isbn, int usuarioID) {

        return Prestamo.listaDePrestamos.stream()
                .anyMatch(prestamo -> prestamo.getUsuarioID() == usuarioID && prestamo.getIsbn() == isbn
                        && prestamo.getFechaVencimiento().before(new Date(System.currentTimeMillis()))
                        && prestamo.getFechaDevolucion()==null);
    }

    public void actualizarDevolucion(int id) {
        prestamoDAO.update(id);
    }

    @Override
    public void create(Prestamo obj) {
        prestamoDAO.save(obj);
    }

    @Override
    public boolean update(Prestamo obj) {
        return prestamoDAO.update(obj.getId()) ;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Prestamo> list() {
        return prestamoDAO.readAll();
    }
}
