/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prestamo {
    private int id;
    private String isbn;
    private int usuarioID;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Date fechaDevolucionEstimada;
    
}
