package ar.com.codo24101.dao;

import ar.com.codo24101.domain.Usuarios;

public interface UsuariosDAO {

    public Usuarios findByUsername(String username);
}