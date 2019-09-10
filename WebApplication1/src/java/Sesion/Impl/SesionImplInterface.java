/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Impl;

import Sesion.Temp.SesionTemp;
import User.Data.User;

/**
 *
 * @author ricar
 */
public interface SesionImplInterface {
    public boolean validateUser(User user, SesionTemp temp);
    public String url(User user);
    public User findUser(SesionTemp temp);
    public void loadMenu(Integer idRol, SesionTemp temp);
    
}
