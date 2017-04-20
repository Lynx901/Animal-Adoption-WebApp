package com.mycompany.practicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/animales")
@SessionAttributes("animales")
public class AnimalesSpringController {
    
    @RequestMapping(value="/crear", method=RequestMethod.GET)
    public String crearAnimal() {
        return "animales/crear";
    }
    
    @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crearAnimal(
                              @RequestParam(value="animales", required=true) 
                              String animales, ModelMap model) {
        model.addAttribute("animales", animales);
        return "redirect:animales";
    }
}
