/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Dao;

import Sesion.Data.Menu;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public interface SesionDaoInterface {
    
    public ArrayList<Menu> loadMenu(Integer idRol);
}
