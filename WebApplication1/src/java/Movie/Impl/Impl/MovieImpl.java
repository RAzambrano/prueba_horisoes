/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie.Impl.Impl;

import Movie.Dao.Impl.MovieDaoImpl;
import Movie.Dao.Interface.MovieDaoInterface;
import Movie.Data.Movie;
import Movie.Impl.Interface.MovieImplInterface;
import MovieTemp.MovieTemp;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class MovieImpl implements MovieImplInterface {

    private MovieDaoInterface dao;

    public MovieImpl() {
        dao = new MovieDaoImpl();
    }
    
    
    
    @Override
    public void listMovie(MovieTemp temp) {
        temp.setListMovie(dao.listMovie());
    }

    @Override
    public boolean validateMovie(MovieTemp temp) {
        boolean b =true;
        if(temp.getAux().getDescriptionMovie().equals("")||temp.getAux().getManagerMovie().equals("")||temp.getAux().getNameMovie().equals("")||temp.getAux().getStarringMovie().equals("")){
            b=false;
        }
        
        return b;
    }

    @Override
    public boolean addMovie(MovieTemp temp) {
        return dao.addMovie(temp.getAux());
    }

    @Override
    public boolean updateMovie(MovieTemp temp) {
        return dao.updateMovie(temp.getSelect(), temp.getIdMovie());
    }

    @Override
    public void copyMovie(MovieTemp temp) {
        temp.setIdMovie(temp.getSelect().getIdMovie());
    }    

    @Override
    public boolean deletMovie(MovieTemp temp) {
        return dao.delteMovie(temp.getSelect().getIdMovie());
    }
    
}
