package net.selfish.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import net.selfish.dao.DAOImplements;
import net.selfish.dao.DAOInterface;
import net.selfish.mvc.view.ViewMain;
import net.selfish.mvc.view.ViewRegisterMySQL;
import net.selfish.utils.CreateFile;
import net.selfish.utils.SourceCodes;

public class ControllerRegisterMySQL implements ActionListener{
    
    private static ControllerRegisterMySQL instance;
    private ViewRegisterMySQL varRegisterMySQL;
    private String account;
    private int rol;
    
    public ControllerRegisterMySQL(ViewRegisterMySQL var){
        this.varRegisterMySQL=var;
        this.varRegisterMySQL.setVisible(true);
        this.verifyStatus();
        this.registerEvents();
    }
    
    public static ControllerRegisterMySQL getInstance(ViewRegisterMySQL var){
        return instance=new ControllerRegisterMySQL(var);
    }

    private void verifyStatus(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyy hh:mm:ss aa");
        if(CreateFile.getInstance().isMySQLStatus()==true){
            varRegisterMySQL.jtaStatus.setText("Fecha de informe: "+sdf.format(Calendar.getInstance().getTime())+"\n  Estatus de la base de datos: activada\n  (ya registrada)");}else{varRegisterMySQL.jtaStatus.setText("Fecha de informe: "+sdf.format(Calendar.getInstance().getTime())+"\n  Estatus de la base de datos: desactivada\n  (no registrada)");
        }
    }
    
    private void registerEvents(){
        this.varRegisterMySQL.jckbShowPassword.addActionListener(this);
        this.varRegisterMySQL.jbtRegisterMySQL.addActionListener(this);
        this.varRegisterMySQL.addWindowListener(new WindowAdapter() {@Override public void windowClosing(WindowEvent e){try {ControllerMain.getInstance(new ViewMain()).setAccount(account,rol);} catch (Exception ex) {ex.printStackTrace();}}});
    }
    
    private void clear(){
        this.varRegisterMySQL.jtfIp.setText(null);
        this.varRegisterMySQL.jtfPort.setText(null);
        this.varRegisterMySQL.jtfDatabase.setText(null);
        this.varRegisterMySQL.jtfUsername.setText(null);
        this.varRegisterMySQL.jpfPassword.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(varRegisterMySQL.jckbShowPassword==e.getSource()){
            this.buttonShowPassword();
        }else if(varRegisterMySQL.jbtRegisterMySQL==e.getSource()){
            this.buttonRegisterMySQL();
        }
    }
    
    private void buttonShowPassword(){
        if(varRegisterMySQL.jckbShowPassword.isSelected()==true){
            this.varRegisterMySQL.jpfPassword.setEchoChar((char)0);
        }else{
            this.varRegisterMySQL.jpfPassword.setEchoChar('•');
        }
    }
    
    private void buttonRegisterMySQL(){
        if(!varRegisterMySQL.jtfIp.getText().equalsIgnoreCase("")){
            if(!varRegisterMySQL.jtfPort.getText().equalsIgnoreCase("")){
                if(!varRegisterMySQL.jtfDatabase.getText().equalsIgnoreCase("")){
                    if(!varRegisterMySQL.jtfUsername.getText().equalsIgnoreCase("")){
                        if(!varRegisterMySQL.jpfPassword.getText().equalsIgnoreCase("")){
                            String ip=varRegisterMySQL.jtfIp.getText();
                            String port=varRegisterMySQL.jtfPort.getText();
                            String database=varRegisterMySQL.jtfDatabase.getText();
                            String username=varRegisterMySQL.jtfUsername.getText();
                            String password=varRegisterMySQL.jpfPassword.getText();
                            CreateFile.getInstance().saveMySQL(ip, port, database, username, password, true);
                            DAOInterface dao=new DAOImplements();
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyy hh:mm:ss aa");
                            if(dao.verifyDataBase()==false){
                                varRegisterMySQL.jtaStatus.setText("Fecha de informe: "+sdf.format(Calendar.getInstance().getTime())+"\n  Estatus de la base de datos: conectada\n  Creando tablas...\n");
                                if(dao.createDataBase()==true){
                                    varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Base de datos creada con éxito\n  Creando tablas...\n");
                                    if(dao.createTables(0)==true){
                                        varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Tabla 'register_users': creada con éxito\n");
                                        if(dao.createTables(1)==true){
                                            varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Tabla 'register_products': creada con éxito\n");
                                            if(dao.createTables(3)==true){
                                                varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Tabla 'register_category_drinks': creada con éxito\n");
                                                if(dao.createTables(2)==true){
                                                    varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Tabla 'register_drinks': creada con éxito\n");
                                                    if(dao.createTables(4)==true){
                                                        varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Tabla 'register_category_menu': creada con éxito\n");
                                                        if(dao.createTables(5)==true){
                                                            varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Tabla 'register_orders': creada con éxito\n\nBase de datos registrada con éxito!");
                                                            this.clear();
                                                        }else{
                                                            varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"] Error: Tabla 'register_order' no creada\n\nHubo errores en el registro de la base de datos.");
                                                            CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                                        }
                                                    }else{
                                                        varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"] Error: Tabla 'register_category_menu' no creada\n\nHubo errores en el registro de la base de datos.");
                                                        CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                                    }
                                                }else{
                                                    varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"] Error: Tabla 'register_drinks' no creada\n\nHubo errores en el registro de la base de datos.");
                                                    CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                                }
                                            }else{
                                                varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"] Error: Tabla 'register_category_drinks' no creada\n\nHubo errores en el registro de la base de datos.");
                                                CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                            }
                                        }else{
                                            varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Error: Tabla 'register_products' no creada\nProceso cancelado, se reinició el archivo config.yml");
                                            CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                        }
                                    }else{
                                        varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Error: Tabla 'register_users' no creada\nProceso cancelado, se reinició el archivo 'config.yml'");
                                        CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                    }
                                }else{
                                    varRegisterMySQL.jtaStatus.append("["+sdf.format(Calendar.getInstance().getTime())+"]  Error: Base de datos '"+database+"' no creada\nProceso cancelado, se reinició el archivo 'config.yml'");
                                    CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                                }
                            }else{
                                varRegisterMySQL.jtaStatus.setText("Fecha de informe: "+sdf.format(Calendar.getInstance().getTime())+"\n  Estatus de la base de datos: no conectada\n  (no ha sido conectado)");
                                CreateFile.getInstance().saveMySQL("", "", "", "", "", false);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Contraseña no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Usuario no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Base de datos no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: Puerto no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: IP no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    public ControllerRegisterMySQL setAccount(String account,int rol){
        this.account=account;
        this.rol=rol;
        return this;
    }
}
