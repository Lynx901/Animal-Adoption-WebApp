package com.mycompany.practicas.model;

import com.mycompany.practicas.Animales;
import java.util.List;

public interface AnimalesDAO {
    List<Animales> listar();
    boolean nuevoAnimal(Animales a);
}
