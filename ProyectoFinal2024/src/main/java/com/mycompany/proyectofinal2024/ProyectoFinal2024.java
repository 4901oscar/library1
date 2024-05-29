/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal2024;

import Controlador.InitInitialQueries;
import forms.LoginAcces;


/**
 *
 * @author Oscar Rivera
 */
public class ProyectoFinal2024 {

    public static void main(String[] args) {
      
      InitInitialQueries.init();
      LoginAcces loginForm = new LoginAcces();
        loginForm.setVisible(true);
        
    }
}
