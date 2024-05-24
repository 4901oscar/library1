package modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    public static List<Usuario> listaDeUsarios = new ArrayList<>();
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String dpi;
    private String direccion;
    private int roleID; 
}
