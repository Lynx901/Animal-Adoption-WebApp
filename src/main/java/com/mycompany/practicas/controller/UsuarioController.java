package com.mycompany.practicas.controller;

import com.mycompany.practicas.Usuario;
import com.mycompany.practicas.model.UsuarioDAO;
import com.mycompany.practicas.model.UsuarioDAOJDBC;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UsuarioController extends HttpServlet {

    private final String srvViewPath = "/WEB-INF/user";
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
            case "/registro": {        // Formulario de alta
                Usuario u = new Usuario();
                request.setAttribute("user", u);
                rd = request.getRequestDispatcher(srvViewPath + "/register.jsp");
                break;
            }
            case "/login": {        // Formulario de login
                Usuario u = new Usuario();
                request.setAttribute("user", u);
                rd = request.getRequestDispatcher(srvViewPath + "/login.jsp");
                break;
            }
            default: {
                rd = request.getRequestDispatcher(srvViewPath + "/perfil.jsp");
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
            case "/registro": {     // Alta

                /* ------- Recogemos todos los datos necesarios para dar el alta --------- */
                int dni = Integer.parseInt(request.getParameter("dni"));
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String direccion = request.getParameter("direccio");
                String usuario = request.getParameter("usuario");
                String pass = request.getParameter("pass");
                String confirm = request.getParameter("confirm");
                /* ---------------- Fin de recoger datos para el alta ------------------- */
                
                Usuario u = new Usuario(dni, nombre, apellidos, email, direccion, usuario, pass);
                if (validar(u, confirm)) {
                    usuarios.nuevoUsuario(u);
                    //Post-sent-redirect
                    response.sendRedirect("user");
                } else { //Show form with validation errors
                    request.setAttribute("user", u);
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath + "/registro.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            case "/login": {     // login

                /* ------- Recogemos todos los datos necesarios para hacer login --------- */
                String email = request.getParameter("email");
                String usuario = request.getParameter("usuario");
                String pass = request.getParameter("pass");
                /* ---------------- Fin de recoger datos para el login ------------------- */
                
                if (login(email, usuario, pass)) {
                    request.setAttribute("user", usuarios.encuentra(email));
                    //Post-sent-redirect
                    response.sendRedirect("user");
                } else { //Show form with validation errors
                    RequestDispatcher rd = request.getRequestDispatcher(srvViewPath + "/login.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            default: { // Default POST
                response.sendRedirect("user");
                break;
            }
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

    private boolean login(String email, String usuario, String pass) {
        for(Usuario u : usuarios.listar()) {
            if((u.getUsuario().equals(usuario) || u.getEmail().equals(email)) && u.getPass().equals(pass))
                return true;
        }
        return false;
    }

}
