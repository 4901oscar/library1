/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Interface.CRUD;
import modelo.Usuario;

/**
 *
 * @author Oscar Rivera
 */
public class InitInitialQueries {
   private static final CRUD repositorio = new UsuarioController();
    
    public static void init(){
    Usuario.listaDeUsarios.addAll(repositorio.list());
    }
    
    public static void clearAllList(){
    Usuario.listaDeUsarios.clear();
    }
}
