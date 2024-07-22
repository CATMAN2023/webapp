package ar.com.codo24101.controller;

import ar.com.codo24101.domain.Clubes;
import ar.com.codo24101.service.ClubesService;

public class ObtenerClubesController {

    public static void main(String[] args) {

        Long idClubes = 1l;

        ClubesService service = new ClubesService();

        Clubes clubes = service.obtener(idClubes);

        //mapper > Movie > MovieDTO: TPH
        System.out.println(clubes);
    }
}