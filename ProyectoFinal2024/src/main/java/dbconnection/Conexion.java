/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Oscar Rivera
 */
public class Conexion {
    private static final/*no modificable, constante*/ String DATABASE = "proyectoFinalProgra";
    private static final String NOMBRE_SERVIDOR ="progra-1-2024-oscar.postgres.database.azure.com";
    private static final String PUERTO = "5432";
    private static final String URL_CONEXION ="jdbc:postgresql://"+NOMBRE_SERVIDOR+":"+PUERTO+"/"+DATABASE;
    private static final String USUARIO ="Enrique";
    private static final String USUARIO_CONTRASENA = "Oscrivsay1*";
    
     public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL_CONEXION,USUARIO,USUARIO_CONTRASENA);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return connection;
    }
}
