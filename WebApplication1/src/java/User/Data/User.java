/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Data;

/**
 *
 * @author ricar
 */
public class User {
    private String nameUser;
    private Double identificationUser;
    private String passwordUser;
    private RolUser rol;

    public User() {
    }    
    
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Double getIdentificationUser() {
        return identificationUser;
    }

    public void setIdentificationUser(Double identificationUser) {
        this.identificationUser = identificationUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public RolUser getRol() {
        return rol;
    }

    public void setRol(RolUser rol) {
        this.rol = rol;
    }
    
    
}
