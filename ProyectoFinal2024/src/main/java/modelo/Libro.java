/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Libro {
    public static List<Libro> listaDeLibros = new ArrayList<>();
    private int isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private int cantidadDisponible;  
}
