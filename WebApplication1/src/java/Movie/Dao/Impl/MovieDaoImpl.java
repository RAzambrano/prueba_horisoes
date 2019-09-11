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
import java.sql.ResultSet;
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
        String query =  "INSERT INTO horisoes_peliculas.movie ( name_movie, description_movie, starring_movie, manager_movie) VALUES ( ?, ?, ?, ?);";
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
       
    ArrayList<Movie> movies = new ArrayList<Movie>();
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
        java.sql.Statement st;
         try {
             String query="select * from horisoes_peliculas.movie";
             st = conecting.createStatement();
             ResultSet result = st.executeQuery(query);
             while(result.next()){
                 Movie movie = new Movie();
                 movie.setNameMovie(result.getString("name_movie"));
                 movie.setDescriptionMovie(result.getString("description_movie"));
                 movie.setStarringMovie(result.getString("starring_movie"));
                 movie.setManagerMovie(result.getString("manager_movie"));
                 movie.setIdMovie(result.getInt("id_movie"));
                 
                 movies.add(movie);
                
             }
            conection.close();
             return movies;
             
         } catch (SQLException ex) {
             Logger.getLogger(MovieDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
        return movies;
    }

    @Override
    public boolean updateMovie(Movie movie, Integer idMovie) {
        boolean b = false;
        PreparedStatement prepareSentence;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
         
             String query ="UPDATE horisoes_peliculas.movie\n" +
"	SET name_movie=?, description_movie=?, starring_movie=?, manager_movie=? \n" +
"	WHERE id_movie = ?";
        try {
            prepareSentence= conecting.prepareStatement(query);
            prepareSentence.setString(1, movie.getNameMovie());
             prepareSentence.setString(2, movie.getDescriptionMovie());
             prepareSentence.setString(3, movie.getStarringMovie());
             prepareSentence.setString(4, movie.getManagerMovie());
             prepareSentence.setInt(5,idMovie);
             prepareSentence.execute();
             b=true;
        } catch (SQLException ex) {
            Logger.getLogger(MovieDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conection.close();
            return b;
        }
             
        
    }

    

    @Override
    public boolean delteMovie(Integer idMovie) {
        boolean b = false;
        PreparedStatement prepareSentence;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
       
         try {
            String query="DELETE FROM horisoes_peliculas.movie \n" +
                         "WHERE id_movie = ?;";
            prepareSentence = conecting.prepareStatement(query);
            prepareSentence.setDouble(1, idMovie);
            prepareSentence.execute();
            b=true;
           
         } catch (SQLException ex) {
             Logger.getLogger(MovieDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             conection.close();
             return b;
         }
        
    }
    
}
