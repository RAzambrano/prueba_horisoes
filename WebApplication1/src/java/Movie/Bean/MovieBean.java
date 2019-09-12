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
import com.sun.faces.renderkit.ApplicationObjectInputStream;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
    
     public void handleFileUpload(FileUploadEvent event) {
       
       temp.setFile(event.getFile());
       temp.setPahtImagen(impl.saveTempImage(event.getFile().getFileName(), event.getFile().getContents()));
       
    }
     
    public void loadImage(){
        temp.setPahtImagen(impl.saveTempImage("movie_"+temp.getSelect().getIdMovie()+".jpg", temp.getSelect().getImage()));
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
        loadImage();
    }
    
    public void updateMovie(){
        impl.updateMovie(temp);
        listMovie();
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
