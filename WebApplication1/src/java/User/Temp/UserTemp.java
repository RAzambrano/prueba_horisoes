/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Temp;

import User.Data.User;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class UserTemp {
    private ArrayList<User> users;
    private User select;
    private User aux ;
    private String password;
    private String validatePassword;
    private String oldPassword;
    private double identificacion;
    
    public UserTemp() {
        aux = new User();
        select = new User();
    }

    public User getAux() {
        return aux;
    }

    public void setAux(User aux) {
        this.aux = aux;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidatePassword() {
        return validatePassword;
    }

    public void setValidatePassword(String validatePassword) {
        this.validatePassword = validatePassword;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getSelect() {
        return select;
    }

    public void setSelect(User select) {
        this.select = select;
    }

    public double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    
    
     
    
    
    
}
