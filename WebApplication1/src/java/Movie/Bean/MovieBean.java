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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;


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
    /**
     * Carga la imagen que se sube al fileUpload
     * @param event 
     */
     public void handleFileUpload(FileUploadEvent event) {
       
       temp.setFile(event.getFile());
       temp.setPahtImagen(impl.saveTempImage(event.getFile().getFileName(), event.getFile().getContents()));
       
    }
     /**
      * Permite cargar una iage de los objetos temporales
      * @param i 
      */
    public void loadImage(Integer i){
        temp.setPahtImagen(impl.saveTempImage("movie_"+temp.getSelect().getIdMovie()+".jpg", temp.getSelect().getImage()));
        if(i==1){
            upView();
        }
    }
      /**
       * Addiciona una nueva pelicula
       */
    public void addMovie() {
              
        if(impl.validateMovie(temp)){
           if (impl.addMovie(temp)){
             temp.setAux(new Movie() );
             temp.setPahtImagen("");
             listMovie();
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción completada",  "Registrado realizado con éxito  " + message) );
           }else{
           FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción incompleta",  "Error al realizar el registro  " + message) );
           }
        
        }
    }
    /**
     * Carga solo las peliculas
     */
    public void loadMovie(){
        impl.loadMovie(temp);
    }
    /**
     * Carga solo series
     */
    public void loadSerie(){
        impl.loadSerie(temp);
    }
    
    
    public void multipleDelete(){
        impl.multipleDelete(temp);
    }
    
    public void copyMovie(){
        
        impl.copyMovie(temp);
        loadImage(0);
    }
    
    /**
     * Actualiza la informacion de una pelicula
     */
    public void updateMovie(){
        if(impl.updateMovie(temp)){
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción completada",  "Modificación realizada con éxito  " + message) );
        }else{
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción incompleta",  "Error al modificar " + message) );
            }
        temp.setPahtImagen("");
        listMovie();
    }
    
    
    /**
     * Aumenta el cotador de vistas
     */
    public void upView(){
        impl.upView(temp);
    }
    
    /**
     * restorna las pelicula y series mas vistas
     */
    public void moreView(){
        impl.moreView(temp);
    }
    
    /**
     * retorna las pelicula de mejor calificacion
     */
    public void moreRiting(){
        impl.moreRaiting(temp);
    }
    
    public void changeSelection(){
       temp.setConfigSelection(!temp.getConfigSelection());
    }
    
    public void rating(RateEvent rateEvent) {
        impl.updateRating(temp);
    }
    
    public void deleteMovie(){
       if(impl.deletMovie(temp)){
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción completada",  "Registrado eliminado con éxito  " + message) );
       }else{
           FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción incompleta",  "error eliminando Registro " + message) );
       }
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
