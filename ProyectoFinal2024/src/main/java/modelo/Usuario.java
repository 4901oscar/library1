
package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String dpi;
    private String direccion;
    private int roleID;
}
