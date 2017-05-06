package com.mycompany.practicas.controller;

import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.UsuarioDAO;
import java.security.Principal;
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
        model.addAttribute("usuario", u);
        return "usuarios/perfil";
    }

    /*METODO REGISTRO GET Y POST*/
    
    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String registroUsuario(ModelMap model) {
        model.addAttribute("usuario",new Usuario());
        return "usuarios/registro";
    }
    
    
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registroUsuario(
            @ModelAttribute("usuario") @Valid Usuario u,
            BindingResult result, ModelMap model) {
       String view="redirect:animales"; 
       
       if (!result.hasErrors()) {
         usuariosDAO.nuevoUsuario(u);
         model.clear();
        }else {
            view="usuarios/registro"; //Show error, and ask for correct data
        }
        return view;
    }

    /*METODO EDITAR GET Y POST*/
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String editarUsuario() {
        return "usuarios/editar";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarUsuario(
            @RequestParam(value = "usuarios", required = true)
            @ModelAttribute("dni") int dni, String nombre, String apellidos, String email, String direccion,
            String usuario, String pass) {
        Usuario u = new Usuario(dni, nombre, apellidos, email, direccion, usuario, pass);
        usuariosDAO.editar(u);
        return "redirect:animales";
    }

}
