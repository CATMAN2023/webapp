package ar.com.codo24101.controller;

import java.io.IOException;

import ar.com.codo24101.service.ClubesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarClubesController")
public class EliminarClubesController extends HttpServlet{

    //get
    //post
    //put
    //delete
    @Override
    protected void doDelete(
        HttpServletRequest req,//aca viene lo del front
        HttpServletResponse resp//aca se manda al front
    ) throws ServletException, IOException {

        //capturo el id que viene desde el front
        String id = req.getParameter("id");

        ClubesService service = new ClubesService();

        Long idLong = Long.parseLong(id);

        service.eliminar(idLong);

        resp.setStatus(HttpServletResponse.SC_OK);
    }   
}