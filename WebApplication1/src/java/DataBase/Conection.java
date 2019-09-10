/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class Conection {
    
    private Connection conector;
   
    
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USUARIO="horisoes";
    private final String CONTRASENA="horisoes";
    
    
    
    public Conection() {
    }
    
    public void conectar() {
        
        try {   
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
       // Class.forName("com.mysql.jdbc.Driver");
        try {
            this.conector= DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Connection true");
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    } 

    public Connection getConector() {
        return conector;
    }
    
}
