package net.selfish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import net.selfish.utils.CreateFile;

public class ConnectionSQL {
    
    
    
    public Connection openConnection(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://" + CreateFile.getInstance().getFile().getString("Config.mysql.ip") + ":" + CreateFile.getInstance().getFile().getString("Config.mysql.port") + "/" + CreateFile.getInstance().getFile().getString("Config.mysql.database") + "?allowPublicKeyRetrieval=true&useSSL=false";
            String username=CreateFile.getInstance().getFile().getString("Config.mysql.username");
            String password=CreateFile.getInstance().getFile().getString("Config.mysql.password");
            cn=DriverManager.getConnection(url,username,password);
            //cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/selfish?allowPublicKeyRetrieval=true&useSSL=false","root","157855");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
    
    public void closeConnection(){
        try {
            if(!openConnection().isClosed()){
                openConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
