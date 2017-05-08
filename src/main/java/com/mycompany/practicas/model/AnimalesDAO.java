package com.mycompany.practicas.model;

import com.mycompany.practicas.Animal;
import java.util.List;

public interface AnimalesDAO {
    List<Animal> listar();
    boolean nuevoAnimal(Animal a, int dnidueno);
    Animal encontrarID(int id);
    Animal encontrarNombre(String nombre);
    boolean editar(Animal a);
    boolean borrar(int id);
}
