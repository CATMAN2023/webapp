package ar.com.codo24101.service;

import ar.com.codo24101.dao.UsuariosDAO;
import ar.com.codo24101.dao.UsuariosJDBCMysqlmpl;
import ar.com.codo24101.domain.Usuarios;

public class UsuariosService {

    private UsuariosDAO dao;//

    public UsuariosService() {
        this.dao = new UsuariosJDBCMysqlmpl();
    }

    public Usuarios buscarPorUsername(String username) {
        return this.dao.findByUsername(username);
    }
}