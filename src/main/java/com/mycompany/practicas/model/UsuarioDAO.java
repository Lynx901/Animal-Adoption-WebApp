
package com.mycompany.practicas.model;

import com.mycompany.practicas.Usuario;
import java.util.List;


/** Generic Interfaz for Usuario DAOs implementations*/
public interface UsuarioDAO {
    
    List<Usuario> listar();
    boolean nuevoUsuario(Usuario u);
    Usuario encontrarEmail(String email);
    Usuario encontrarDNI(int dni);
    void editar(Usuario u);
 
}
