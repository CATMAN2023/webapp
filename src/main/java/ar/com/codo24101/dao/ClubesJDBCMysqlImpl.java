package ar.com.codo24101.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24101.domain.Clubes;

public class ClubesJDBCMysqlImpl implements ClubesDAO{

    @Override
    public Clubes getById(Long id) {
        String sql = "SELECT * FROM clubes WHERE id = "+id;

        Clubes clubes = null;
        Connection connection = null;
        try{
            //aca va la logica
            //connection = AdministradorDeConexiones.conectar();
            connection = AdministradordeConexiones.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            if(resultset.next()) {
                Long Id = resultset.getLong(1);
                String name = resultset.getString(2);
                String logo = resultset.getString(3);
                Long fundado = resultset.getLong(4);
                String provincia = resultset.getString(5);
                String estadio = resultset.getString(6);
                Long construido = resultset.getLong(7);
                Long capacidad = resultset.getLong(8);
                Long campprof = resultset.getLong(9);
                Long campamat = resultset.getLong(10);
                String categoria = resultset.getString(11);

                clubes = new Clubes(Id, name, logo, fundado, provincia, estadio,construido,capacidad,campprof,campamat,categoria);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradordeConexiones.desconectar(connection);
        }

        return clubes;
    }

    public void create(Clubes clubesDto) {
        String sql = "INSERT INTO clubes (name, logo, fundado, provincia,estadio,construido,capacidad,campprof,campamat) values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = AdministradordeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, clubesDto.getName());
            pst.setString(2, clubesDto.getLogo());
            pst.setLong(3, clubesDto.getFundado());
            pst.setString(4, clubesDto.getProvincia());
            pst.setString(5, clubesDto.getEstadio());
            pst.setLong(6, clubesDto.getConstruido());
            pst.setLong(7, clubesDto.getCapacidad());
            pst.setLong(8, clubesDto.getCampprof());
            pst.setLong(9, clubesDto.getCampamat());
            pst.setString(10, clubesDto.getCategoria());
            pst.executeUpdate();
            if(pst.getUpdateCount() > 0) {
                System.out.println("Insert ok");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradordeConexiones.desconectar(connection);
        }        
    }

    @Override
    public ArrayList<Clubes> findAll() {
        String sql = "SELECT * FROM clubes"; //ver LIMIT y Offset

        ArrayList<Clubes> listaDeClubes = new ArrayList<>();
        Connection connection = null;
        try{
            //aca va la logica
            connection = AdministradordeConexiones.conectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()) {
                Long Id = resultset.getLong(1);
                String name = resultset.getString(2);
                String logo = resultset.getString(3);
                Long fundado = resultset.getLong(4);
                String provincia = resultset.getString(5);
                String estadio = resultset.getString(6);
                Long construido = resultset.getLong(7);
                Long capacidad = resultset.getLong(8);
                Long campprof = resultset.getLong(9);
                Long campamat = resultset.getLong(10);
                String categoria = resultset.getString(11);
                Clubes unClub = new Clubes(Id, name, logo, fundado, provincia, estadio,construido,capacidad,campprof,campamat,categoria);
                listaDeClubes.add(unClub);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradordeConexiones.desconectar(connection);
        }

        return listaDeClubes;
    }

    @Override
    public void update(Clubes clubes) {           

        //tph: ver como quitar esa , del final!

        String sql = "UPDATE Clubes set name=?, logo=?, fundado=?, provincia=?, estadio=?, construido=?, capacidad=?, campprof=?, campamat=?, categoria=? WHERE id=?";

        Connection connection = AdministradordeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, clubes.getId());
            pst.setString(2, clubes.getName());
            pst.setString(3, clubes.getLogo());
            pst.setLong(4, clubes.getFundado());
            pst.setString(5, clubes.getProvincia());
            pst.setString(6, clubes.getEstadio());
            pst.setLong(7, clubes.getConstruido());
            pst.setLong(8, clubes.getCapacidad());
            pst.setLong(9, clubes.getCampprof());
            pst.setLong(10, clubes.getCampamat());
            pst.setString(11, clubes.getCategoria());

            pst.executeUpdate();
            if(pst.getUpdateCount() > 0) {
                System.out.println("update ok");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradordeConexiones.desconectar(connection);
        }    
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM clubes where id = ?";

        Connection connection = AdministradordeConexiones.conectar();

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);

            pst.executeUpdate();
            if(pst.getUpdateCount() == 0) {
                throw new RuntimeException("No se pudo eliminar el registro");
            }
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            AdministradordeConexiones.desconectar(connection);
        } 
    }
}