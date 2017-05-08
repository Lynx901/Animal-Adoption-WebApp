
package com.mycompany.practicas.model;

import com.mycompany.practicas.Animal;
import com.mycompany.practicas.Usuario;
import java.util.List;

/** Generic Interfaz for Usuario DAOs implementations*/

public interface UsuarioDAO {
    
    List<Usuario> listar();
    List<Animal> listarMascotas(Usuario u);
    boolean nuevoUsuario(Usuario u);
    Usuario encontrarPorEmail(String email);
    Usuario encontrarPorDNI(int dni);
    Usuario encontrarPorLogin(String user);
    boolean editar(Usuario u);
 
}
