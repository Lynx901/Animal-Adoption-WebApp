/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicas.model;

import com.mycompany.practicas.Animales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  */
public class AnimalesDAOList implements AnimalesDAO{
    private static ArrayList<Animales> animales = null;
    private int lastID;
    
    public AnimalesDAOList(){
        if(animales == null){
            animales = new ArrayList<>();
            Animales a = new Animales(0, "Bolita de nieve", 5, "perro", "Mestizo", "Perfecto", true, true, "Es muy divertido");
            animales.add(a);
            a = new Animales(0, "Esperanza", 3, "gato", "Mestizo", "Perfecto", true, true, "Independiente y elegante");
            animales.add(a);
            a = new Animales(0, "Colgantitos", 8,"perro", "Pastor Alemán", "Enfermo", true, true, "Algo viejo pero muy leal");
            animales.add(a);
        }
    }

    @Override
    public List<Animales> listar() {
        return animales;
    }

    @Override
    public boolean nuevoAnimal(Animales a) {
        a.setId(lastID++);
        animales.add(a);
        return true;
    }
           
    
    
    
}
