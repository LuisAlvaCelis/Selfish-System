package net.selfish.utils;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class CreateFile {
    
    private static CreateFile instance;
    private File directory;
    private File file;
    private YamlConfiguration yml;
    
    public CreateFile(){
        this.directory=new File("C:\\Selfish");
        this.file=new File(directory,"config.yml");
        this.yml=YamlConfiguration.loadConfiguration(file);
    }
    
    public static CreateFile getInstance(){
        if(instance==null){
            instance=new CreateFile();
        }
        return instance;
    }
    
    public boolean createFile(){
        boolean status=false;
        try {
            if(!file.exists()){
                this.directory.mkdir();
                this.file.createNewFile();
                this.yml.set("Config.manager.username", "manager");
                this.yml.set("Config.manager.password", "ucv2020");
                this.yml.set("Config.remember.account.username", "");
                this.yml.set("Config.remember.account.password", "");
                this.yml.set("Config.remember.status", false);
                this.yml.set("Config.mysql.status", false);
                this.yml.set("Config.mysql.ip", "");
                this.yml.set("Config.mysql.port", "");
                this.yml.set("Config.mysql.database", "");
                this.yml.set("Config.mysql.username", "");
                this.yml.set("Config.mysql.password", "");
                this.saveFile();
            }
            status=true;
        } catch (Exception e) {
            status=false;
            e.printStackTrace();
        }
        return status;
    }
    
    public void saveFile(){
        try {
            this.yml.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveMySQL(String ip,String port,String database,String username,String password, boolean status){
        this.yml.set("Config.mysql.status", status);
        this.yml.set("Config.mysql.ip", ip);
        this.yml.set("Config.mysql.port", port);
        this.yml.set("Config.mysql.database", database);
        this.yml.set("Config.mysql.username", username);
        this.yml.set("Config.mysql.password", password);
        this.saveFile();
    }
    
    public boolean isMySQLStatus(){
        return this.yml.getBoolean("Config.mysql.status");
    }
    
    public YamlConfiguration getFile(){
        return this.yml;
    }
    
    public void saveAccount(String username,String password,boolean status){
        try {
            this.yml.set("Config.remember.account.username", username);
            this.yml.set("Config.remember.account.password", password);
            this.yml.set("Config.remember.status", status);
            this.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isRememberStatus(){
        return this.yml.getBoolean("Config.remember.status");
    }
    
    public String getUsernameManager(){
        return this.yml.getString("Config.manager.username");
    }
    
    public String getPasswordManager(){
        return this.yml.getString("Config.manager.password");
    }
    
    public String getUsernameRemember(){
        return this.yml.getString("Config.remember.account.username");
    }
    
    public String getPasswordRemember(){
        return this.yml.getString("Config.remember.account.password");
    }
    
}
