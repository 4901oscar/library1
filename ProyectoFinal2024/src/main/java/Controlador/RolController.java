/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import dao.RolDao;
import modelo.Rol;

/**
 *
 * @author Oscar Rivera
 */
public class RolController {
        private RolDao roleDAO = new RolDao();

   public void ObtenerRoles(){
       Rol.listaDeRoles = roleDAO.readAll();
   }
}
