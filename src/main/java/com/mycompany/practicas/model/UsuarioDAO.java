
package com.mycompany.practicas.model;

import com.mycompany.practicas.Usuario;
import java.util.List;
import org.springframework.stereotype.Repository;


/** Generic Interfaz for Usuario DAOs implementations*/
@Repository
public interface UsuarioDAO {
    
    List<Usuario> listar();
    boolean nuevoUsuario(Usuario u);
    Usuario encontrarPorEmail(String email);
    Usuario encontrarPorDNI(int dni);
    Usuario encontrarPorLogin(String user);
    void editar(Usuario u);
 
}
