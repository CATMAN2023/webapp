package ar.com.codo24101.dao;

import java.util.ArrayList;

import ar.com.codo24101.domain.Clubes;
public interface ClubesDAO {

    public Clubes getById(Long id);
    public void create(Clubes clubesDto);
    public ArrayList<Clubes> findAll();/*ver como agregar LIMIT Y OFFSET */
	public void update(Clubes clubes);
    public void delete(Long id);
}