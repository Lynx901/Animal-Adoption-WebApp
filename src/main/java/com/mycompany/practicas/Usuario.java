package com.mycompany.practicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario implements Serializable{
    private int    dni;
    
    @Size(min=2,max=50, message="El nombre debe estar entre 5 y 50 caracteres")
    private String nombre;
    
    @NotEmpty(message="El campo apellidos no puede estar vacio")
    private String apellidos;
    
    private String email;
    private String direccion;
    private String usuario;
    private String pass;
    
    private List<Animal> mascotas;

    public Usuario () {
        dni         = 0;
        nombre      = "";
        apellidos   = "";
        email       = "";
        direccion   = "";
        usuario     = "";
        pass        = "";
        mascotas    = new ArrayList<>();
    }
    
    public Usuario (int _dni, String _nombre, String _apellidos,
                    String _email, String _direccion, String _usuario, String _pass) {
        dni         = _dni;
        nombre      = _nombre;
        apellidos   = _apellidos;
        email       = _email;
        direccion   = _direccion;
        usuario     = _usuario;
        pass        = _pass;
        mascotas    = new ArrayList<>();
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the mascotas
     */
    public List<Animal> getMascotas() {
        return mascotas;
    }
}
