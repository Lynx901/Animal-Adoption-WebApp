package com.mycompany.practicas.controller;

import com.mycompany.practicas.Animal;
//import com.mycompany.practicas.model.AnimalesDAO;
import com.mycompany.practicas.model.AnimalesDAOJDBC;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/animales/*")
public class AnimalesController extends HttpServlet {

    private final String srvViewPath = "/WEB-INF/animales";
    private AnimalesDAOJDBC animales;
    private String srvUrl;
    private String imgUrl;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        animales = new AnimalesDAOJDBC();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //Aceptar caracteres acentuados y ñ
        response.setHeader("Expires", "0"); //Avoid browser caching response

//        srvUrl = request.getContextPath() + request.getServletPath();

//        request.setAttribute("srvUrl", srvUrl);    
//        request.setAttribute("animales", animales.listar().toArray());
//     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        RequestDispatcher rd;

        String action = ((request.getPathInfo() != null) ? request.getPathInfo() : "");
        switch (action) {
            case "/crear": { 
                Animal a = new Animal();
                request.setAttribute("animales", a);
                rd = request.getRequestDispatcher(srvViewPath + "/crear.jsp");
                break;
            }
            case "/ficha": {
                String nombre = request.getParameter("id");
                Animal a = animales.encontrarNombre(nombre);
                request.setAttribute("animales", a);
                rd = request.getRequestDispatcher(srvViewPath + "/ficha.jsp?id="+nombre);
                break;
            }
            case "/editar": {
                String nombre = request.getParameter("id");
                Animal a = animales.encontrarNombre(nombre);
                request.setAttribute("animales", a);
                rd = request.getRequestDispatcher(srvViewPath + "/editar.jsp?id="+nombre);
                break;
            }
            default: {
                request.setAttribute("animales", animales.listar());
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

        switch (action) {
            case "/crear": {
                
                /* ------- Recogemos todos los datos necesarios para dar el alta --------- */
                String  nombre  = request.getParameter("nombre");
                int     edad    = Integer.parseInt(request.getParameter("edad"));
                boolean sexo    = Boolean.valueOf(request.getParameter("sexo"));
                
                String especie  = request.getParameter("especie");
                String raza     = request.getParameter("raza");
                String estado   = request.getParameter("estado");
                
                boolean chip    = Boolean.valueOf(request.getParameter("chip"));
                boolean vacunas = Boolean.valueOf(request.getParameter("vacunas"));
                
                String description = request.getParameter("description");
                
                int dni = 77360609;
                if(request.getSession().getAttribute("dni") != null)
                    dni = (int) request.getSession().getAttribute("dni"); 
                /* ---------------- Fin de recoger datos para el alta ------------------- */ 

                Animal a = new Animal(nombre, edad, sexo, especie, raza, estado, chip, vacunas, dni, description);
                if (validar(a) && dni != 0) {
                    animales.nuevoAnimal(a);
                    //Post-sent-redirect
                    response.sendRedirect("animales");
                } else { //Show form with validation errors
                    request.setAttribute("animales", a);
                    RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            case "/editar": {
                
                /* ------- Recogemos todos los datos necesarios para editar --------- */
                String  nombre  = request.getParameter("nombre");
                int     edad    = Integer.parseInt(request.getParameter("edad"));
                boolean sexo    = Boolean.valueOf(request.getParameter("sexo"));
                
                String especie  = request.getParameter("especie");
                String raza     = request.getParameter("raza");
                String estado   = request.getParameter("estado");
                
                boolean chip    = Boolean.valueOf(request.getParameter("chip"));
                boolean vacunas = Boolean.valueOf(request.getParameter("vacunas"));
                
                String description = request.getParameter("description");
                
                int dni = 77360609;
                if(request.getSession().getAttribute("dni") != null)
                    dni = (int) request.getSession().getAttribute("dni"); 
                /* ---------------- Fin de recoger datos para editar ------------------- */ 

                Animal a = new Animal(nombre, edad, sexo, especie, raza, estado, chip, vacunas, dni, description);
                if (validar(a) && dni != 0) {
                    animales.editar(a);
                    //Post-sent-redirect
                    response.sendRedirect("animales");
                } else { //Show form with validation errors
                    request.setAttribute("animales", a);
                    RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            default: { // Default POST
                response.sendRedirect("animales");
                break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Registro de animales";
    }

    private boolean validar(Animal a) {
        boolean nombreOK = a.getNombre().length() > 2;
        boolean edadOK   = a.getEdad() > 0 && a.getEdad() < 100;
        boolean estadoOK = a.getEstado().length() > 4; 
        
        return (nombreOK && edadOK && estadoOK); // Devuelve true si todo está OK, false si no
    }

}
