/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Impl;

import User.Data.User;
import User.Temp.UserTemp;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public interface UserImplInterface {
    
    public boolean addUser(UserTemp temp);
    public boolean validatePassword (UserTemp temp);
    public void listUsers(UserTemp temp);
    public boolean updateUser(UserTemp temp);
    public void copyUser(UserTemp temp);
    public boolean deletaUser(UserTemp temp);
    public boolean changePassgord(UserTemp temp);
}
