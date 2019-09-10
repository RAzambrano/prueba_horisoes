/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Dao.Impl;

import DataBase.Conection;
import Sesion.Dao.SesionDaoInterface;
import Sesion.Data.Menu;
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
public class SesionDaoImpl implements SesionDaoInterface {

    
    
    @Override
    public ArrayList<Menu> loadMenu(Integer idRol) {
        
        ArrayList<Menu> menu = new ArrayList<>();
        PreparedStatement prepareSentence = null;
        Conection conection = new Conection();
        conection.conecting();
        Connection conecting = conection.getConector(); 
        
        String query= "SELECT me.comand_menu, me.text_menu from horisoes_peliculas.menu as me inner join horisoes_peliculas.rol_menu as rol on (rol.id_menu = me.id_menu) where id_rol=?";
        
        try {
            prepareSentence = conecting.prepareStatement(query);
            prepareSentence.setInt(1, idRol);
            ResultSet result = prepareSentence.executeQuery();
            while(result.next()){
                Menu aux = new Menu();
                aux.setComand(result.getString("comand_menu"));
                aux.setValue(result.getString("text_menu"));
                //aux.setIcon(result.getString("icono_menu"));
                
                menu.add(aux);
            }
            conection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SesionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return menu;
    }
    
}
