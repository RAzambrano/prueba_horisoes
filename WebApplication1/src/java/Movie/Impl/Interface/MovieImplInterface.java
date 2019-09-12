/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie.Impl.Interface;

import MovieTemp.MovieTemp;

/**
 *
 * @author ricar
 */
public interface MovieImplInterface {
    public void listMovie(MovieTemp temp);
    public boolean validateMovie(MovieTemp temp);
    public boolean addMovie(MovieTemp temp);
    public boolean updateMovie(MovieTemp temp);
    public boolean deletMovie(MovieTemp temp);
    public void copyMovie(MovieTemp temp);
    public String saveTempImage(String name, byte[] array);
    public void upView(MovieTemp temp);
    public void updateRating(MovieTemp temp);
    public void moreView(MovieTemp temp);
    public void moreRaiting(MovieTemp temp);
    public boolean multipleDelete(MovieTemp temp);
    public void loadMovie(MovieTemp temp);
    public void loadSerie(MovieTemp temp);
}
