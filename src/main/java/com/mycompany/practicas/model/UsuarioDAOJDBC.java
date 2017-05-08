package com.mycompany.practicas.model;

import com.mycompany.practicas.Animal;
import com.mycompany.practicas.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

/**
 * JDBC DAO implementation
 */
@Repository("UsuarioDAOJDBC")
public class UsuarioDAOJDBC implements UsuarioDAO {

    private static String connPoolName = "java:/comp/env/jdbc/Practicas"; //Tomcat connection pool
    private DataSource ds = null;

    public UsuarioDAOJDBC() {

        if (ds == null) {
            try {
                Context context;
                context = new InitialContext(); //Accedemos al contenedor de Servlets
                ds = (DataSource) context.lookup(connPoolName); //Localizamos el pool
            } catch (NamingException ex) {
                Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Recupera un Usuario a partir del registro actual del RS (MAPPING)
     */
    private static Usuario usuarioMapper(ResultSet rs) throws SQLException {
        Usuario u = null;
        try {
            u = new Usuario(rs.getInt("dni"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("email"),
                            rs.getString("direccion"),
                            rs.getString("usuario"),
                            rs.getString("pass"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return u;
    }
    
    private static Animal animalesMapper(ResultSet rs) throws SQLException {
        Animal a = null;
        try {
            a = new Animal(rs.getInt("id"),
                           rs.getString("nombre"),
                           rs.getInt("edad"),
                           rs.getBoolean("sexo"),
                           rs.getString("especie"),
                           rs.getString("raza"),
                           rs.getString("estado"),
                           rs.getBoolean("chip"),
                           rs.getBoolean("vacunas"),
                           rs.getInt("dnidueno"),
                           rs.getString("descripcion"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return a;
    }

    @Override
    public List<Usuario> listar() {
        String SQL_BUSCATODOS = "Select * from usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try (
                Connection conn = ds.getConnection(); //Obtenemos conexión del pool de conexiones
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_BUSCATODOS);) {
            while (rs.next()) {
                usuarios.add(usuarioMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    @Override
    public List<Animal> listarMascotas(Usuario u) {
        String SQL_BUSCATODOS = "Select * from animales where dnidueno=" + u.getDni();
        List<Animal> mascotas = new ArrayList<>();
        try (
                Connection conn = ds.getConnection(); //Obtenemos conexión del pool de conexiones
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_BUSCATODOS);) {
            while (rs.next()) {
                mascotas.add(animalesMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mascotas;
    }

    @Override
    public boolean nuevoUsuario(Usuario u) {
        String SQL_INSERT = "insert into Usuarios (dni, nombre, apellidos, email, direccion, usuario) values(?,?,?,?,?,?)";
        Integer insertados = 0;
        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_INSERT)) {

            stmn.setInt(1, u.getDni());
            stmn.setString(2, u.getNombre());
            stmn.setString(3, u.getApellidos());
            stmn.setString(4, u.getEmail());
            stmn.setString(5, u.getDireccion());
            stmn.setString(6, u.getUsuario());
            insertados = stmn.executeUpdate();

            registrar(u);

        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)
        return insertados == 1;
    }

    @Override
    public boolean editar(Usuario u) {
        String SQL_INSERT = "UPDATE Usuarios SET nombre=?, apellidos=?, email=?, direccion=? WHERE dni=?";
        boolean result = false;
        
        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_INSERT)) {

            stmn.setString(1, u.getNombre());
            stmn.setString(2, u.getApellidos());
            stmn.setString(3, u.getEmail());
            stmn.setString(4, u.getDireccion());
            stmn.setInt(5, u.getDni());
            stmn.executeUpdate();
            result = (stmn.executeUpdate() == 1);

        } catch (SQLException ex) {
            Logger.getLogger("UsuariosDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)
        return result;
    }

    @Override
    public Usuario encontrarPorEmail(String email) {
        for (Usuario u : listar()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Usuario encontrarPorDNI(int dni) {
        for (Usuario u : listar()) {
            if (u.getDni() == dni) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public Usuario encontrarPorLogin(String user) {
        for (Usuario u : listar()) {
            if (u.getUsuario().equals(user)) {
                return u;
            }
        }
        return null;
    }

    public boolean registrar(Usuario u) {
        String SQL_INSERT = "insert into Users (usuario, clave) values(?,?)";
        Integer insertados = 0;

        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_INSERT)) {
            stmn.setString(1, u.getUsuario());
            stmn.setString(2, u.getPass());
            insertados = stmn.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)

        SQL_INSERT = "insert into Roles (usuario, rol) values(?,?)";

        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_INSERT)) {
            stmn.setString(1, u.getUsuario());
            stmn.setString(2, "USUARIO");
            insertados = stmn.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)

        return insertados == 1;
    }

}
