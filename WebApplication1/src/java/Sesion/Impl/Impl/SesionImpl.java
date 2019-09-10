/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Impl.Impl;


import Sesion.Dao.Impl.SesionDaoImpl;
import Sesion.Dao.SesionDaoInterface;
import Sesion.Data.Menu;
import Sesion.Impl.SesionImplInterface;
import Sesion.Temp.SesionTemp;
import User.Dao.Impl.UserDao;
import User.Dao.UserDaoInterface;
import User.Data.User;
import java.util.ArrayList;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;

/**
 *
 * @author ricar
 */
public class SesionImpl implements SesionImplInterface{
    
    private UserDaoInterface dao;
    private SesionDaoInterface dao2;

    public SesionImpl() {
        dao = new UserDao();
        dao2 = new SesionDaoImpl();
    }

    
    
    @Override
    public User findUser(SesionTemp temp) { 
        
        return dao.findUser(Double.parseDouble(temp.getIdentificacion()));
        
    }

    @Override
    public String url(User user) {
        String url="";
        if(user.getRol().getRol().compareTo("Administrador")==0){
            url="faces/Administrador.xhtml?faces-redirect=true";
        }
        return url;
    }

    @Override
    public boolean validateUser(User user, SesionTemp temp) {
        if(user.getPasswordUser().compareTo(temp.getPassword())==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void loadMenu(Integer idRol, SesionTemp temp) {
       DefaultSubMenu firstSubmenu = new DefaultSubMenu("Menu");
       ArrayList<Menu> menu = dao2.loadMenu(idRol);
            for (Menu menu1 : menu) {
                DefaultMenuItem item = new DefaultMenuItem(menu1.getValue());
                item.setCommand(menu1.getComand());
                //item.setUrl("http://www.primefaces.org");
                 item.setIcon("pi pi-home");
                 firstSubmenu.addElement(item);
            }
                /* 
                DefaultMenuItem item1 = new DefaultMenuItem("Central");
                item1 = new DefaultMenuItem("Central");
                item1.setIcon("pi pi-save");
                item1.setCommand("#{directionBean.redirection('central')}");
                //item.setUpdate("messages");
                firstSubmenu.addElement(item1);
                    */
                temp.getMenu().addElement(firstSubmenu);

    }
    
}
