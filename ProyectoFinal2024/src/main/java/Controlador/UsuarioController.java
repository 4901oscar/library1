/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Interface.CRUD;
import dao.UsuarioDAO;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Oscar Rivera
 */
public class UsuarioController implements CRUD<Usuario>{

  private UsuarioDAO repositorio = new UsuarioDAO();

 /*
    public boolean registrarUsuario(Usuario usuario) {

        Usuario existeUsuario = Usuario.listaDeUsuarios.stream()
                .filter(u -> u.getEmail().equals(usuario.getEmail()))
                .findFirst()
                .orElse(null);

        if (existeUsuario != null) {
            return false;
        }

        executeCreate(usuario);
        return true;
    }

    public Usuario login(String email, String password) {
        return Usuario.listaDeUsuarios.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public boolean actualizarUsuario(Usuario usuario) {

        Usuario existeUsuario = Usuario.listaDeUsuarios.stream()
                .filter(u -> u.getEmail().equals(usuario.getEmail()))
                .findFirst()
                .orElse(null);

        if (existeUsuario != null) {
            return false;
        }
        repository.update(usuario);
        return true;
    }
    */

    @Override
    public void create(Usuario obj) {
        repositorio.save(obj); 
    }

    @Override
    public boolean update(Usuario obj) {
       return repositorio.update(obj) ;
        
    }

    @Override
    public boolean delete(int id) {
        return repositorio.delete(id);
    }

    @Override
    public List<Usuario> list() {
        return repositorio.readAll();
    }
    
    
    public Usuario logIn(String email, String password){
    return Usuario.listaDeUsarios.stream()
            .filter(usuario->usuario.getEmail().equalsIgnoreCase(email)&& usuario.getPassword().equals(password))
            .findFirst()
            .orElse(null);
    }
}
