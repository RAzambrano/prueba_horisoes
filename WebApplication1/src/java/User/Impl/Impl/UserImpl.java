/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Impl.Impl;

import User.Dao.Impl.UserDao;
import User.Dao.UserDaoInterface;
import User.Data.User;
import User.Impl.UserImplInterface;
import User.Temp.UserTemp;

/**
 *
 * @author ricar
 */
public class UserImpl implements UserImplInterface{

    private UserDaoInterface dao;

    public UserImpl() {
        dao = new UserDao();
    }
       
    
    @Override
    public boolean addUser(UserTemp temp) {
           return dao.addUser(temp.getAux());
        
        }

    @Override
    public boolean validatePassword(UserTemp temp) {
         if(temp.getPassword().equals(temp.getValidatePassword())){
            temp.getAux().setPasswordUser(temp.getPassword());
            return true;
         }else{
             return false;
         }
    }

    @Override
    public void listUsers(UserTemp temp) {
        temp.setUsers(dao.listUser());
    }

    @Override
    public boolean updateUser(UserTemp temp) {
        return dao.updateUser(temp.getSelect(),temp.getIdentificacion() );
    }

    @Override
    public void copyUser(UserTemp temp) {
       
        temp.setIdentificacion(temp.getSelect().getIdentificationUser());
       
    }

    @Override
    public boolean deletaUser(UserTemp temp) {
        return dao.deleteUser(temp.getSelect().getIdentificationUser());
    }

    @Override
    public boolean changePassgord(UserTemp temp) {
        boolean b = true;
        User user = dao.findUser(temp.getIdentificacion());
        if(user.getPasswordUser().equals(temp.getOldPassword())){
            if(validatePassword(temp)){
                return dao.changePassword(temp.getIdentificacion(), temp.getPassword());
            }else{
                b=false;
            }
        }else{
            b = false;
        }
        return b;
    }
    
    
    
}
