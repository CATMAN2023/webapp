package ar.com.codo24101.web.service;

import ar.com.codo24101.dao.UsuariosJDBCMysqlmpl;
import ar.com.codo24101.domain.Usuarios;
import ar.com.codo24101.dao.UsuariosDAO;

public class UsuariosService {

    private UsuariosDAO dao;//

    public UsuariosService() {
        this.dao = new UsuariosJDBCMysqlmpl();
    }

    public Usuarios buscarPorUsername(String username) {
        return this.dao.findByUsername(username);
    }
}