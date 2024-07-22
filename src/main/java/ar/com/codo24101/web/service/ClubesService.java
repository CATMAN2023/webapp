package ar.com.codo24101.web.service;

import java.util.ArrayList;

import ar.com.codo24101.dao.ClubesDAO;
import ar.com.codo24101.dao.ClubesJDBCMysqlImpl;
import ar.com.codo24101.domain.Clubes;
import ar.com.codo24101.dto.ClubesDTO;

public class ClubesService {

    private ClubesDAO dao;//???

    public ClubesService() {
        //Interface i = new ClaseQueImplementaLaInterface();
        this.dao = new ClubesJDBCMysqlImpl();
    }

    public Clubes obtener(Long id) {
        return this.dao.getById(id);
    }

    public void crear(ClubesDTO dto) {

        Clubes Clubes = new Clubes(dto.getName(), 
            dto.getLogo(),
            dto.getFundado(),
            dto.getProvincia(),
            dto.getEstadio(),
            dto.getConstruido(),
            dto.getCapacidad(),
            dto.getCampprof(),
            dto.getCampamat(),
            dto.getCategoria());

        this.dao.create(Clubes);//ctrl+click
    }

    public ArrayList<Clubes> listarMovies() {
        return this.dao.findAll();
    }

    public void actualizar(ClubesDTO dto) {
        Clubes Clubes = new Clubes(
            dto.getId(),
            dto.getName(), 
            dto.getLogo(),
            dto.getFundado(),
            dto.getProvincia(),
            dto.getEstadio(),
            dto.getConstruido(),
            dto.getCapacidad(),
            dto.getCampprof(),
            dto.getCampamat(),
            dto.getCategoria());
        this.dao.update(Clubes);
    }

    public void eliminar(Long id) {
       this.dao.delete(id);
    }
}
 