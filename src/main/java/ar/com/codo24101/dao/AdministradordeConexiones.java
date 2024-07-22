package ar.com.codo24101.dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class AdministradordeConexiones {
    
    public static Connection conectar(){
        String url ="jdbc:mysql://localhost:3307/afA_2024";
                                                //String url ="jdbc:mysql://localhost:3307//afa_2024?serverTimeZone=UTC&userSSL=false";
                                                //String url ="jdbc:mysql://%$:3307/%$?user=%$&password=%$";
                                                //Scanner sc = new Scanner(System.in);
                                                //System.out.println("Bienvenido a AFA");
                                                //System.out.println("ingrese su usuario");
                                                //String user = sc.next();
                                                //System.out.println("ingrese su contraseña");
                                                //String password = sc.nextLine();
                                                //sc.close();
                                                //String host = "127.0.0.1";
        String user ="root";
                                                //String user =p_user;
        String password ="root";
                                                //String password =p_password;
        String driver ="com.mysql.cj.jdbc.Driver";
        
                                                //int port = 3307;
                                                //String database ="afa_2024";
        
        Connection con = null;

        int retries = 3; // número de reintentos
        int retryDelay = 1000; // tiempo de espera entre reintentos (en milisegundos)
        for (int i = 0; i < retries; i++) {
        try {
            Class.forName(driver);
            //String url = String.format("jdbc:mysql://",host,database);
            con = DriverManager.getConnection(url,user,password);
            break; // conexión exitosa, salir del bucle
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            try {
                Thread.sleep(retryDelay); // esperar antes de reintentar
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            //System.err.println(e);
            //System.out.println("SQLException: " + e.getMessage());
            //System.out.println("SQLState: " + e.getSQLState());
            //System.out.println("VendorError: " + e.getErrorCode());
        }       
    
        }
        return con;
    }

    public static void main(String[] args) {
        //junit!: tph
        AdministradordeConexiones.conectar();}


    public static void desconectar(Connection connection) {
        try{
            connection.close();
        }catch(Exception e) {
            System.err.println(e);
        }
    }

}
