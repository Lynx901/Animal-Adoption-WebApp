/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicas.model;

import com.mycompany.practicas.Animales;
import java.util.List;

/**
 *
 * @author juanf
 */
public interface AnimalesDAO {
    List<Animales> listar();
    boolean nuevoAnimal(Animales a);
}
