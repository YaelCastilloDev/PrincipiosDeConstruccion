package practicasprofesionaleslis.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import practicasprofesionaleslis.modelo.ConexionBD;
import practicasprofesionaleslis.modelo.pojo.Usuario;

public class InicioSesionDAO {
    public static Usuario verificarCredenciales(String username, String password) throws SQLException {
        Usuario usuarioSesion = null;
        Connection conexionBD = ConexionBD.abrirConexion();
        
        if (conexionBD != null) {
            String consulta = "SELECT id_usuario, nombre, apellido_paterno, apellido_materno, username " +
                              "FROM usuario " +
                              "WHERE username = ? AND password = ?;";
            PreparedStatement sentencia = conexionBD.prepareStatement(consulta);
            sentencia.setString(1, username);
            sentencia.setString(2, password);
            ResultSet resultado = sentencia.executeQuery();
            
            if (resultado.next()) {
                usuarioSesion = new Usuario();
                usuarioSesion.setIdUsuario(resultado.getInt(1));
                usuarioSesion.setNombre(resultado.getString(2));
                usuarioSesion.setApellidoPaterno(resultado.getString(3));
                usuarioSesion.setApellidoMaterno((resultado.getString(4) != null) ?
                                resultado.getString(4) : "");
                usuarioSesion.setUsername(resultado.getString(5));
            }
        } else {
            throw new SQLException("Error: Sin conexión a la base de datos.");
        }
        return usuarioSesion;
    }
}