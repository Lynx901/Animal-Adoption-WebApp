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

@WebServlet("/animales/*")
public class AnimalesController extends HttpServlet {

    private final String srvViewPath = "/WEB-INF/animales";
    private AnimalesDAO animales;
    private String srvUrl;
    private String imgUrl;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        animales = new AnimalesDAOList();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //Aceptar caracteres acentuados y ñ
        response.setHeader("Expires", "0"); //Avoid browser caching response

        //srvUrl = request.getContextPath() + request.getServletPath();

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
            case "/crear": {        //FORMULARIO ALTA
                Animales a = new Animales();
                request.setAttribute("animales", a);
                rd = request.getRequestDispatcher(srvViewPath + "/crear.jsp");
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
            case "/crear": {     //ALTA
                
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
                
                //int dni = (int) request.getSession().getAttribute("dni"); // Esto coge el dni que está usando el usuario en la sesión actual
                int dni = 0; //Eso hay que cambiarlo por lo de arriba cuando se incluya lo del usuario
                
                /* ---------------- Fin de recoger datos para el alta ------------------- */ 

                Animales a = new Animales(nombre, edad, sexo, especie, raza, estado, chip, vacunas, dni , description);
                if (validar(a)) {
                    animales.nuevoAnimal(a);
                    //Post-sent-redirect
                    response.sendRedirect("animales");
                } else { //Show form with validation errors
                    request.setAttribute("animales", a);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath + "/crear.jsp");
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

    private boolean validar(Animales a) {
        boolean nombreOK = a.getNombre().length() > 2;
        boolean edadOK   = a.getEdad() > 0 && a.getEdad() < 100;
        boolean estadoOK = a.getEstado().length() > 4; 
        
        return (nombreOK && edadOK && estadoOK); // Devuelve true si todo está OK, false si no
    }

}
