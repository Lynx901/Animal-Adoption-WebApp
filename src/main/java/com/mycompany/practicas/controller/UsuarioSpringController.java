package com.mycompany.practicas.controller;

import com.mycompany.practicas.Animal;
import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.UsuarioDAO;
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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class UsuarioSpringController {

    @Autowired
    @Qualifier("UsuarioDAOJDBC")
    private UsuarioDAO usuariosDAO;

    public UsuarioSpringController() {
    }

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        //Common variables for Views
        model.addAttribute("srvUrl", request.getContextPath() + request.getServletPath() + "/usuarios");
        model.addAttribute("imgUrl", request.getContextPath() + "/img");
    }

    /* GET para mostrar el perfil*/
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String verUsuario(ModelMap model,
                             Principal principal) {
        Usuario u = usuariosDAO.encontrarPorLogin(principal.getName());
        List<Animal> m = usuariosDAO.listarMascotas(u);
        model.addAttribute("usuario", u);
        model.addAttribute("mascotas", m);
        return "usuarios/perfil";
    }
    
    /* GET para editar el usuario */
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarUsuario(@ModelAttribute("usuario") Usuario u,
                                ModelMap model,
                                Principal principal) {
        u = usuariosDAO.encontrarPorLogin(principal.getName());
        model.addAttribute("usuario", u);
        return "usuarios/editar";
    }

    /* POST para editar un usuario */
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarUsuario(@ModelAttribute("usuario") @Valid Usuario u,
                                BindingResult result,
                                ModelMap model) {
        String vista = "redirect:perfil";
        if(!result.hasErrors()) {
            if(usuariosDAO.editar(u))
                System.out.println("Guardado correctamente");
            model.clear();
        } else {
            vista = "usuarios/editar";
        }
        return vista;
    }

    /* GET para registrar un usuario */
    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String registroUsuario(ModelMap model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/registro";
    }
    
    /* POST para registrar un usuario */
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registroUsuario(@ModelAttribute("usuario") @Valid Usuario u,
                                  BindingResult result, 
                                  ModelMap model) {
        String vista = "redirect:perfil"; 
        if (!result.hasErrors()) {
            System.out.println("Se ha creado un nuevo usuario");
            usuariosDAO.nuevoUsuario(u);
            model.clear();
        }else {
            System.out.println("Se ha creado un nuevo usuario");
            vista = "usuarios/registro";
        }
        return vista;
    }

}
