package com.mycompany.practicas.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.practicas.model.UsuarioDAOJDBC;
import com.mycompany.practicas.model.UsuarioDAO;

@WebServlet(name = "DAWController", urlPatterns = {"/Practicas"})
public class DAWControllerUser extends HttpServlet {

    private UsuarioDAO usuarios;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    public void init()
            throws ServletException {

        super.init();
        //Select DAO implementation
        usuarios = new UsuarioDAOJDBC();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //Aceptar caracteres acentuados y ñ
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int dni = (int) request.getSession().getAttribute("dni");
        RequestDispatcher rd;

        if (dni == 0) {
            // Mostrar formulario de entrada de datos
            rd = request.getRequestDispatcher("register.jsp");
        } else {
            // El usuario ya tiene nombre asignado: mostrar página de inicio
            rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("usuarios", usuarios.buscaTodos());
        }
        //Pasar el control a la vista
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String dni = request.getParameter("dni");
        //TODO, validar dni
        if (dni != null) {
            request.getSession().setAttribute("dni", dni);
        }

        String nombre = request.getParameter("name");
        if (nombre != null) {
            request.getSession().setAttribute("dni", nombre);
        }

        String apellidos = request.getParameter("name");
        if (nombre != null) {
            request.getSession().setAttribute("nombre", apellidos);
        }

        String email = request.getParameter("email");
        if (nombre != null) {
            request.getSession().setAttribute("email", email);
        }

        String usuario = request.getParameter("username");
        if (nombre != null) {
            request.getSession().setAttribute("usuario", usuario);
        }

        String pass = request.getParameter("password");
        if (nombre != null) {
            request.getSession().setAttribute("password", pass);
        }

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Registro de usuarios";
    }

}
