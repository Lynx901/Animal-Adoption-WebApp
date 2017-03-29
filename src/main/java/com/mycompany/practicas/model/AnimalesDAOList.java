package com.mycompany.practicas.model;

import com.mycompany.practicas.Animales;
import java.util.ArrayList;
import java.util.List;

public class AnimalesDAOList implements AnimalesDAO{
    private static ArrayList<Animales> animales = null;
    
    public AnimalesDAOList(){
        if(animales == null){
            animales = new ArrayList<>();
            Animales a = new Animales("Bolita de nieve", 5 , true , "perro" , "mestizo", "PERFECTO" , true, true, 123456789 , "Precioso animal con colita graciosa" );
            animales.add(a);
            a = new Animales("Esperanza", 3, false , "gato", "siames", "PERFECTO", true, true, 230000579, "Precioso gatito con cara de esponja");
            animales.add(a);
            a = new Animales("Colgantitos", 10, true, "perro", "Pastor alemán", "PERFECTO", true, true, 230000579, "Es un viejete majete");
            animales.add(a);
        }
    }

    @Override
    public List<Animales> listar() {
        return animales;
    }

    @Override
    public boolean nuevoAnimal(Animales a) {
        animales.add(a);
        return true;
    }
           
}
