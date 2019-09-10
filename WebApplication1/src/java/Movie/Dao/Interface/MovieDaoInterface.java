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
    public boolean updateMovie();
    public boolean delteMoie();
}
