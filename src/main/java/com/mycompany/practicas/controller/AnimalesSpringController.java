package com.mycompany.practicas.controller;

import com.mycompany.practicas.Animal;
import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.AnimalesDAO;
import com.mycompany.practicas.model.UsuarioDAOJDBC;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/animales")
@SessionAttributes("animales")
public class AnimalesSpringController {

    @Autowired
    @Qualifier("AnimalesDAOJDBC")
    private AnimalesDAO animalesDAO;
    
    @Autowired
    @Qualifier("UsuarioDAOJDBC")
    private UsuarioDAOJDBC usuariosDAO;


    public AnimalesSpringController() {
    }

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        //Common variables for Views
        model.addAttribute("srvUrl", request.getContextPath() + request.getServletPath() + "/animales");
        model.addAttribute("imgUrl", request.getContextPath() + "/img");
    }
    
    /* Lista todos los animales de la BBDD */
    @RequestMapping(value = "/listado", method = RequestMethod.GET)
    public String listarAnimales(ModelMap model) {
        List<Animal> listaAnimales = animalesDAO.listar();
        model.addAttribute("animales", listaAnimales);
        return "animales/listado";
    }
    
    /* Lleva a la ficha del animal pinchado */
    @RequestMapping(value = "/ficha", method = RequestMethod.GET)
    public String verAnimal(ModelMap model,
                            @RequestParam(value = "id") String id) {
        Animal a = animalesDAO.encontrarNombre(id);
        model.addAttribute("animal", a);
        return "animales/ficha";
    }

    /* GET para crear los animales nuevos */
    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crearAnimal(ModelMap model) {
        model.addAttribute("animal", new Animal());
        return "animales/crear";
    }
    
    /* POST para crear el animal introducido */
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearAnimal(@ModelAttribute("animal") @Valid Animal a,
                              BindingResult result,
                              ModelMap model,
                              Principal principal) {
        String vista = "redirect:listado";
        Usuario u = usuariosDAO.encontrarPorLogin(principal.getName());
        if(!result.hasErrors()) {
            animalesDAO.nuevoAnimal(a, u.getDni());
            model.clear();
        } else {
            vista = "animales/crear";
        }
        return vista;
    }

    /*METODO EDITAR*/
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAnimal() {
        return "redirect:editar";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAnimal(
            @RequestParam(value = "animales", required = true)
            @ModelAttribute("nombre") String nombre, int edad, boolean sexo, String especie, String raza,
            String estado, boolean chip, boolean vacunas, int dnidueno, String descripcion) {
        Animal animal = new Animal(nombre, edad, sexo, especie, raza, estado, chip, vacunas, dnidueno, descripcion);
        animalesDAO.editar(animal);
        return "redirect:animales";
    }

}
