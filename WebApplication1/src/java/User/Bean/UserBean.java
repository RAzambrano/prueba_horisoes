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
import User.ImplInterface.UserImplInterface;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;

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
        String mensaje="";
        if(impl.validatePassword(temp)){
           if (impl.addUser(temp)){
             temp.setAux(new User() );
             impl.cleanPassword(temp);
             
             listUsers();
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción completada",  "Usuario Registrado con éxito  " + message) );
           }else{
            mensaje= "Error creando el usuario";
           }
        
        }else{
            mensaje= "Contraseña no coincide";
            }
        
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Acción Icompleta",  mensaje  + message) );
    }
    
    public void updateUser(){
        impl.updateUser(temp);
    }
    
    public void copyUser(){
        
        impl.copyUser(temp);
    }
    
    public void deleteUser(){
        impl.deletaUser(temp);
         listUsers();
    }
    
    public void listUsers(){
         impl.listUsers(temp);
         
    }

    public void changePassword(){
        impl.changePassgord(temp);
        impl.cleanPassword(temp);
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
