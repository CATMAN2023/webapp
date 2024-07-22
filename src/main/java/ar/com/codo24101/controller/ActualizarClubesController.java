package ar.com.codo24101.controller;

import ar.com.codo24101.domain.Clubes;
import ar.com.codo24101.dto.ClubesDTO;
import ar.com.codo24101.service.ClubesService;

public class ActualizarClubesController {

    public static void main(String[] args) {
        ClubesService service = new ClubesService();

        Clubes clubes  = service.listarClubes().get(0);

        System.out.println("Original:");
        System.out.println(clubes);

        //le cambio los datos
        //Clubes.setApellido("nuevo apellido");
        clubes.setName("nuevo nombre");

        ClubesDTO clubesToUpdateDTO = new ClubesDTO(
            clubes.getId(),
            clubes.getName(), 
            clubes.getLogo(),
            clubes.getFundado(),
            clubes.getProvincia(),
            clubes.getEstadio(),
            clubes.getConstruido(),
            clubes.getCapacidad(),
            clubes.getCampprof(),
            clubes.getCampamat(),
            clubes.getCategoria());


        service.actualizar(clubesToUpdateDTO);

        Clubes actualizado = service.obtener(clubes.getId());
        System.out.println(actualizado);
    }
}