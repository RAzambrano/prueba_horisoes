/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieTemp;

import Movie.Data.Movie;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class MovieTemp {
    
    private ArrayList<Movie> listMovie;
    private Movie aux;
    private Movie select;
    private Integer idMovie; 

    public MovieTemp() {
        listMovie= new ArrayList<Movie>();
        aux = new Movie();
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public Movie getAux() {
        return aux;
    }

    public void setAux(Movie aux) {
        this.aux = aux;
    }

    public Movie getSelect() {
        return select;
    }

    public void setSelect(Movie select) {
        this.select = select;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }
    
    
    
   
}
