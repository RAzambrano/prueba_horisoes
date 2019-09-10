/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao.Impl;

import DataBase.Conection;
import User.Dao.UserDaoInterface;
import User.Data.RolUser;
import User.Data.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class UserDao implements UserDaoInterface {
    
     
    /**Este metodo permite agregar un usuario, retorna true si la transacion es realizada con exito, false si ocurre algin error
     * 
     * @param user
     * @return 
     */
    @Override
    public boolean addUser(User user){
        boolean b=true;
        PreparedStatement prepareSentence = null;
        Conection conection = new Conection();
        
        try {
            conection.conecting();
            Connection conecting = conection.getConector();
            

            String query = "insert into horisoes_peliculas.user (identification_user, name_user, password_user, id_rol)\n" +
                            "VALUES ("+user.getIdentificationUser()+", '"+user.getNameUser()+"' , '"+user.getPasswordUser()+"' ,"+2+")";
         
             prepareSentence = conecting.prepareStatement(query);
             prepareSentence.execute();
             conection.close();
         } catch (SQLException ex) {
             b=false;
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
       return b;
    }
    /**Este metodo devuelve un usuario 
     * 
     * @param identification
     * @return 
     */
    @Override
    public User findUser(double identification) {
            User user = null;
            PreparedStatement prepareSentence = null;
            Conection conection = new Conection();
            conection.conecting();
            Connection conecting = conection.getConector();
            int idRol=0;
            String query = "select * from horisoes_peliculas.user where identification_user = ? ";
         try {
             prepareSentence = conecting.prepareStatement(query);
             prepareSentence.setDouble(1, identification);
             ResultSet result = prepareSentence.executeQuery();
             User aux = new User();
             while(result.next()){
                 aux.setIdentificationUser(result.getDouble("identification_user"));
                 aux.setNameUser(result.getString("name_user"));
                 aux.setPasswordUser(result.getString("password_user"));
                 idRol= result.getInt("id_rol");
                 aux.setRol(findRoll(idRol));
                
             }
            conection.close();
             user=aux;
             user.setRol(findRoll(idRol));
             return user;
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
             return user;
         }
         
        }
    
    public RolUser findRoll(int id){
        PreparedStatement prepareSentence = null;
        Conection conection = new Conection();
        conection.conecting();
        RolUser rol = new RolUser();
        Connection conecting = conection.getConector();
        String query = "select * from horisoes_peliculas.rol where id_rol = "+id;
         try {
             java.sql.Statement st = conecting.createStatement();
             //prepareSentence = conector.prepareStatement(query);
             //prepareSentence.set(1, id);
             ResultSet result = st.executeQuery(query);//prepareSentence.executeQuery(query);
             while (result.next()){
                 rol.setIdRol(result.getInt("id_rol"));
                 rol.setRol(result.getString("rol"));
             }
            conection.close();
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rol;
    }

    @Override
    public ArrayList<User> listUser() {
        ArrayList<User> users = new ArrayList<User>();
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
        java.sql.Statement st;
         try {
             String query="select * from horisoes_peliculas.user";
             st = conecting.createStatement();
             ResultSet result = st.executeQuery(query);
             while(result.next()){
                 User user = new User();
                 user.setIdentificationUser(result.getDouble("identification_user"));
                 user.setNameUser(result.getString("name_user"));
                 int idRol= result.getInt("id_rol");
                 user.setRol(findRoll(idRol));
                 users.add(user);
             }
            conection.close();
             return users;
             
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
        return users;
    }

    @Override
    public boolean updateUser(User user, Double identification) {
        
        boolean b = false;
        PreparedStatement prepareSentence;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
         try {
             String query ="UPDATE horisoes_peliculas.user\n" +
                            "SET identification_user= ?, name_user = ?\n" +
                            "WHERE identification_user = ?";
             prepareSentence= conecting.prepareStatement(query);
             prepareSentence.setDouble(1, user.getIdentificationUser());
             prepareSentence.setString(2, user.getNameUser());
             prepareSentence.setDouble(3, identification);
           
             prepareSentence.execute();
             b=true;
            conection.close();
             
        } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
              return b;
         }
        
       
    }

    @Override
    public boolean deleteUser(Double identification) {
        boolean b = false;
        PreparedStatement prepareSentence;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
       
         try {
            String query="DELETE FROM user\n" +
                         "WHERE identification_user = ?;";
            prepareSentence = conecting.prepareStatement(query);
            prepareSentence.setDouble(1, identification);
            prepareSentence.executeQuery();
            b=true;
           conection.close();
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             return b;
         }
        
        
        
    }

    @Override
    public boolean changePassword(Double identification, String password) {
        PreparedStatement prepareSentence = null;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector();
        
       
         try {
              String query = "update user "
                + "SET password_user = ? "
                + "where identification_user = ?";
             prepareSentence=conecting.prepareStatement(query);
             prepareSentence.setString(1, password);
             prepareSentence.setDouble(2, identification);
             prepareSentence.execute();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
        
    }
    
}
