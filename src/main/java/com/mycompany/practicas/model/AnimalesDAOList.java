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
    private static ArrayList<Animales> animales=null;
    
    public AnimalesDAOList(){
        if(animales==null){
            animales = new ArrayList<>();
            Animales a = new Animales("perro", "mestizo", "Bolita de nieve", "PERFECTO", 5, "macho" , true, true, 230000579);
            animales.add(a);
            a = new Animales("gato", "mestizo", "Esperanza", "PERFECTO", 5, "hembra", true, true, 230000579);
            animales.add(a);
            a = new Animales("perro", "mestizo", "Colgantitos", "PERFECTO", 5, "macho" , true, true, 230000579);
            animales.add(a);
        }
    }

    @Override
    public List<Animales> buscatodos() {
        return animales;
    }

    @Override
    public boolean nuevoAnimal(Animales a) {
        animales.add(a);
        return true;
    }
           
    
    
    
}
