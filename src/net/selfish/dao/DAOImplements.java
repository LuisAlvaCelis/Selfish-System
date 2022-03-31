package net.selfish.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.selfish.mvc.model.ModelProductMenu;
import net.selfish.mvc.model.ModelProductDrink;
import net.selfish.mvc.model.ModelRegisterOrder;
import net.selfish.mvc.model.ModelRegisterUser;
import net.selfish.utils.AccesoryTable;
import net.selfish.utils.CreateFile;
import net.selfish.utils.SourceCodes;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class DAOImplements extends ConnectionSQL implements DAOInterface{
    
    private String ip,port,database,username,password;
    
    public DAOImplements(){
        super();
        this.settingData();
    }
    
    private void settingData(){
        if(CreateFile.getInstance().isMySQLStatus()==true){
            this.ip=CreateFile.getInstance().getFile().getString("Config.mysql.ip");
            this.port=CreateFile.getInstance().getFile().getString("Config.mysql.port");
            this.database=CreateFile.getInstance().getFile().getString("Config.mysql.database");
            this.username=CreateFile.getInstance().getFile().getString("Config.mysql.username");
            this.password=CreateFile.getInstance().getFile().getString("Config.mysql.password");
        }
    }
    
    @Override
    public boolean verifyDataBase() {
        boolean status=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/?useSSL=false",username,password);
            Statement statement=connection.createStatement();
            String url="SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '"+database+"'";
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                status=true;
            }else{
                status=false;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean createDataBase() {
        boolean status=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/?useSSL=false",username,password);
            Statement statement=connection.createStatement();
            int result=statement.executeUpdate("CREATE DATABASE IF NOT EXISTS "+database);
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean createTables(int num){
        boolean status=false;
        if(num==0){
            try {
                String tablename="register_users";
                String c1="`dni` VARCHAR(30) NOT NULL";
                String c2="`id_rol` INT NOT NULL";
                String c3="`lastnames` VARCHAR(100) DEFAULT NULL";
                String c4="`names` VARCHAR(100) DEFAULT NULL";
                String c5="`tel_cel` VARCHAR(20) NOT NULL";
                String c6="`username` VARCHAR(100) DEFAULT NULL";
                String c7="`password` VARCHAR(100) DEFAULT NULL";
                String c8="`mail` VARCHAR(100) DEFAULT NULL";
                String pk="PRIMARY KEY (`dni`)";
                String url="CREATE TABLE `"+tablename+"` ("+c1+","+c2+","+c3+","+c4+","+c5+","+c6+","+c7+","+c8+", "+pk+")";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result==0){
                    status=true;
                }else{
                    status=false;
                }
                statement.close();
                this.closeConnection();
                return status;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==1){
            try {
                String tablename="register_menu";
                String c1="`id_menu` VARCHAR(50) NOT NULL";
                String c2="`name` VARCHAR(100) DEFAULT NULL";
                String c3="`category` VARCHAR(100) DEFAULT NULL";
                String c4="`cost` DOUBLE DEFAULT NULL";
                String c5="`image` LONGBLOB NOT NULL";
                String c6="`status` BOOLEAN";
                String pk="PRIMARY KEY (`id_menu`)";
                String url="CREATE TABLE `"+tablename+"` ("+c1+","+c2+","+c3+","+c4+","+c5+","+c6+","+pk+")";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result==0){
                    status=true;
                }else{
                    status=false;
                }
                statement.close();
                this.closeConnection();
                return status;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==2){
            try {
                String tablename="register_drinks";
                String c1="`id_drink` VARCHAR(30) NOT NULL";
                String c2="`name` VARCHAR(100) DEFAULT NULL";
                String c3="`category` VARCHAR(100) DEFAULT NULL";
                String c4="`cost` DOUBLE DEFAULT NULL";
                String c5="`cant` INT DEFAULT NULL";
                String c6="`image` LONGBLOB NOT NULL";
                String pk="PRIMARY KEY (`id_drink`)";
                String ex="KEY `category_idx` (`category`), CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `register_category_drinks` (`category`) ON DELETE NO ACTION ON UPDATE NO ACTION";
                String url="CREATE TABLE `"+tablename+"` ("+c1+","+c2+","+c3+","+c4+","+c5+","+c6+","+pk+","+ex+")";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result==0){
                    status=true;
                }else{
                    status=false;
                }
                statement.close();
                this.closeConnection();
                return status;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==3){
            try {
                String tablename="register_category_drinks";
                String c1="`category` VARCHAR(40) NOT NULL";
                String c2="`observation` VARCHAR(100) DEFAULT NULL";
                String pk="PRIMARY KEY (`category`)";
                String url="CREATE TABLE `"+tablename+"` ("+c1+","+c2+","+pk+")";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result==0){
                    status=true;
                }else{
                    status=false;
                }
                statement.close();
                this.closeConnection();
                return status;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==4){
            try {
                String tablename="register_category_menu";
                String c1="`category` VARCHAR(40) NOT NULL";
                String c2="`observation` VARCHAR(100) DEFAULT NULL";
                String pk="PRIMARY KEY (`category`)";
                String url="CREATE TABLE `"+tablename+"` ("+c1+","+c2+","+pk+")";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result==0){
                    status=true;
                }else{
                    status=false;
                }
                statement.close();
                this.closeConnection();
                return status;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==5){
            try {
                String tablename="register_orders";
                String c1="`id_order` VARCHAR(30) NOT NULL";
                String c2="`id_product` VARCHAR(30) NOT NULL";
                String c3="`name_product` VARCHAR (60) DEFAULT NULL";
                String c4="`cant_product` INT DEFAULT NULL";
                String c5="`cost_product` DOUBLE DEFAULT NULL";
                String url="CREATE TABLE `"+tablename+"` ("+c1+","+c2+","+c3+","+c4+","+c5+")";
                Statement statement=openConnection().createStatement();
                int result=statement.executeUpdate(url);
                if(result==0){
                    status=true;
                }else{
                    status=false;
                }
                statement.close();
                this.closeConnection();
                return status;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: No existe esa tabla.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
        return status;
    }

    @Override
    public boolean insertDataTableRegisterMenu(ModelProductMenu mp) {
        boolean status=false;
        try {
            String url="INSERT INTO register_menu(id_menu,name,category,cost,image,status) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mp.getId());
            ps.setString(2, mp.getName());
            ps.setString(3, mp.getCategory());
            ps.setDouble(4, mp.getCost());
            ps.setBinaryStream(5, mp.getImage());
            ps.setBoolean(6, mp.isStatus());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateDataTableRegisterMenu(int num, ModelProductMenu mp) {
        boolean status=false;
        if(num==0){
            try {
                String url="UPDATE register_menu SET name=?, category=?, cost=?, status=? WHERE id_menu=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setString(1, mp.getName());
                ps.setString(2, mp.getCategory());
                ps.setDouble(3, mp.getCost());
                ps.setBoolean(4, mp.isStatus());
                ps.setString(5, mp.getId());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==1){
            try {
                String url="UPDATE register_menu SET image=? WHERE id_menu=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setBinaryStream(1, mp.getImage());
                ps.setString(2, mp.getId());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==2){
            try {
                String url="UPDATE register_menu SET cost=? WHERE id_menu=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setDouble(1, mp.getCost());
                ps.setString(2, mp.getId());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==3){
            try {
                String url="UPDATE register_menu SET status=? WHERE id_menu=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setBoolean(1, mp.isStatus());
                ps.setString(2, mp.getId());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public boolean removeRowTableRegisterMenu(ModelProductMenu mp) {
        boolean status=false;
        try {
            String url="DELETE FROM register_menu WHERE id_menu=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mp.getId());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean insertDataTableRegisterUsers(ModelRegisterUser mru) {
        boolean status=false;
        try {
            String url="INSERT INTO register_users(dni,id_rol,lastnames,names,tel_cel,username,password,mail) VALUE(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mru.getDni());
            ps.setInt(2, mru.getIdRol());
            ps.setString(3, mru.getLastnames());
            ps.setString(4, mru.getNames());
            ps.setString(5, mru.getTel_cel());
            ps.setString(6, mru.getUsername());
            ps.setString(7, mru.getPassword());
            ps.setString(8, mru.getEmail());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateDataTableRegisterUsers(int num,ModelRegisterUser mru) {
        boolean status=false;
        if(num==0){
            try {
                String url="UPDATE register_users SET id_rol=? WHERE dni=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setInt(1, mru.getIdRol());
                ps.setString(2, mru.getDni());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==1){
            try {
                String url="UPDATE register_users SET lastnames=?, names=?, tel_cel=?,mail=? WHERE dni=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setString(1, mru.getLastnames());
                ps.setString(2, mru.getNames());
                ps.setString(3, mru.getTel_cel());
                ps.setString(4, mru.getEmail());
                ps.setString(5, mru.getDni());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==2){
            try {
                String url="UPDATE register_users SET username=?, password=? WHERE dni=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setString(1, mru.getUsername());
                ps.setString(2, mru.getPassword());
                ps.setString(3, mru.getDni());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public boolean removeRowTableRegisterUsers(ModelRegisterUser mru) {
        boolean status=false;
        try {
            String url="DELETE FROM register_users WHERE dni=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mru.getDni());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean insertDataTableRegisterCategoryDrinks(String category, String observation) {
        boolean status=false;
        try {
            String url="INSERT INTO register_category_drinks(category,observation) VALUES(?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, category);
            ps.setString(2, observation);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateDataTableRegisterCategoryDrinks(String category, String observation) {
        boolean status=false;
        try {
            String url="UPDATE register_category_drinks SET observation=? WHERE category=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, observation);
            ps.setString(2, category);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean removeRowTableRegisterCategoryDrinks(String category) {
        boolean status=false;
        try {
            String url="DELETE FROM register_category_drinks WHERE category=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, category);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean insertDataTableRegisterDrinks(ModelProductDrink mpd) {
        boolean status=false;
        try {
            String url="INSERT INTO register_drinks(id_drink,name,category,cost,cant,image) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mpd.getId());
            ps.setString(2, mpd.getName());
            ps.setString(3, mpd.getCategory());
            ps.setDouble(4, mpd.getCost());
            ps.setInt(5, mpd.getCant());
            ps.setBinaryStream(6, mpd.getImage());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateDataTableRegisterDrinks(int num, ModelProductDrink mpd) {
        boolean status=false;
        if(num==0){
            try {
                String url="UPDATE register_drinks SET name=?, category=?, cost=?, cant=? WHERE id_drink=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setString(1, mpd.getName());
                ps.setString(2, mpd.getCategory());
                ps.setDouble(3, mpd.getCost());
                ps.setInt(4, mpd.getCant());
                ps.setString(5, mpd.getId());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==1){
            try {
                String url="UPDATE register_drinks SET image=? WHERE id_drink=?";
                PreparedStatement ps=openConnection().prepareStatement(url);
                ps.setBinaryStream(1, mpd.getImage());
                ps.setString(2, mpd.getId());
                int result=ps.executeUpdate();
                if(result>0){
                    status=true;
                }else{
                    status=false;
                }
                ps.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public boolean removeRowTableRegisterDrinks(ModelProductDrink mpd) {
        boolean status=false;
        try {
            String url="DELETE FROM register_drinks WHERE id_drink=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mpd.getId());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean insertDataTableRegisterCategoryMenu(String category, String observation) {
        boolean status=false;
        try {
            String url="INSERT INTO register_category_menu(category,observation) VALUES(?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, category);
            ps.setString(2, observation);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateDataTableRegisterCategoryMenu(String category, String observation) {
        boolean status=false;
        try {
            String url="UPDATE register_category_menu SET observation=? WHERE category=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, observation);
            ps.setString(2, category);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean removeRowTableRegisterCategoryMenu(String category) {
        boolean status=false;
        try {
            String url="DELETE FROM register_category_menu WHERE category=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, category);
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean insertDataTableRegisterOrders(ModelRegisterOrder mro,String id_order) {
        boolean status=false;
        try {
            String url="INSERT INTO register_orders(id_order,id_product,name_product,cant_product,cost_product) VALUES(?,?,?,?,?)";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, id_order);
            ps.setString(2, mro.getId());
            ps.setString(3, mro.getName());
            ps.setInt(4, mro.getCant());
            ps.setDouble(5, mro.getCost());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateDataTableRegisterOrders(int num, ModelRegisterOrder mro) {
        boolean status=false;
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean removeRowTableRegisterOrders(ModelRegisterOrder mro) {
        boolean status=false;
        try {
            String url="DELETE FROM register_orders WHERE id_order=?";
            PreparedStatement ps=openConnection().prepareStatement(url);
            ps.setString(1, mro.getId());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void showDataFrame(int num, JTable table, String search) {
        String[] columns=new String[table.getModel().getColumnCount()];
        Object[] row=new Object[table.getModel().getColumnCount()];
        table.setDefaultRenderer(Object.class, new AccesoryTable());
        for(int i=0;i<columns.length;i++){
            columns[i]=table.getModel().getColumnName(i);
        }
        DefaultTableModel dtm=new DefaultTableModel(null,columns){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column==0){
                    return false;
                }else{
                    return false;
                }
            }
        };
        new DefaultTableModel().getDataVector().removeAllElements();
        new DefaultTableModel().fireTableDataChanged();
        if(num==0){
            try {
                String url="SELECT * FROM register_menu WHERE CONCAT(id_menu,'',name,'',category,'',status) LIKE '%"+search+"%'";
                Statement st=openConnection().createStatement();
                ResultSet rs=st.executeQuery(url);
                JButton bt1=new JButton("Modificar");
                bt1.setName("modify");
                JButton bt2=new JButton("Remover");
                bt2.setName("remove");
                while(rs.next()){
                    row[0]=rs.getString("category");
                    row[1]=rs.getString("id_menu");
                    row[2]=rs.getString("name");
                    row[3]=rs.getDouble("cost");
                    Blob blob=rs.getBlob("image");
                    byte[] data=blob.getBytes(1,(int) blob.length());
                    BufferedImage bi=ImageIO.read(new ByteArrayInputStream(data));
                    ImageIcon imageicon=new ImageIcon(bi);
                    row[4]=new JLabel(imageicon);
                    row[5]=rs.getBoolean("status");
                    row[6]=bt1;
                    row[7]=bt2;
                    dtm.addRow(row);
                }
                table.setModel(dtm);
                table.setRowHeight(50);
                table.getColumnModel().getColumn(5).setPreferredWidth(50);
                table.getColumnModel().getColumn(4).setPreferredWidth(200);
                table.getColumnModel().getColumn(3).setPreferredWidth(20);
                table.getColumnModel().getColumn(1).setPreferredWidth(60);
                rs.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==1){
            try {
                String url="SELECT * FROM register_users WHERE CONCAT(dni,'',username) LIKE '%"+search+"%'";
                Statement st=openConnection().createStatement();
                ResultSet rs=st.executeQuery(url);
                JButton bt1=new JButton("Modificar");
                bt1.setName("modify");
                JButton bt2=new JButton("Remover");
                bt2.setName("remove");
                while(rs.next()){
                    if(rs.getInt("id_rol")==1){
                        row[0]="Empleado";
                    }else{
                        row[0]=rs.getInt("id_rol");
                    }
                    row[1]=rs.getString("dni");
                    row[2]=rs.getString("lastnames");
                    row[3]=rs.getString("names");
                    row[4]=rs.getString("tel_cel");
                    row[5]=rs.getString("username");
                    row[6]=rs.getString("password");
                    row[7]=rs.getString("mail");
                    row[8]=bt1;
                    row[9]=bt2;
                    dtm.addRow(row);
                }
                table.setModel(dtm);
                rs.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==2){
            try {
                String url="SELECT * FROM register_drinks WHERE CONCAT(id_drink,'',name,'',category,'',cant) LIKE '%"+search+"%'";
                Statement st=openConnection().createStatement();
                ResultSet rs=st.executeQuery(url);
                JButton bt1=new JButton("Modificar");
                bt1.setName("modify");
                JButton bt2=new JButton("Remover");
                bt2.setName("remove");
                while(rs.next()){
                    row[0]=rs.getString("category");
                    row[1]=rs.getString("id_drink");
                    row[2]=rs.getString("name");
                    row[3]=rs.getInt("cant");
                    row[4]=rs.getDouble("cost");
                    Blob blob=rs.getBlob("image");
                    byte[] data=blob.getBytes(1, (int)blob.length());
                    BufferedImage img=ImageIO.read(new ByteArrayInputStream(data));
                    row[5]=new JLabel(new ImageIcon(img));
                    row[6]=bt1;
                    row[7]=bt2;
                    dtm.addRow(row);
                }
                table.setModel(dtm);
                table.setRowHeight(40);
                table.getColumnModel().getColumn(5).setPreferredWidth(200);
                table.getColumnModel().getColumn(4).setPreferredWidth(20);
                table.getColumnModel().getColumn(3).setPreferredWidth(20);
                rs.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==3){
            try {
                String url="SELECT * FROM register_orders WHERE CONCAT(id_order,'',name_product,'',cant_product) LIKE '%"+search+"%'";
                Statement statement=openConnection().createStatement();
                ResultSet rs=statement.executeQuery(url);
                JButton bt1=new JButton("Remover");
                bt1.setName("remove");
                while(rs.next()){
                    row[0]=rs.getString("id_order");
                    row[1]=rs.getString("name_product");
                    row[2]=rs.getInt("cant_product");
                    row[3]=rs.getDouble("cost_product");
                    row[4]=bt1;
                    dtm.addRow(row);
                }
                table.setModel(dtm);
                rs.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==4){
            try {
                String url="SELECT * FROM register_menu WHERE CONCAT(id_menu,'',name,'',cost) LIKE '%"+search+"%'";
                Statement statement=openConnection().createStatement();
                ResultSet rs=statement.executeQuery(url);
                JButton bt1=new JButton("Seleccionar");
                bt1.setName("select");
                while(rs.next()){
                    if(rs.getBoolean("status")==true){
                        row[0]=rs.getString("id_menu");
                        row[1]=rs.getString("name");
                        row[2]=rs.getDouble("cost");
                        row[3]=bt1;
                        dtm.addRow(row);
                    }
                }
                table.setModel(dtm);
                rs.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(num==5){
            try {
                String url="SELECT * FROM register_drinks WHERE CONCAT(id_drink,'',name,'',category) LIKE '%"+search+"%'";
                Statement statement=openConnection().createStatement();
                ResultSet rs=statement.executeQuery(url);
                JButton bt1=new JButton("Seleccionar");
                bt1.setName("select");
                while(rs.next()){
                    if(rs.getInt("cant")>0){
                        row[0]=rs.getString("id_drink");
                        row[1]=rs.getString("name");
                        row[2]=rs.getString("category");
                        row[3]=rs.getDouble("cost");
                        row[4]=bt1;
                        dtm.addRow(row);
                    }
                }
                table.setModel(dtm);
                rs.close();
                this.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public HashMap<String, String> getAccount(String account) {
        HashMap<String,String> hm=new HashMap<>();
        try {
            String url="SELECT * FROM register_users WHERE username LIKE '%"+account+"%'";
            Statement st=openConnection().createStatement();
            ResultSet rs=st.executeQuery(url);
            while(rs.next()){
                String user=rs.getString("username");
                String pass=rs.getString("password");
                if(user.equalsIgnoreCase(account)){
                    hm.put(user, pass);
                }
            }
            rs.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hm;
    }

    @Override
    public List<String> getListCategoryDrinks() {
        List<String> list=new ArrayList<>();
        try {
            String url="SELECT * FROM register_category_drinks";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(rs.getString("category"));
            }
            statement.close();
            rs.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public int getRolAccount(String account) {
        int result=0;
        try {
            String url="SELECT * FROM register_users WHERE username LIKE '%"+account+"%'";
            Statement st=openConnection().createStatement();
            ResultSet rs=st.executeQuery(url);
            while(rs.next()){
                String user=rs.getString("username");
                int rol=rs.getInt("id_rol");
                if(user.equalsIgnoreCase(account)){
                    result=rol;
                }
            }
            rs.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int getCantDrinksByID(String id) {
        int result=0;
        try {
            String url="SELECT * FROM register_drinks WHERE id_drink='"+id+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                if(rs.getString("id_drink").equalsIgnoreCase(id)){
                    result=rs.getInt("cant");
                }
            }
            rs.close();
            statement.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean verifyCategoryDrinksExists(String category) {
        boolean status=false;
        try {
            String url="SELECT * FROM register_category_drinks WHERE category LIKE '%"+category+"%'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                if(rs.getString("category").equalsIgnoreCase(category)){
                    status=true;
                }else{
                    status=false;
                }
            }
            statement.close();
            rs.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public boolean verifyDrinkIfExistsByID(String id) {
        boolean status=false;
        try {
            String url="SELECT * FROM register_drinks WHERE id_drink LIKE '%"+id+"%'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                if(rs.getString("id_drink").equalsIgnoreCase(id)){
                    status=true;
                }else{
                    status=false;
                }
            }
            rs.close();
            statement.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @Override
    public ImageIcon getImageDrinkByID(String id) {
        ImageIcon img=null;
        try {
            String url="SELECT * FROM register_drinks WHERE id_drink='"+id+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                byte[] data=rs.getBytes("image");
                BufferedImage bi=ImageIO.read(new ByteArrayInputStream(data));
                img=new ImageIcon(new ImageIcon(bi).getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    @Override
    public void printReportDrinks() {
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/net/selfish/reports/ReportDrinks.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,null,openConnection());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printReportUsers() {
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/net/selfish/reports/ReportUsers.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,null,openConnection());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void printReportMenus() {
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/net/selfish/reports/ReportMenu.jrxml");
            Map<String,Object> map=new HashMap<>();
            JasperPrint jp=JasperFillManager.fillReport(jr,null,openConnection());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getListCategoryMenus() {
        List<String> list=new ArrayList<>();
        try {
            String url="SELECT * FROM register_category_menu";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(rs.getString("category"));
            }
            statement.close();
            rs.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean verifyCategoryMenuExists(String category) {
        boolean status=false;
        try {
            String url="SELECT * FROM register_category_menu WHERE category LIKE '%"+category+"%'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                if(rs.getString("category").equalsIgnoreCase(category)){
                    status=true;
                }else{
                    status=false;
                }
            }
            statement.close();
            rs.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean verifyMenuIfExistsByID(String id) {
        boolean status=false;
        try {
            String url="SELECT * FROM register_menu WHERE id_menu LIKE '%"+id+"%'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                if(rs.getString("id_menu").equalsIgnoreCase(id)){
                    status=true;
                }else{
                    status=false;
                }
            }
            rs.close();
            statement.close();
            this.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ImageIcon getImageMenuByID(String id) {
        ImageIcon img=null;
        try {
            String url="SELECT * FROM register_menu WHERE id_menu='"+id+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                byte[] data=rs.getBytes("image");
                BufferedImage bi=ImageIO.read(new ByteArrayInputStream(data));
                img=new ImageIcon(new ImageIcon(bi).getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }
    
    @Override
    public String getProductByID(String id) {
        String product=null;
        try {
            String url1="SELECT * FROM register_menu WHERE id_menu='"+id+"'";
            String url2="SELECT * FROM register_drinks WHERE id_drink='"+id+"'";
            Statement statement=openConnection().createStatement();
            ResultSet rs=statement.executeQuery(url1);
            if(rs.next()){
                product=rs.getString("name");
            }else{
                rs.close();
                this.closeConnection();
                statement=openConnection().createStatement();
                rs=statement.executeQuery(url2);
                if(rs.next()){
                    product=rs.getString("name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void printReportRegisterOrder(String costTotal,String id_order) {
        try {
            JasperReport jr=JasperCompileManager.compileReport("src/net/selfish/reports/RegisterOrder.jrxml");
            Map<String,Object> map=new HashMap<>();
            map.put("CostTotal", costTotal);
            map.put("IDOrder", id_order);
            JasperPrint jp=JasperFillManager.fillReport(jr,map,openConnection());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
