/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicas.controller;

import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.UsuarioDAOJDBC;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanf
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {

    private UsuarioDAOJDBC usuarios;
    private String srvUrl;
    private String imgUrl;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        usuarios = new UsuarioDAOJDBC();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //Aceptar caracteres acentuados y ñ
        response.setHeader("Expires", "0"); //Avoid browser caching response
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        RequestDispatcher rd;
        
        Usuario u = new Usuario();
        request.setAttribute("usuario", u);
        rd = request.getRequestDispatcher("/register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        /* ------- Recogemos todos los datos necesarios para dar el alta --------- */
        int dni = Integer.parseInt(request.getParameter("dni"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String confirm = request.getParameter("confirm");
        /* ---------------- Fin de recoger datos para el alta ------------------- */

        Usuario u = new Usuario(dni, nombre, apellidos, email, direccion, usuario, pass);
        if (validar(u, confirm)) {
            usuarios.nuevoUsuario(u);
            response.sendRedirect("registro.jsp");
        } else { //Show form with validation errors
            request.setAttribute("usuario", u);
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Registro de usuarios";
    }

    private boolean validar(Usuario u, String confirm) {
        boolean nombreOK = u.getNombre().length() > 2;
        boolean usuarioOK = u.getUsuario().length() > 2;
        boolean passOK = u.getPass().equals(confirm);

        return (nombreOK && usuarioOK && passOK); // Devuelve true si todo está OK, false si no
    }
}
