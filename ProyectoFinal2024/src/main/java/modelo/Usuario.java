package modelo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String dpi;
    private String direccion;
    private int roleID;
    public static Usuario usuarioAcceso = new Usuario();
    

    public Usuario(String nombre, String apellido, String email, String password, String telefono, String dpi, String Direccion, int roleID) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.telefono = telefono;
        this.dpi = dpi;
        this.direccion = direccion;
        this.roleID = roleID;

    }
    public void setUsuarioAcceso(Usuario usuario){
    usuarioAcceso = usuario;
    }
}
