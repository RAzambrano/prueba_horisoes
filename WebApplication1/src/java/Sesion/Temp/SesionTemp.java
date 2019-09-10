/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Temp;

import User.Data.User;
import org.primefaces.model.menu.DefaultMenuModel;

/**
 *
 * @author ricar
 */
public class SesionTemp {
    
    private String identificacion;
    private String password;
    private DefaultMenuModel menu;
    //private User sesion;

    public SesionTemp() {
        menu = new DefaultMenuModel();
    }

    
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DefaultMenuModel getMenu() {
        return menu;
    }

   
    
    
    
}
