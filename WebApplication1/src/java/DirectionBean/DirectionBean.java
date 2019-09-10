/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DirectionBean;

import User.Data.User;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author ricar
 */
@ManagedBean(name="directionBean")
public class DirectionBean {
    
    public void redirection(String url) throws IOException{
        User user = (User)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(user.getRol().getRol().equals("Admin")){
            if(url.equals("user")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Admin/User.xhtml");
            }
            if(url.equals("movie")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Admin/Movie.xhtml");
            }
            if(url.equals("tvShow")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Admin/TvShow.xhtml");
            }
        }else if(user.getRol().getRol().equals("User")){
            if(url.equals("tvShow")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../User/TvShow.xhtml");
            }
            if(url.equals("movie")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../User/Movie.xhtml");
            }
        }
    }
    
}

