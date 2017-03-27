/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicas.controller;

import com.mycompany.practicas.Animales;
import com.mycompany.practicas.model.AnimalesDAO;
import com.mycompany.practicas.model.AnimalesDAOList;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author juanf
 */
@WebServlet("/animales/*")
public class DAWControllerAnimals extends HttpServlet {
    private final String srvViewPath="/WEB-INF/animales";
    private AnimalesDAO animales;
    private String srvUrl;
    private String imgUrl;
    private static final Logger LOG = Logger.getLogger(DAWControllerAnimals.class.getName());
   
   
    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        super.init(servletConfig);
        
        animales = new AnimalesDAOList();
    }
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //Aceptar caracteres acentuados y ñ
        response.setHeader("Expires","0"); //Avoid browser caching response

        srvUrl = request.getContextPath() + request.getServletPath();

//        request.setAttribute("srvUrl", srvUrl);    
//        request.setAttribute("animales", animales.buscatodos().toArray());
//     
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        RequestDispatcher rd;

        String action = ((request.getPathInfo() != null) ? request.getPathInfo() : "");
        LOG.log(Level.INFO, "Petición GET (0)", action);
        switch (action){
            case "/crear":  {        //FORMULARIO ALTA DE  CLIENTE
                Animales an = new Animales();
                request.setAttribute("animales", an);
                rd = request.getRequestDispatcher(srvViewPath + "/crear.jsp");
                break;
            }
            default: { 
                request.setAttribute("animales", animales.buscatodos());
                rd = request.getRequestDispatcher(srvViewPath + "/listado.jsp");        
                break;
            }
        }
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        LOG.log(Level.INFO, "Petición POST (0)", action);
        
        switch (action) {
            case "/crear": {     //ALTA DE UN CLIENTE
                String especie = request.getParameter("especie");
                String raza = request.getParameter("raza");
                String nombre = request.getParameter("nombre");
                String estado = request.getParameter("estado");
                
                //
                Animales an = new Animales(especie, raza, nombre, estado, 0, false, false, 0);
               
                if (validarAnimal(request, an)) { //Hay que arreglaro
                    animales.nuevoAnimal(an); //Create new client
                    //Post-sent-redirect
                    response.sendRedirect("animales");
                } else { //Show form with validation errores
                    request.setAttribute("animales", an);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath + "/crear.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            default:{ // Default POST
                response.sendRedirect("animales");        
                break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Registro de animales";
    }
    
    private boolean validarAnimal(HttpServletRequest request, Animales an){
        boolean valido = true;
        if (an.getEdad()<0 || an.getEdad() > 100){
            valido = false;
        }
        if(an.getEspecie().equals("perro") || an.getEspecie().equals("gato") || an.getEspecie().equals("mono")){
            valido = false;
        }
       return valido; 
    } 
     
}
