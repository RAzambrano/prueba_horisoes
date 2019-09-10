/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Bean;


import User.Data.User;
import User.Impl.Impl.UserImpl;
import User.Temp.UserTemp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import User.Impl.UserImplInterface;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
@ViewScoped
@ManagedBean(name = "userBean")
public class UserBean {
    
    private UserTemp temp;
    private UserImplInterface impl;

    public UserBean() {
        temp= new UserTemp();
        impl= new UserImpl();
        listUsers();
    }
    
    
    public void addUser() {
        if(impl.validatePassword(temp)){
           if (impl.addUser(temp)){
            
           }else{
           
           }
        
        }
    }
    
    public void updateUser(){
        impl.updateUser(temp);
    }
    
    public void copyUser(){
        
        impl.copyUser(temp);
    }
    
    public void deleteUser(){
        impl.deletaUser(temp);
    }
    
    public void listUsers(){
         impl.listUsers(temp);
         
    }

    public void changePassword(){
        impl.changePassgord(temp);
    }
    
    public UserTemp getTemp() {
        return temp;
    }

    public void setTemp(UserTemp temp) {
        this.temp = temp;
    }

    public UserImplInterface getImpl() {
        return impl;
    }

    public void setImpl(UserImplInterface impl) {
        this.impl = impl;
    }
    
    
    
    
    
    
}
