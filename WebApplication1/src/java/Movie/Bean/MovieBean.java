/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie.Bean;

import Movie.Data.Movie;
import Movie.Impl.Impl.MovieImpl;
import Movie.Impl.Interface.MovieImplInterface;
import MovieTemp.MovieTemp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ricar
 */
@ViewScoped
@ManagedBean(name="movieBean")
public class MovieBean {

    private MovieTemp temp;
    private MovieImplInterface impl;
    
    public MovieBean() {
        temp = new MovieTemp();
        impl= new MovieImpl();
        listMovie();
    }
    
    public void addMovie() {
        if(impl.validateMovie(temp)){
           if (impl.addMovie(temp)){
             temp.setAux(new Movie() );
             
             listMovie();
           }else{
           
           }
        
        }
    }
    
    public void copyMovie(){
        
        impl.copyMovie(temp);
    }
    
    public void updateMovie(){
        impl.updateMovie(temp);
    }
    
    public void deleteMovie(){
        impl.deletMovie(temp);
        listMovie();
    }
    
    public void listMovie(){
        impl.listMovie(temp);
    }

    public MovieTemp getTemp() {
        return temp;
    }

    public MovieImplInterface getImpl() {
        return impl;
    }
    
    
    
}
