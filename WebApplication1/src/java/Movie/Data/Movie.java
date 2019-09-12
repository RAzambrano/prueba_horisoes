/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie.Data;

/**
 *
 * @author ricar
 */
public class Movie {
   private Integer idMovie;
   private String nameMovie; 
   private String descriptionMovie;
   private String managerMovie;
   private String starringMovie;
   //Almacena la imagen en bytes
   private byte[] image;
   //numero de vistas
   private Integer view;
   //Calificacion
   private Integer rating;
   private String type;

    public Integer getIdMovie() {
        return idMovie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDescriptionMovie() {
        return descriptionMovie;
    }

    public void setDescriptionMovie(String descriptionMovie) {
        this.descriptionMovie = descriptionMovie;
    }

    public String getManagerMovie() {
        return managerMovie;
    }

    public void setManagerMovie(String managerMovie) {
        this.managerMovie = managerMovie;
    }

    public String getStarringMovie() {
        return starringMovie;
    }

    public void setStarringMovie(String starringMovie) {
        this.starringMovie = starringMovie;
    }

    public Movie() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
   
    
   
   
}
