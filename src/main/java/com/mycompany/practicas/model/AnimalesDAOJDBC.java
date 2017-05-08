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
@Repository("AnimalesDAOJDBC")
public class AnimalesDAOJDBC implements AnimalesDAO {

    private static final String connPoolName = "java:/comp/env/jdbc/Practicas"; //Tomcat connection pool
    private DataSource ds = null;

    public AnimalesDAOJDBC() {
        if (ds == null) {
            try {
                Context context = new InitialContext(); //Accedemos al contenedor de Servlets
                ds = (DataSource) context.lookup(connPoolName); //Localizamos el pool
            } catch (NamingException ex) {
                Logger.getLogger(AnimalesDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
    public List<Animal> listar() {
        String SQL_BUSCATODOS = "select * from animales";
        List<Animal> animales = new ArrayList<>();
        if (ds == null) {
            try {
                Context context = new InitialContext(); //Accedemos al contenedor de Servlets
                ds = (DataSource) context.lookup(connPoolName); //Localizamos el pool
            } catch (NamingException ex) {
                Logger.getLogger(AnimalesDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try (
                Connection conn = ds.getConnection(); //Obtenemos conexión del pool de conexiones
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_BUSCATODOS);) {
            while (rs.next()) {
                animales.add(animalesMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalesDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return animales;
    }

    @Override
    public boolean nuevoAnimal(Animal a, int dnidueno) {
        UsuarioDAOJDBC usuarios = new UsuarioDAOJDBC();
        Usuario u = usuarios.encontrarPorDNI(dnidueno);
        u.getMascotas().add(a);

        a.setId(listar().size()+1);

        String SQL_INSERT = "INSERT INTO Animales (id, nombre, edad, sexo, especie, raza, estado, chip, vacunas, dnidueno, descripcion)"
                          + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        int insertados = 0;
        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_INSERT)) {

            stmn.setInt(1, a.getId());
            stmn.setString(2, a.getNombre());
            stmn.setInt(3, a.getEdad());
            stmn.setBoolean(4, a.isSexo());
            stmn.setString(5, a.getEspecie());
            stmn.setString(6, a.getRaza());
            stmn.setString(7, a.getEstado());
            stmn.setBoolean(8, a.isChip());
            stmn.setBoolean(9, a.isVacunas());
            stmn.setInt(10, dnidueno);
            stmn.setString(11, a.getDescripcion());
            insertados = stmn.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("AnimalesDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)
        return insertados == 1;
    }

    @Override
    public boolean editar(Animal a) {
        String SQL_EDIT = "UPDATE Animales "
                        + "SET nombre=?, edad=?, sexo=?, especie=?, raza=?, estado=?, chip=?, vacunas=?, descripcion=? "
                        + "WHERE id=?";
        boolean result = false;

        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_EDIT)) {

            stmn.setString(1, a.getNombre());
            stmn.setInt(2, a.getEdad());
            stmn.setBoolean(3, a.isSexo());
            stmn.setString(4, a.getEspecie());
            stmn.setString(5, a.getRaza());
            stmn.setString(6, a.getEstado());
            stmn.setBoolean(7, a.isChip());
            stmn.setBoolean(8, a.isVacunas());
            stmn.setString(9, a.getDescripcion());
            stmn.setInt(10, a.getId());
            stmn.executeUpdate();
            result = (stmn.executeUpdate() == 1);
            
        } catch (SQLException ex) {
            Logger.getLogger("AnimalesDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)
        return result;
    }
    
    @Override
    public boolean borrar(int id) {
        String SQL_BORRAR = "DELETE FROM Animales WHERE id=?";
        boolean result=false;
        try (Connection conn=ds.getConnection();
            PreparedStatement stmn=conn.prepareStatement(SQL_BORRAR)){
            
            stmn.setInt(1, id);
            result=(stmn.executeUpdate() == 1);
            
        } catch (Exception ex) {
            Logger.getLogger(AnimalesDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }         
        return result;
    }

    @Override
    public Animal encontrarID(int id) {
        String SQL_BUSCA = "SELECT * FROM Animales where id=?";

        Animal a = null;
        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_BUSCA)) {
            
            stmn.setInt(1, id);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                a = animalesMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return a;
    }

    @Override
    public Animal encontrarNombre(String nombre) {
        String SQL_BUSCA = "SELECT * FROM Animales where nombre=?";

        Animal a = null;
        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_BUSCA)) {
            
            stmn.setString(1, nombre);
            try (ResultSet rs = stmn.executeQuery()) {
                rs.next();
                a = animalesMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOJDBC.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return a;
    }

}
