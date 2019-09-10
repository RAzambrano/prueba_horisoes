/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao;

import User.Data.User;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public interface UserDaoInterface {
    
    public boolean addUser(User user);
    public User findUser(double identification);
    public ArrayList<User> listUser();
    public boolean updateUser(User user, Double identification);
    public boolean deleteUser(Double identification);
    public boolean changePassword(Double identification, String password);
}
