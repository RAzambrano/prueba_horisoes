/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie.Dao.Interface;

import Movie.Data.Movie;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public interface MovieDaoInterface {
    public boolean addMovie(Movie movie);
    public ArrayList<Movie> listMovie();
    public boolean updateMovie(Movie movie, Integer idMovie);
    public boolean delteMovie(Integer idMovie);
    public void upView(Integer idMovie, Integer view);
    public void updateRqating(Integer idMovie, Integer rating);
    public ArrayList<Movie> moreView();
    public ArrayList<Movie> moreRating();
    public ArrayList<Movie> loadMovie();
    public ArrayList<Movie> loadSerie();
    
}
