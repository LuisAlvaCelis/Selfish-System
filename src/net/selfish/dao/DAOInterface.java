package net.selfish.dao;

import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import net.selfish.mvc.model.ModelProductMenu;
import net.selfish.mvc.model.ModelProductDrink;
import net.selfish.mvc.model.ModelRegisterOrder;
import net.selfish.mvc.model.ModelRegisterUser;

public interface DAOInterface{
    
    public boolean verifyDataBase();
    public boolean createDataBase();
    public boolean createTables(int num);
    
    public boolean insertDataTableRegisterOrders(ModelRegisterOrder mro,String id_order);
    public boolean updateDataTableRegisterOrders(int num,ModelRegisterOrder mro);
    public boolean removeRowTableRegisterOrders(ModelRegisterOrder mro);
    
    public boolean insertDataTableRegisterMenu(ModelProductMenu mp);
    public boolean updateDataTableRegisterMenu(int num,ModelProductMenu mp);
    public boolean removeRowTableRegisterMenu(ModelProductMenu mp);
    
    public boolean insertDataTableRegisterUsers(ModelRegisterUser mru);
    public boolean updateDataTableRegisterUsers(int num,ModelRegisterUser mru);
    public boolean removeRowTableRegisterUsers(ModelRegisterUser mru);
    
    public boolean insertDataTableRegisterDrinks(ModelProductDrink mpd);
    public boolean updateDataTableRegisterDrinks(int num,ModelProductDrink mpd);
    public boolean removeRowTableRegisterDrinks(ModelProductDrink mpd);
    
    public boolean insertDataTableRegisterCategoryDrinks(String category,String observation);
    public boolean updateDataTableRegisterCategoryDrinks(String category,String observation);
    public boolean removeRowTableRegisterCategoryDrinks(String category);
    
    public boolean insertDataTableRegisterCategoryMenu(String category,String observation);
    public boolean updateDataTableRegisterCategoryMenu(String category,String observation);
    public boolean removeRowTableRegisterCategoryMenu(String category);
    
    public HashMap<String,String> getAccount(String account);
    public List<String> getListCategoryDrinks();
    public List<String> getListCategoryMenus();
    public String getProductByID(String id);
    public int getRolAccount(String account);
    public int getCantDrinksByID(String id);
    public boolean verifyCategoryDrinksExists(String category);
    public boolean verifyCategoryMenuExists(String category);
    public boolean verifyDrinkIfExistsByID(String id);
    public boolean verifyMenuIfExistsByID(String id);
    public ImageIcon getImageDrinkByID(String id);
    public ImageIcon getImageMenuByID(String id);
    
    public void showDataFrame(int num,JTable table,String search);
    
    public void printReportDrinks();
    public void printReportUsers();
    public void printReportMenus();
    public void printReportRegisterOrder(String costTotal,String id_order);
}
