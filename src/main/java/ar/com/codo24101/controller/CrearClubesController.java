package ar.com.codo24101.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.dto.ClubesDTO;
import ar.com.codo24101.service.ClubesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CrearClubesController")
public class CrearClubesController extends HttpServlet {

    protected void doPost(
        HttpServletRequest req,//aca viene todo desde el front
        HttpServletResponse resp//aca respondemos al front
    ) throws ServletException, IOException {

        //el json que viene, se atrapa así:
        String json = req.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
            
        System.out.println(json);

        //en java manejo objetos
        //usando jackson: pasamos de texto a objetos
        ObjectMapper mapper = new ObjectMapper();

        ClubesDTO clubesDto = mapper.readValue(req.getReader(), ClubesDTO.class);

        ClubesService service = new ClubesService();

        System.out.println(clubesDto);

        service.crear(clubesDto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}