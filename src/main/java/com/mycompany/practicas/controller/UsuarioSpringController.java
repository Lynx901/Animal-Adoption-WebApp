/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicas.controller;

import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.UsuarioDAO;
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

/**
 *
 * @author juanf
 */
@Controller
@RequestMapping("/Practicas")
@SessionAttributes("usuarios")
public class UsuarioSpringController {

    @Autowired
    @Qualifier("UsuarioDAOJDBC")
    private UsuarioDAO usuariosdao;

    public UsuarioSpringController() {
    }

    @ModelAttribute
    private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        //Common variables for Views
        model.addAttribute("srvUrl", request.getContextPath() + request.getServletPath() + "/clientes");
        model.addAttribute("imgUrl", request.getContextPath() + "/images");
    }

    /*METODO PERFIL GET*/
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String verUsuario() {
        return "usuarios/perfil";
    }
    
    /*METODO REGISTRO GET*/
    @RequestMapping(value = "/registro", method=RequestMethod.GET)
    public String registroUsuario(ModelMap model) {
        model.addAttribute("usuario",new Usuario());
        return "usuarios/registro";    
    }
    
    
    /*METODO REGISTRO POST*/
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registroUsuario(
            @RequestParam(value = "usuarios", required = true)
            @ModelAttribute("usuario") @Valid Usuario u,
            BindingResult result, //IMPORTAN: MUST appear after @Valid attribute
            ModelMap model) {
        
        String view;
        
        if (!result.hasErrors()) {
            usuariosdao.nuevoUsuario(u);
            view="usuarios/perfil";
        }else {
             List<Usuario> lusuario = usuariosdao.listar();
            model.addAttribute("usuarios",lusuario);
            view="usuarios/registro";
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
        usuariosdao.editar(u);
        return "redirect:animales";
    }

}
