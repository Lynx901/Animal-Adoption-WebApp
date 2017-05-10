package com.mycompany.practicas.controller;

import com.mycompany.practicas.Animal;
import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.AnimalesDAO;
import com.mycompany.practicas.model.UsuarioDAOJDBC;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.ServletException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public String listarAnimales(@RequestParam(value = "raza", defaultValue = "") String raza,
                                 ModelMap model) {
        List<Animal> listaAnimales = animalesDAO.listar();
        model.addAttribute("animales", listaAnimales);
        String vista = "animales/listado";
        if (!raza.isEmpty()) {
            vista = vista + "?raza=" + raza;
        }
        return vista;
    }

    /* Lleva a la ficha del animal pinchado */
    @RequestMapping(value = "/ficha", method = RequestMethod.GET)
    public String verAnimal(ModelMap model,
                            @RequestParam(value = "id") int id) {
        Animal a = animalesDAO.encontrarID(id);
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
                              Principal principal) throws Exception {
        String vista = "redirect:listado";
        
        Usuario u = usuariosDAO.encontrarPorLogin(principal.getName());
        if (!result.hasErrors()) {
            animalesDAO.nuevoAnimal(a, u.getDni());
            model.clear();
        } else {
            vista = "animales/crear";
        }
        
        MultipartFile multipart = a.getMultipartFile();
        try {
             File path = new File("/Users/dani/Documents/NetBeans/DAW/src/main/webapp/img/animales");
             String newNombre = (a.getId() + ".png");
             multipart.transferTo(new File(path, newNombre));
        } catch (IOException | IllegalStateException | NullPointerException e) {
             vista = "animales/crear";
        }
        
        return vista;
    }

    /* GET para editar un animal */
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarAnimal(@ModelAttribute("animal") Animal a,
                               @RequestParam(value = "id") int id,
                               ModelMap model) {
        a = animalesDAO.encontrarID(id);
        model.addAttribute("animal", a);
        return "animales/editar";
    }

    /* POST para editar un animal */
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarAnimal(@ModelAttribute("animal") @Valid Animal a,
                               BindingResult result,
                               ModelMap model) throws Exception {
        String vista = "redirect:ficha";
        
        MultipartFile multipart = a.getMultipartFile();
        try {
             File path = new File("/Users/dani/Documents/NetBeans/DAW/src/main/webapp/img/animales");
             String newNombre = (a.getId() + ".png");
             multipart.transferTo(new File(path, newNombre));
        } catch (IOException | IllegalStateException | NullPointerException e) {
             vista = "animales/editar";
        }
        
        if (!result.hasErrors()) {
            if (animalesDAO.editar(a)) {
                System.out.println("Guardado correctamente");
            }
            model.clear();
            vista = vista + "?id=" + a.getId();
        } else {
            vista = "animales/editar";
        }
        return vista;
    }

    /* GET para borrar un animal */
    @RequestMapping(value = "/borrar", method = RequestMethod.GET)
    public String borra(@RequestParam(value = "id", defaultValue = "0") Integer id,
                        ModelMap model) {
        animalesDAO.borrar(id);
        model.clear();
        return "redirect:listado";
    }
}
