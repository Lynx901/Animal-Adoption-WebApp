package com.mycompany.practicas.controller;

import com.mycompany.practicas.Animal;
import com.mycompany.practicas.model.AnimalesDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/Practicas/animales")
public class AnimalesSpringController {
    @Autowired
    @Qualifier("AnimalesDAOJDBC")
    private AnimalesDAO animalesdao; 
    
    public AnimalesSpringController() {
    }
    
    @ModelAttribute
private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    //Common variables for Views
    model.addAttribute("srvUrl", request.getContextPath()+request.getServletPath()+"/clientes");
    model.addAttribute("imgUrl", request.getContextPath()+"/images");
}
    
    /*METODO CREAR GET Y POST*/
    @RequestMapping(value="/crear", method=RequestMethod.GET)
    public String crearAnimal() {
        return "animales/crear";
    }
    
   @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crearAnimal(
                              @RequestParam(value="animales", required=true) 
                              @ModelAttribute("nombre")String nombre , int edad,  boolean sexo, String especie, String raza, 
                              String estado, boolean chip, boolean vacunas, int dnidueno, String descripcion) {
        Animal animal=new Animal(nombre, edad, sexo, especie, raza, estado, chip, vacunas, dnidueno, descripcion);
        animalesdao.nuevoAnimal(animal);
        return "redirect:animales";
    }
    
    /*METODO VISUALIZAR FICHA*/
    @RequestMapping(value="/ficha", method=RequestMethod.GET)
    public String verAnimal() {
        return "animales/ficha";
    }
    
    /*METODO EDITAR*/
    @RequestMapping(value="/editar", method=RequestMethod.GET)
    public String editarAnimal() {
        return "animales/editar";
    }
    
    @RequestMapping(value="/editar", method=RequestMethod.POST)
    public String editarAnimal(
                              @RequestParam(value="animales", required=true) 
                              @ModelAttribute("nombre")String nombre , int edad,  boolean sexo, String especie, String raza, 
                              String estado, boolean chip, boolean vacunas, int dnidueno, String descripcion) {
        Animal animal=new Animal(nombre, edad, sexo, especie, raza, estado, chip, vacunas, dnidueno, descripcion);
        animalesdao.editar(animal);
        return "redirect:animales";
    }
    
    /*METODO POR DEFECTO LISTAR ANIMALES*/
    @RequestMapping(value="/animales", method=RequestMethod.GET)
    public String listarAnimales(ModelMap model) {
        List<Animal> animales = animalesdao.listar();
        model.addAttribute("animales",animales);
        return "animales/listado";
    }
    
}
