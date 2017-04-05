package com.mycompany.practicas.model;

import com.mycompany.practicas.Animales;
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

/**
 * JDBC DAO implementation
 */
public class AnimalesDAOJDBC implements AnimalesDAO {

    private static final String connPoolName = "java:/comp/env/jdbc/Practicas"; //Tomcat connection pool
    private DataSource ds = null;
    private Integer lastId;

    public AnimalesDAOJDBC() {
        lastId = 0;
        if (ds == null) {
            try {
                Context context = new InitialContext(); //Accedemos al contenedor de Servlets
                ds = (DataSource) context.lookup(connPoolName); //Localizamos el pool
            } catch (NamingException ex) {
                Logger.getLogger(AnimalesDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static Animales animalesMapper(ResultSet rs) throws SQLException {
        Animales a = null;
        try {
            a = new Animales(rs.getString("nombre"),
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
    public List<Animales> listar() {
        String SQL_BUSCATODOS = "select * from animales";
        List<Animales> animales = new ArrayList<>();
        try (
                Connection conn=ds.getConnection(); //Obtenemos conexión del pool de conexiones
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(SQL_BUSCATODOS);) {
            while (rs.next()) {
                animales.add(animalesMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalesDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return animales;
    }

    @Override
    public boolean nuevoAnimal(Animales a) {
        a.setId(lastId++);
        String SQL_INSERT = "insert into Animales (nombre, edad, sexo, especie, raza, estado, chip, vacunas, dnidueno, descripcion)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        Integer insertados = 0;
        try (Connection conn = ds.getConnection();
             PreparedStatement stmn = conn.prepareStatement(SQL_INSERT)) {

            stmn.setString(1, a.getNombre());
            stmn.setInt(2, a.getEdad());
            stmn.setBoolean(3, a.isSexo());
            stmn.setString(4, a.getEspecie());
            stmn.setString(5, a.getRaza());
            stmn.setString(6, a.getEstado());
            stmn.setBoolean(7, a.isChip());
            stmn.setBoolean(8, a.isVacunas());
            stmn.setInt(9, a.getDuenio());
            stmn.setString(10, a.getDescripcion());
            insertados = stmn.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger("AnimalesDAOJDBC").log(Level.SEVERE, ex.getMessage(), ex);
        }  //Autoclose resources (jdk>7)
        return insertados == 1;
    }


}