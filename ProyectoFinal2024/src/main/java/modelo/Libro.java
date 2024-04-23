/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private int cantidadDisponible;  
}
