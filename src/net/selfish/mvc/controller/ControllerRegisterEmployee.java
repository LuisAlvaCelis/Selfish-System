package net.selfish.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.selfish.dao.DAOImplements;
import net.selfish.dao.DAOInterface;
import net.selfish.mvc.model.ModelRegisterUser;
import net.selfish.mvc.view.ViewMain;
import net.selfish.mvc.view.ViewRegisterEmployee;
import net.selfish.utils.SourceCodes;

public class ControllerRegisterEmployee implements ActionListener{

    private static ControllerRegisterEmployee instance;
    private ViewRegisterEmployee varRegisterEmployee;
    private String account;
    private int rolAccount;
    private DAOInterface dao;
    
    public ControllerRegisterEmployee(ViewRegisterEmployee vre){
        this.varRegisterEmployee=vre;
        this.varRegisterEmployee.setVisible(true);
        this.dao=new DAOImplements();
        this.dao.showDataFrame(1, varRegisterEmployee.jtTable, "");
        this.registerEvents();
    }
    
    public static ControllerRegisterEmployee getInstance(ViewRegisterEmployee vre){
        return instance=new ControllerRegisterEmployee(vre);
    }
    
    private void registerEvents(){
        this.varRegisterEmployee.jrbShowPassword.addActionListener(this);
        this.varRegisterEmployee.jbtRegisterEmployee.addActionListener(this);
        this.varRegisterEmployee.jbtModify.addActionListener(this);
        this.varRegisterEmployee.jbtCancel.addActionListener(this);
        this.varRegisterEmployee.jbtReturn.addActionListener(this);
        this.varRegisterEmployee.jbtPrint.addActionListener(this);
        this.varRegisterEmployee.jtfTelCel.addKeyListener(new KeyAdapter() {@Override public void keyTyped(KeyEvent e){SourceCodes.getInstance().justNum(e);}});
        this.varRegisterEmployee.jtfDNI.addKeyListener(new KeyAdapter() {@Override public void keyTyped(KeyEvent e){SourceCodes.getInstance().justNum(e);}});
        this.varRegisterEmployee.jtfSearch.addKeyListener(new KeyAdapter() {@Override public void keyPressed(KeyEvent e){dao.showDataFrame(1, varRegisterEmployee.jtTable, varRegisterEmployee.jtfSearch.getText());}});
        this.varRegisterEmployee.jtTable.addMouseListener(new MouseAdapter() {@Override public void mouseClicked(MouseEvent e){clickTable(e);}});
        this.varRegisterEmployee.addWindowListener(new WindowAdapter() {@Override public void windowClosing(WindowEvent e){try {ControllerMain.getInstance(new ViewMain()).setAccount(account,rolAccount);} catch (Exception ex) {ex.printStackTrace();}}});
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(varRegisterEmployee.jbtPrint==e.getSource()){
            this.buttonPrint();
        }else if(varRegisterEmployee.jbtReturn==e.getSource()){
            this.buttonReturn();
        }else if(varRegisterEmployee.jrbShowPassword==e.getSource()){
            this.buttonShowPassword();
        }else if(varRegisterEmployee.jbtRegisterEmployee==e.getSource()){
            this.buttonRegisterEmployee();
        }else if(varRegisterEmployee.jbtModify==e.getSource()){
            this.buttonModify();
        }else if(varRegisterEmployee.jbtCancel==e.getSource()){
            this.buttonCancel();
        }
    }
    
    private void buttonPrint(){
        this.dao.printReportUsers();
    }
    
    private void buttonCancel(){
        this.clear();
        this.varRegisterEmployee.jbtRegisterEmployee.setEnabled(true);
        this.varRegisterEmployee.jtfDNI.setEnabled(true);
        this.varRegisterEmployee.jbtModify.setEnabled(false);
        this.varRegisterEmployee.jbtCancel.setEnabled(false);
    }
    
