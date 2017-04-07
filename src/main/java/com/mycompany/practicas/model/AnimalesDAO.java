package com.mycompany.practicas.model;

import com.mycompany.practicas.Animal;
import java.util.List;

public interface AnimalesDAO {
    List<Animal> listar();
    boolean nuevoAnimal(Animal a);
    Animal encontrarID(int id);
    void editar(Animal a);
}
