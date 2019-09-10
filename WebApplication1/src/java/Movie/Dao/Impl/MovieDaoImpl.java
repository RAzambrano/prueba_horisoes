/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie.Dao.Impl;

import DataBase.Conection;
import Movie.Dao.Interface.MovieDaoInterface;
import Movie.Data.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class MovieDaoImpl implements MovieDaoInterface {

    
    /**
     * Este metodo permite agregar una nueva pelicula
     * @param movie
     * @return 
     */
    @Override
    public boolean addMovie(Movie movie) {
        boolean b = false;
        PreparedStatement statement = null;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
        String query =  "INSERT INTO movie ( name_movie, description_movie, starring_movie, manager_movie) VALUES ( ?, ?, ?, ?);";
        try {
            statement=conecting.prepareStatement(query);
            statement.setString(1, movie.getNameMovie());
            statement.setString(2, movie.getDescriptionMovie());
            statement.setString(3, movie.getStarringMovie());
            statement.setString(4, movie.getManagerMovie());
            statement.execute();
            b=true;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conection.close();
            return b;
        }
       
    }

    @Override
    public ArrayList<Movie> listMovie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateMovie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delteMoie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