    private void buttonModify(){
        if(varRegisterEmployee.jcbRol.getSelectedIndex()>0){
            if(!varRegisterEmployee.jtfLastnames.getText().equalsIgnoreCase("")){
                if(!varRegisterEmployee.jtfNames.getText().equalsIgnoreCase("")){
                    if(!varRegisterEmployee.jtfDNI.getText().equalsIgnoreCase("")){
                        if(!varRegisterEmployee.jtfTelCel.getText().equalsIgnoreCase("")){
                            if(!varRegisterEmployee.jtfUsername.getText().equalsIgnoreCase("")){
                                if(!varRegisterEmployee.jpfPassword.getText().equalsIgnoreCase("")){
                                    if(!varRegisterEmployee.jpfRepeatPassword.getText().equalsIgnoreCase("")){
                                        if(!varRegisterEmployee.jtfEmail.getText().equalsIgnoreCase("")){
                                            String lastnames=varRegisterEmployee.jtfLastnames.getText();
                                            String names=varRegisterEmployee.jtfNames.getText();
                                            String dni=varRegisterEmployee.jtfDNI.getText();
                                            String telcel=varRegisterEmployee.jtfTelCel.getText();
                                            String username=varRegisterEmployee.jtfUsername.getText();
                                            String password=varRegisterEmployee.jpfPassword.getText();
                                            String repeatPassword=varRegisterEmployee.jpfRepeatPassword.getText();
                                            String email=varRegisterEmployee.jtfEmail.getText();
                                            int rol=varRegisterEmployee.jcbRol.getSelectedIndex();
                                            if(dni.length()==8){
                                                if(repeatPassword.equals(password)){
                                                    int confirm=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere modificar los datos del empleado identificado con el DNI '"+dni+"' ?", "Confirmación", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                                                    if(confirm==0){
                                                        ModelRegisterUser mru=new ModelRegisterUser(dni, rol, lastnames, names, telcel, username, password,email);
                                                        if(dao.updateDataTableRegisterUsers(0,mru)==true && dao.updateDataTableRegisterUsers(1,mru)==true && dao.updateDataTableRegisterUsers(2,mru)==true){
                                                            JOptionPane.showMessageDialog(null, "Empleado registrado con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                                            this.clear();
                                                            this.varRegisterEmployee.jbtRegisterEmployee.setEnabled(true);
                                                            this.varRegisterEmployee.jbtModify.setEnabled(false);
                                                            this.varRegisterEmployee.jbtCancel.setEnabled(false);
                                                            this.dao.showDataFrame(1, varRegisterEmployee.jtTable, "");
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Error: Empleado no se pudo registrar, vuelva a intentarlo o contacte al creador.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                                        }
                                                    }
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Error: Las contraseñas ingresadas no coinciden, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Error: DNI debe contener 8 dígitos, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error: Email no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar de nuevo la contraseña para verificar, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Contraseña no ingresada, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Nombre de usuario no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Teléfono/Celular no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: DNI no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Nombre no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: Apellido no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un ROL.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonRegisterEmployee(){
        if(varRegisterEmployee.jcbRol.getSelectedIndex()>0){
            if(!varRegisterEmployee.jtfLastnames.getText().equalsIgnoreCase("")){
                if(!varRegisterEmployee.jtfNames.getText().equalsIgnoreCase("")){
                    if(!varRegisterEmployee.jtfDNI.getText().equalsIgnoreCase("")){
                        if(!varRegisterEmployee.jtfTelCel.getText().equalsIgnoreCase("")){
                            if(!varRegisterEmployee.jtfUsername.getText().equalsIgnoreCase("")){
                                if(!varRegisterEmployee.jpfPassword.getText().equalsIgnoreCase("")){
                                    if(!varRegisterEmployee.jpfRepeatPassword.getText().equalsIgnoreCase("")){
                                        if(!varRegisterEmployee.jtfEmail.getText().equalsIgnoreCase("")){
                                            String lastnames=varRegisterEmployee.jtfLastnames.getText();
                                            String names=varRegisterEmployee.jtfNames.getText();
                                            String dni=varRegisterEmployee.jtfDNI.getText();
                                            String telcel=varRegisterEmployee.jtfTelCel.getText();
                                            String username=varRegisterEmployee.jtfUsername.getText();
                                            String password=varRegisterEmployee.jpfPassword.getText();
                                            String repeatPassword=varRegisterEmployee.jpfRepeatPassword.getText();
                                            String email=varRegisterEmployee.jtfEmail.getText();
                                            int rol=varRegisterEmployee.jcbRol.getSelectedIndex();
                                            if(dni.length()==8){
                                                if(repeatPassword.equals(password)){
                                                    ModelRegisterUser mru=new ModelRegisterUser(dni, rol, lastnames, names, telcel, username, password,email);
                                                    if(dao.insertDataTableRegisterUsers(mru)==true){
                                                        JOptionPane.showMessageDialog(null, "Empleado registrado con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                                        this.clear();
                                                        this.dao.showDataFrame(1, varRegisterEmployee.jtTable, "");
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "Error: Empleado no se pudo registrar, vuelva a intentarlo o contacte al creador.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                                    }
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Error: Las contraseñas ingresadas no coinciden, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Error: DNI debe contener 8 dígitos, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                            }
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar de nuevo la contraseña para verificar, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Contraseña no ingresada, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Nombre de usuario no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Teléfono/Celular no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: DNI no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Nombre no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: Apellido no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un ROL.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonShowPassword(){
        if(varRegisterEmployee.jrbShowPassword.isSelected()==true){
            this.varRegisterEmployee.jpfPassword.setEchoChar((char)0);
            this.varRegisterEmployee.jpfRepeatPassword.setEchoChar((char)0);
        }else{
            this.varRegisterEmployee.jpfPassword.setEchoChar('•');
            this.varRegisterEmployee.jpfRepeatPassword.setEchoChar('•');
        }
    }
    
    private void buttonReturn(){
        try {
            ControllerMain.getInstance(new ViewMain()).setAccount(account, rolAccount);
            this.varRegisterEmployee.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ControllerRegisterEmployee setAccount(String account,int rol){
        this.account=account;
        this.rolAccount=rol;
        return this;
    }
    
    private void clickTable(MouseEvent e){
        int click=varRegisterEmployee.jtTable.rowAtPoint(e.getPoint());
        int rol=-1;
        if(varRegisterEmployee.jtTable.getValueAt(click, 0).toString().equalsIgnoreCase("Empleado")){
            rol=1;
        }
        String dni=varRegisterEmployee.jtTable.getValueAt(click, 1).toString();
        String lastnames=varRegisterEmployee.jtTable.getValueAt(click, 2).toString();
        String names=varRegisterEmployee.jtTable.getValueAt(click, 3).toString();
        String telcel=varRegisterEmployee.jtTable.getValueAt(click, 4).toString();
        String username=varRegisterEmployee.jtTable.getValueAt(click, 5).toString();
        String password=varRegisterEmployee.jtTable.getValueAt(click,6).toString();
        int column=varRegisterEmployee.jtTable.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/varRegisterEmployee.jtTable.getRowHeight();
        if((row<varRegisterEmployee.jtTable.getRowCount() && row>=0) && 
                (column<varRegisterEmployee.jtTable.getColumnCount() && column>=0)){
            Object value=varRegisterEmployee.jtTable.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn=(JButton)value;
                try {
                    if(btn.getName().equals("modify")){
                        int confirm=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere modificar?\nLos datos se moveran a los campos de texto.", "Confirmación", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                        if(confirm==0){
                            this.varRegisterEmployee.jcbRol.setSelectedIndex(rol);
                            this.varRegisterEmployee.jtfLastnames.setText(lastnames);
                            this.varRegisterEmployee.jtfNames.setText(names);
                            this.varRegisterEmployee.jtfDNI.setText(dni);
                            this.varRegisterEmployee.jtfTelCel.setText(telcel);
                            this.varRegisterEmployee.jtfUsername.setText(username);
                            this.varRegisterEmployee.jpfPassword.setText(password);
                            this.varRegisterEmployee.jpfRepeatPassword.setText(password);
                            this.varRegisterEmployee.jtfDNI.setEnabled(false);
                            this.varRegisterEmployee.jbtRegisterEmployee.setEnabled(false);
                            this.varRegisterEmployee.jbtModify.setEnabled(true);
                            this.varRegisterEmployee.jbtCancel.setEnabled(true);
                        }
                    }else if(btn.getName().equals("remove")){
                        int confirm=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover al empleado del registro?", "Confirmación", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                        if(confirm==0){
                            ModelRegisterUser mru=new ModelRegisterUser(dni);
                            if(dao.removeRowTableRegisterUsers(mru)==true){
                                this.dao.showDataFrame(1, varRegisterEmployee.jtTable, "");
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: No se pudo registrar el empleado, vuelva a intentarlo o contacte con el desarrollador del software.", "Error", 0, SourceCodes.getInstance().getImage("erro32x32.png"));
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private void clear(){
        this.varRegisterEmployee.jcbRol.setSelectedIndex(0);
        this.varRegisterEmployee.jtfLastnames.setText(null);
        this.varRegisterEmployee.jtfNames.setText(null);
        this.varRegisterEmployee.jtfTelCel.setText(null);
        this.varRegisterEmployee.jtfDNI.setText(null);
        this.varRegisterEmployee.jtfUsername.setText(null);
        this.varRegisterEmployee.jpfPassword.setText(null);
        this.varRegisterEmployee.jpfRepeatPassword.setText(null);
        this.varRegisterEmployee.jtfLastnames.requestFocus();
    }
}
