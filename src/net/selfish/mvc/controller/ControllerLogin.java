package net.selfish.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import net.selfish.dao.DAOImplements;
import net.selfish.dao.DAOInterface;
import net.selfish.mvc.view.ViewLogin;
import net.selfish.mvc.view.ViewMain;
import net.selfish.utils.CreateFile;
import net.selfish.utils.SourceCodes;

public class ControllerLogin implements ActionListener{
    
    private static ControllerLogin instance;
    private ViewLogin varLogin;
    private DAOInterface dao;
    
    public ControllerLogin(ViewLogin vl){
        this.varLogin=vl;
        this.dao=new DAOImplements();
        this.runLater();
    }
    
    
    private void runLater(){
        try {
            if(CreateFile.getInstance().isRememberStatus()==true){
                if(CreateFile.getInstance().getUsernameRemember().equalsIgnoreCase(CreateFile.getInstance().getUsernameManager())){
                    ControllerMain.getInstance(new ViewMain()).setAccount(CreateFile.getInstance().getUsernameRemember(),0);
                    this.varLogin.dispose();
                }else{
                    ControllerMain.getInstance(new ViewMain()).setAccount(CreateFile.getInstance().getUsernameRemember(),dao.getRolAccount(CreateFile.getInstance().getUsernameRemember()));
                    this.varLogin.dispose();
                }
            }else{
                this.varLogin.setVisible(true);
                this.registerEvents();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ControllerLogin getInstance(ViewLogin vl){
        return instance=new ControllerLogin(vl);
    }
    
    private void registerEvents(){
        this.varLogin.jrbSeePassword.addActionListener(this);
        this.varLogin.jbtJoin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(varLogin.jrbSeePassword==e.getSource()){
            this.buttonSeePassword();
        }else if(varLogin.jbtJoin==e.getSource()){
            this.buttonJoin();
        }
    }
    
    private void buttonJoin(){
        try {
            if(!varLogin.jtfUsername.getText().equalsIgnoreCase("")){
                if(!varLogin.jpfPassword.getText().equalsIgnoreCase("")){
                    String username=varLogin.jtfUsername.getText();
                    String password=varLogin.jpfPassword.getText();
                    if(username.equalsIgnoreCase(CreateFile.getInstance().getUsernameManager())){
                        if(password.equalsIgnoreCase(CreateFile.getInstance().getPasswordManager())){
                            
                            if(varLogin.jrbRememberAccount.isSelected()==true){
                                CreateFile.getInstance().saveAccount(username, password,true);
                                ControllerMain.getInstance(new ViewMain()).setAccount(CreateFile.getInstance().getUsernameRemember(),0);
                                this.varLogin.dispose();
                            }else{
                                ControllerMain.getInstance(new ViewMain()).setAccount(CreateFile.getInstance().getUsernameRemember(),0);
                                this.varLogin.dispose();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Contraseña erronea, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        if(CreateFile.getInstance().isMySQLStatus()==true){
                            if(dao.getAccount(username).containsKey(username)){
                                if(dao.getAccount(username).get(username).equalsIgnoreCase(password)){
                                    if(dao.getRolAccount(username)==0){
                                        if(varLogin.jrbRememberAccount.isSelected()==true){
                                            CreateFile.getInstance().saveAccount(username, password,true);
                                            ControllerMain.getInstance(new ViewMain()).setAccount(username,0);
                                            this.varLogin.dispose();
                                        }else{
                                            ControllerMain.getInstance(new ViewMain()).setAccount(username,0);
                                            this.varLogin.dispose();
                                        }
                                    }else{
                                        if(varLogin.jrbRememberAccount.isSelected()==true){
                                            CreateFile.getInstance().saveAccount(username, password,true);
                                            ControllerMain.getInstance(new ViewMain()).setAccount(username,dao.getRolAccount(username));
                                            this.varLogin.dispose();
                                        }else{
                                            ControllerMain.getInstance(new ViewMain()).setAccount(username,dao.getRolAccount(username));
                                            this.varLogin.dispose();
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Contraseña erronea, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Usuario no encontrado o no registrado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Usuario no encontrado o no registrado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Contraseña no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("err32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: Usuario no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void buttonSeePassword(){
        if(varLogin.jrbSeePassword.isSelected()==true){
            this.varLogin.jpfPassword.setEchoChar((char)0);
        }else{
            this.varLogin.jpfPassword.setEchoChar('•');
        }
    }
}