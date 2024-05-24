/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prestamo {
    public static List<Prestamo> listaDePrestamos = new ArrayList<>();
    private int id;
    private int isbn;
    private int usuarioID;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Date fechaVencimiento;
    private Double multa;
    
    public Prestamo(){
        this.multa = 0.0;
    }
    
}
