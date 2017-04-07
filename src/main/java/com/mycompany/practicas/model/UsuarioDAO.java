
package com.mycompany.practicas.model;

import com.mycompany.practicas.Usuario;
import java.util.List;


/** Generic Interfaz for Usuario DAOs implementations*/
public interface UsuarioDAO {
    
    List<Usuario> listar();
    boolean nuevoUsuario(Usuario u);
    Usuario encontrarPorEmail(String email);
    Usuario encontrarPorDNI(int dni);
    Usuario encontrarPorLogin(String user);
    void editar(Usuario u);
 
}
