/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Interface.CRUD;
import dao.LibroDAO;
import java.util.List;
import java.util.Optional;
import modelo.Libro;

/**
 *
 * @author Oscar Rivera
 */
public class LibroController implements CRUD<Libro> {

    private LibroDAO repositorioLibro = new LibroDAO();

    public boolean prestamo(int isbn) {
        return repositorioLibro.actualizarLibro(isbn, "prestamo");
    }

    public boolean devolucion(int isbn) {
        return repositorioLibro.actualizarLibro(isbn, "devolucion");
    }

    @Override
    public void create(Libro obj) {
        repositorioLibro.guardarLibro(obj);
    }

    @Override
    public boolean update(Libro obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int id) {
        return repositorioLibro.eliminarLibro(id);
    }

    @Override
    public List<Libro> list() {
        return repositorioLibro.listarLibros();
    }

    public Libro buscar(int Isbn) {
        return Libro.listaDeLibros.stream().filter(L -> L.getIsbn() == Isbn)
                .findFirst().orElse(null);
    }

    public void agregarExistencia(int Isbn, int cantidad) {
        repositorioLibro.agregarExistencia(Isbn, cantidad);
    }

    public boolean cantidadMayorCero(int isbn) {
        Libro libro = buscar(isbn);
        return libro.getCantidadDisponible()>0;
    }

}
