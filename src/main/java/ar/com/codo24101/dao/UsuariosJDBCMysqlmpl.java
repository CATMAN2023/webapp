package ar.com.codo24101.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24101.domain.Usuarios;

public class UsuariosJDBCMysqlmpl implements UsuariosDAO{

    public Usuarios findByUsername(String username) {
        String sql = "SELECT u.id, u.username, u.password, r.rolename " + //
                        "FROM usuarios u " + //
                        "INNER JOIN usuarios_roles ur ON ur.usuarios_id = u.id " + //
                        "INNER JOIN roles r ON r.id = ur.roles_id " + //
                        "WHERE u.username= ?"; //ver LIMIT y Offset

        Usuarios usuario = null;

        Connection connection = null;
        try{
            //aca va la logica
            connection = AdministradordeConexiones.conectar();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultset = statement.executeQuery();

            ArrayList<String> roles = new ArrayList<>();

            Long id = null;
            String dbUsername = null;
            String password = null;

            while(resultset.next()) {
                id = resultset.getLong(1);
                dbUsername = resultset.getString(2);
                password = resultset.getString(3);
                String roleName = resultset.getString(4);
                roles.add(roleName);
            }
            if(id != null) {
                usuario = new Usuarios(id, dbUsername, password, roles);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradordeConexiones.desconectar(connection);
        }

        return usuario;
    }

}