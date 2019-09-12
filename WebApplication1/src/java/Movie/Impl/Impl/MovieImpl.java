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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

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
    byte[] contents = temp.getFile().getContents();
    temp.getAux().setImage(contents);
        return dao.addMovie(temp.getAux());
    }

    @Override
    public boolean updateMovie(MovieTemp temp) {
        temp.getSelect().setImage(temp.getFile().getContents());
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

    
    /**
     * Metodo que Permite crear imeagenes de manera temporal
     * @param temp 
     */
    @Override
    public String saveTempImage( String name, byte[] array) {
        String route=null;
        ServletContext servletContex = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContex.getRealPath("")+File.separatorChar+"Resources"+File.separatorChar+"Temp"+File.separatorChar+"Img"+File.separatorChar+name;
        
        File file = null;
        InputStream input = null; 
        
        try {
            file = new File(path);
            input = new ByteArrayInputStream(array);
            FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
            
            int i =0;
            while((i=input.read())>=0){
                out.write(i);
            }
            out.flush();
            out.close();
            route = "../../Resources/Temp/Img/"+name;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return route;
    }
    
}
