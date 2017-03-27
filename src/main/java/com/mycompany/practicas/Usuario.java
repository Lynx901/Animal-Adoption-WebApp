/**
 * Usuario.java
 *
 * Created on 14-mar-2017, 12:37:50
 * This file is inside the Practicas project.
 *
 * Copyright(c) 2017 Daniel Moya. All Rights Reserved.
 *
 */

package com.mycompany.practicas;

import java.io.Serializable;

/**
 * @author dani
 * @brief
 */
public class Usuario implements Serializable{
    private int    dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String usuario;
    private String pass;

    public Usuario () {
        dni         = 0;
        nombre      = "";
        apellidos   = "";
        email       = "";
        usuario     = "";
        pass        = "";
    }
    
    public Usuario (int dni_, String nombre_, String apellidos_,
                    String email_, String usuario_, String pass_) {
        dni         = dni_;
        nombre      = nombre_;
        apellidos   = apellidos_;
        email       = email_;
        usuario     = usuario_;
        pass        = pass_;
    }

    /**
     * @return the dni
     */
    public int getDNI() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDNI(int dni) {
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

}
