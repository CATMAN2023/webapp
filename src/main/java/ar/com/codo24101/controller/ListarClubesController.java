package ar.com.codo24101.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.domain.Clubes;
import ar.com.codo24101.service.ClubesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarClubesController")
public class ListarClubesController extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        //1 crear el service
        ClubesService service = new ClubesService();

        //2 ejecuto el metodo
        ArrayList<Clubes> listado = service.listarClubes();

        ObjectMapper mapper = new ObjectMapper();

        //convierto Objecto java a json string
		//ahora respondo al front: json, Convirtiendo el nuevo Clientes a json
		String clubesJSON = mapper.writeValueAsString(listado);
        
        //mostrar por consola|enviar al frontend
        resp.getWriter().println(clubesJSON);

    }
}