/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieTemp;

import Movie.Data.Movie;
import java.util.ArrayList;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ricar
 */
public class MovieTemp {
    
    private ArrayList<Movie> listMovie;
    private Movie aux;
    private Movie select;
    private Integer idMovie; 
    private UploadedFile file;
    StreamedContent imagen ;
    private String pahtImagen;

    public MovieTemp() {
        listMovie= new ArrayList<Movie>();
        aux = new Movie();
        imagen = null;
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
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public StreamedContent getImagen() {
        return imagen;
    }

    public void setImagen(StreamedContent imagen) {
        this.imagen = imagen;
    }

    public void setPahtImagen(String pahtImagen) {
        this.pahtImagen = pahtImagen;
    }

    public String getPahtImagen() {
        return pahtImagen;
    }
    
    
    
   
}
