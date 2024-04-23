/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Interface.CRUD;
import dao.LibroDAO;
import java.util.List;
import modelo.Libro;

/**
 *
 * @author Oscar Rivera
 */
public class LibroController implements CRUD<Libro> {

    private LibroDAO repositorioLibro = new LibroDAO();

    @Override
    public boolean create(Libro obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Libro obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Libro> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean prestamo(int isbn) {
        return repositorioLibro.actualizarLibro(isbn, "prestamo");
    }

    public boolean devolucion(int isbn) {
        return repositorioLibro.actualizarLibro(isbn, "devolucion");
    }

}
