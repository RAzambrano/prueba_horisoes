/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Bean;

import Sesion.Data.Menu;
import Sesion.Impl.Impl.SesionImpl;
import Sesion.Impl.SesionImplInterface;
import Sesion.Temp.SesionTemp;
import User.Data.User;
import User.Impl.Impl.UserImpl;
import User.Impl.UserImplInterface;
import User.Temp.UserTemp;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author ricar
 */
@SessionScoped
@ManagedBean(name = "sesionBean")
public class SesionBean {
    
    private SesionTemp temp;
    private SesionImplInterface impl;
    private UserImplInterface implUser;
    private UserTemp tempUser;
    
    public SesionBean() {
        temp = new SesionTemp();
        impl = new SesionImpl();
        implUser = new UserImpl();
        tempUser = new UserTemp();
    }
    
    
    public String validateUser(){
        User user = impl.findUser(temp);
        if(impl.validateUser(user, temp)){
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
              if(user.getRol().getRol().equals("Admin")){
                  impl.loadMenu(user.getRol().getIdRol(), temp);
                  return "faces/Admin/User.xhtml?faces-redirect=true";
              }else if (user.getRol().getRol().equals("User")){
                  impl.loadMenu(user.getRol().getIdRol(), temp);
                  return "faces/User/Movie.xhtml?faces-redirect=true";
              }else {
                    return"faces/index.xhtml?faces-redirect=false";
                    }
              }
        else {
            return"faces/index.xhtml?faces-redirect=false";
        }
        
    }
    
     public String addUser() {
        if(implUser.validatePassword(tempUser)){
           if (implUser.addUser(tempUser)){
               temp.setIdentificacion(tempUser.getAux().getIdentificationUser().toString());
               temp.setPassword(tempUser.getAux().getPasswordUser());
               
           }
        }
         return validateUser();
    }

    public SesionTemp getTemp() {
        return temp;
    }

    public UserTemp getTempUser() {
        return tempUser;
    }
    
    
    
    public String optenerUsuario(){
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return user.getNameUser();
    }
    
    public void cerrarSesion() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        
    }
    
    public void validateSesion(String pagina) throws IOException{
        User user = (User)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(user!=null){
        
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        }
    } 
}
