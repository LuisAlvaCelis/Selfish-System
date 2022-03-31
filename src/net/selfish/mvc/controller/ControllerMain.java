package net.selfish.mvc.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.selfish.dao.DAOImplements;
import net.selfish.dao.DAOInterface;
import net.selfish.mvc.model.ModelProductDrink;
import net.selfish.mvc.model.ModelProductMenu;
import net.selfish.mvc.model.ModelRegisterOrder;
import net.selfish.mvc.view.ViewLogin;
import net.selfish.mvc.view.ViewMain;
import net.selfish.mvc.view.ViewRegisterEmployee;
import net.selfish.mvc.view.ViewRegisterMySQL;
import net.selfish.utils.AccesoryTable;
import net.selfish.utils.Animations;
import net.selfish.utils.CreateFile;
import net.selfish.utils.SourceCodes;

public class ControllerMain implements ActionListener{
    
    private static ControllerMain instance;
    private ViewMain varMain;
    private String account,path,path1,costTotal;
    private int rol;
    private DAOInterface dao;
    private DefaultTableModel dtm;
    private List<String> list;
    private List<ModelRegisterOrder> listOrders;
    
    public ControllerMain(ViewMain vm){
        this.varMain=vm;
        this.listOrders=new ArrayList<>();
        this.list=new ArrayList<>();
        this.varMain.setVisible(true);
        this.dao=new DAOImplements();
        this.registerEvents();
    }
    
    private void runnable(){
        this.loadDefaultTableModel();
        new Thread(){ @Override public void run(){try {Thread.sleep(150);if(getRol()==0){varMain.jmiRegisterEmployee.setVisible(true);varMain.jmiRegisterMySQL.setVisible(true);varMain.jlAccount.setText("ADMINISTRADOR");}else{varMain.jmiRegisterEmployee.setVisible(false);varMain.jmiRegisterMySQL.setVisible(false);varMain.jbtMenu.setVisible(false);varMain.jbtBeverageWerehouse.setVisible(false);varMain.jbtStatistics.setVisible(false);varMain.jlAccount.setText(account.toUpperCase());}} catch (Exception e) {e.printStackTrace();}}}.start();
        if(CreateFile.getInstance().isMySQLStatus()==true){
            SourceCodes.getInstance().addItemComboBox(varMain.jcbCategoryAllowedDrink, dao.getListCategoryDrinks());
            SourceCodes.getInstance().addItemComboBox(varMain.jcbCategoryAllowedMenu, dao.getListCategoryMenus());
            this.dao.showDataFrame(5, varMain.jtTableListDrinksOrder, "");
            this.dao.showDataFrame(4, varMain.jtTableListMenusOrder, "");
            this.dao.showDataFrame(3, varMain.jtTableOrders, "");
            this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
            this.dao.showDataFrame(0, varMain.jtTableMenu, "");
        }
    }
    
    public static ControllerMain getInstance(ViewMain vm){
        return instance=new ControllerMain(vm);
    }
    
    private void registerEvents(){
        this.varMain.jmiLogout.addActionListener(this);
        this.varMain.jmiRegisterEmployee.addActionListener(this);
        this.varMain.jmiRegisterMySQL.addActionListener(this);
        this.varMain.jbtBeverageWerehouse.addActionListener(this);
        this.varMain.jbtStatistics.addActionListener(this);
        this.varMain.jbtMakeOrder.addActionListener(this);
        this.varMain.jbtOrders.addActionListener(this);
        this.varMain.jbtMenu.addActionListener(this);
        this.varMain.jbtExamineDrink.addActionListener(this);
        this.varMain.jbtRegisterCategoryDrink.addActionListener(this);
        this.varMain.jbtRegisterDrink.addActionListener(this);
        this.varMain.jbtModifyDrink.addActionListener(this);
        this.varMain.jbtCancelDrink.addActionListener(this);
        this.varMain.jbtNewDrink.addActionListener(this);
        this.varMain.jbtPrintTableDrink.addActionListener(this);
        this.varMain.jbtExamineMenu.addActionListener(this);
        this.varMain.jbtRegisterCategoryMenu.addActionListener(this);
        this.varMain.jbtRegisterMenu.addActionListener(this);
        this.varMain.jbtModifyMenu.addActionListener(this);
        this.varMain.jbtCancelMenu.addActionListener(this);
        this.varMain.jbtNewMenu.addActionListener(this);
        this.varMain.jbtPrintTableMenu.addActionListener(this);
        this.varMain.jbtPerformOrder.addActionListener(this);
        this.varMain.jbtUpdateListOrders.addActionListener(this);
        this.varMain.jtfSearchMenuToOrder.addKeyListener(new KeyAdapter() {@Override public void keyReleased(KeyEvent e){dao.showDataFrame(4, varMain.jtTableListMenusOrder, varMain.jtfSearchMenuToOrder.getText());}});
        this.varMain.jtfSearchDrinkToOrder.addKeyListener(new KeyAdapter() {@Override public void keyReleased(KeyEvent e){dao.showDataFrame(5, varMain.jtTableListDrinksOrder, varMain.jtfSearchDrinkToOrder.getText());}});
        this.varMain.jtTableListDrinksOrder.addMouseListener(new MouseAdapter() {@Override public void mouseClicked(MouseEvent e){clickTableListDrinkOrder(e);}});
        this.varMain.jtTableListMenusOrder.addMouseListener(new MouseAdapter() {@Override public void mouseClicked(MouseEvent e){clickTableListMenusOrder(e);}});
        this.varMain.jtfSearchOrder.addKeyListener(new KeyAdapter() {@Override public void keyReleased(KeyEvent e){dao.showDataFrame(3, varMain.jtTableOrders, varMain.jtfSearchOrder.getText());}});
        this.varMain.jtfSearchMenu.addKeyListener(new KeyAdapter() {@Override public void keyReleased(KeyEvent e){dao.showDataFrame(0, varMain.jtTableMenu, varMain.jtfSearchMenu.getText());}});
        this.varMain.jtfCostMenu.addKeyListener(new KeyAdapter() {@Override public void keyTyped(KeyEvent e){SourceCodes.getInstance().justNum(e);}});
        this.varMain.jtTableDrinks.addMouseListener(new MouseAdapter() {@Override public void mouseClicked(MouseEvent e){clickTableDrink(e);}});
        this.varMain.jtTableMenu.addMouseListener(new MouseAdapter() {@Override public void mouseClicked(MouseEvent e){clickTableMenu(e);}});
        this.varMain.jtfSearchDrink.addKeyListener(new KeyAdapter() {@Override public void keyReleased(KeyEvent e){dao.showDataFrame(2, varMain.jtTableDrinks, varMain.jtfSearchDrink.getText());}});
        this.varMain.jtfCostDrink.addKeyListener(new KeyAdapter() {@Override public void keyTyped(KeyEvent e){SourceCodes.getInstance().justNum(e);}});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(varMain.jbtUpdateListOrders==e.getSource()){
            this.buttonUpdateListOrders();
        }else if(varMain.jbtPerformOrder==e.getSource()){
            this.buttonPerformOrder();
        }else if(varMain.jbtPrintTableMenu==e.getSource()){
            this.buttonPrintMenu();
        }else if(varMain.jbtNewMenu==e.getSource()){
            this.buttonNewMenu();
        }else if(varMain.jbtCancelMenu==e.getSource()){
            this.buttonCancelMenu();
        }else if(varMain.jbtModifyMenu==e.getSource()){
            this.buttonModifyMenu();
        }else if(varMain.jbtRegisterMenu==e.getSource()){
            this.buttonRegisterMenu();
        }else if(varMain.jbtRegisterCategoryMenu==e.getSource()){
            this.buttonRegisterCategoryMenu();
        }else if(varMain.jbtExamineMenu==e.getSource()){
            this.buttonExamineMenu();
        }else if(varMain.jbtPrintTableDrink==e.getSource()){
            this.buttonPrintDrink();
        }else if(varMain.jbtNewDrink==e.getSource()){
            this.buttonNewDrink();
        }else if(varMain.jbtCancelDrink==e.getSource()){
            this.buttonCancelDrink();
        }else if(varMain.jbtModifyDrink==e.getSource()){
            this.buttonModifyDrink();
        }else if(varMain.jbtRegisterDrink==e.getSource()){
            this.buttonRegisterDrink();
        }else if(varMain.jbtRegisterCategoryDrink==e.getSource()){
            this.buttonRegisterCategoryDrink();
        }else if(varMain.jbtExamineDrink==e.getSource()){
            this.buttonExamineDrink();
        }else if(varMain.jmiLogout==e.getSource()){
            this.buttonLogout();
        }else if(varMain.jmiRegisterEmployee==e.getSource()){
            this.buttonRegisterEmployee();
        }else if(varMain.jmiRegisterMySQL==e.getSource()){
            this.buttonRegisterMySQL();
        }else if(varMain.jbtBeverageWerehouse==e.getSource()){
            this.buttonBeverageWerehouse();
        }else if(varMain.jbtStatistics==e.getSource()){
            this.buttonStatistics();
        }else if(varMain.jbtMakeOrder==e.getSource()){
            this.buttonMakeOrder();
        }else if(varMain.jbtOrders==e.getSource()){
            this.buttonOrders();
        }else if(varMain.jbtMenu==e.getSource()){
            this.buttonMenu();
        }
    }
    
    private void buttonUpdateListOrders(){
        this.dao.showDataFrame(3, varMain.jtTableOrders, "");
        JOptionPane.showMessageDialog(null, "Lista actualizada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
    }
    
    private void buttonPerformOrder(){
        if(varMain.jtTableListOrder.getRowCount()>0){
            String id_order=SourceCodes.getInstance().getWordRandom();
            for(int i=0;i<listOrders.size();i++){dao.insertDataTableRegisterOrders(listOrders.get(i),id_order);}
            this.dao.printReportRegisterOrder(costTotal,id_order);
            this.costTotal=null;
            this.listOrders=new ArrayList<>();
            this.list=new ArrayList<>();
            ((DefaultTableModel)varMain.jtTableListOrder.getModel()).getDataVector().removeAllElements();
            ((DefaultTableModel)varMain.jtTableListOrder.getModel()).fireTableDataChanged();
            this.varMain.jtfCostTotalOrder.setText(null);
            this.dao.showDataFrame(3, varMain.jtTableOrders, "");
        }else{
            JOptionPane.showMessageDialog(null, "Error: Lista de pedidos está vacía.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonPrintMenu(){
        this.dao.printReportMenus();
    }
    
    private void buttonNewMenu(){
        this.reset(1);
    }
    
    private void buttonCancelMenu(){
        this.reset(1);
    }
    
    private void buttonModifyMenu(){
        if(varMain.jcbCategoryAllowedMenu.getSelectedIndex()!=0){
            if(!varMain.jtfIDMenu.getText().equalsIgnoreCase("")){
                if(!varMain.jtfNameMenu.getText().equalsIgnoreCase("")){
                    if(!varMain.jtfCostMenu.getText().equalsIgnoreCase("")){
                        if(varMain.jrbEnabledMenu.isSelected()== true || varMain.jrbDisabledMenu.isSelected()==true){
                            if(path1!=null){
                                try {
                                    String category=varMain.jcbCategoryAllowedMenu.getSelectedItem().toString();
                                    String id=varMain.jtfIDMenu.getText();
                                    String name=varMain.jtfNameMenu.getText();
                                    double cost=Double.parseDouble(varMain.jtfCostMenu.getText());
                                    boolean allowed=false;
                                    if(varMain.jrbEnabledMenu.isSelected()==true){
                                        allowed=true;
                                    }else if(varMain.jrbDisabledMenu.isSelected()==true){
                                        allowed=false;
                                    }
                                    File file=new File(path1);
                                    FileInputStream fis=new FileInputStream(file);
                                    ModelProductMenu mpm=new ModelProductMenu(id,name,category,cost,fis,allowed);
                                    if(dao.updateDataTableRegisterMenu(0, mpm)==true && dao.updateDataTableRegisterMenu(1, mpm)==true){
                                        JOptionPane.showMessageDialog(null, "Menú actualizado con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                        this.dao.showDataFrame(0, varMain.jtTableMenu, "");
                                        this.dao.showDataFrame(4, varMain.jtTableListMenusOrder, "");
                                        this.reset(1);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: Menú actualizado con éxito, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else{
                                String category=varMain.jcbCategoryAllowedMenu.getSelectedItem().toString();
                                String id=varMain.jtfIDMenu.getText();
                                String name=varMain.jtfNameMenu.getText();
                                double cost=Double.parseDouble(varMain.jtfCostMenu.getText());
                                boolean allowed=false;
                                if(varMain.jrbEnabledMenu.isSelected()==true){
                                    allowed=true;
                                }else if(varMain.jrbDisabledMenu.isSelected()==true){
                                    allowed=false;
                                }
                                ModelProductMenu mpm=new ModelProductMenu(id,name,category,cost,allowed);
                                if(dao.updateDataTableRegisterMenu(0, mpm)==true && dao.updateDataTableRegisterMenu(2, mpm)==true && dao.updateDataTableRegisterMenu(3, mpm)==true){
                                    JOptionPane.showMessageDialog(null, "Menú actualizado con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                    this.dao.showDataFrame(0, varMain.jtTableMenu, "");
                                    this.dao.showDataFrame(4, varMain.jtTableListMenusOrder, "");
                                    this.reset(1);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Menú actualizado con éxito, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Disponibilidad no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Costo no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Nombre de menú no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: ID no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Categoría no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonRegisterMenu(){
        if(varMain.jcbCategoryAllowedMenu.getSelectedIndex()!=0){
            if(!varMain.jtfIDMenu.getText().equalsIgnoreCase("")){
                if(!varMain.jtfNameMenu.getText().equalsIgnoreCase("")){
                    if(!varMain.jtfCostMenu.getText().equalsIgnoreCase("")){
                        if(varMain.jrbEnabledMenu.isSelected()== true || varMain.jrbDisabledMenu.isSelected()==true){
                            if(!path1.equalsIgnoreCase("")){
                                try {
                                    String category=varMain.jcbCategoryAllowedMenu.getSelectedItem().toString();
                                    String id=varMain.jtfIDMenu.getText();
                                    String name=varMain.jtfNameMenu.getText();
                                    double cost=Double.parseDouble(varMain.jtfCostMenu.getText());
                                    boolean allowed=false;
                                    if(varMain.jrbEnabledMenu.isSelected()==true){
                                        allowed=true;
                                    }else if(varMain.jrbDisabledMenu.isSelected()==true){
                                        allowed=false;
                                    }
                                    File file=new File(path1);
                                    FileInputStream fis=new FileInputStream(file);
                                    ModelProductMenu mpm=new ModelProductMenu(id,name,category,cost,fis,allowed);
                                    if(CreateFile.getInstance().isMySQLStatus()==true){
                                        if(dao.verifyMenuIfExistsByID(id)==false){
                                            if(dao.insertDataTableRegisterMenu(mpm)==true){
                                                JOptionPane.showMessageDialog(null, "Menú registrada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                                this.dao.showDataFrame(0, varMain.jtTableMenu, "");
                                                this.dao.showDataFrame(4, varMain.jtTableListMenusOrder, "");
                                                this.reset(1);
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Error: No se pudo registrar el menú, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error: ID del menú ya ha sido registrado anteriormente, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Erro: MySQL no registrado.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Imagen del menú no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error3x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Disponibilidad no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Costo no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Nombre de menú no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: ID no ingresado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Categoría no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonRegisterCategoryMenu(){
        boolean status=false;
        if(CreateFile.getInstance().isMySQLStatus()==true){
            while(status==false){
                String options=String.valueOf(JOptionPane.showInputDialog(null, "Seleccione una opción:\n1.- Agregar nueva categoría.\n2.- Actualizar observación de una categoría.\n3.- Remover categoría.", "Registro de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                if(!options.equalsIgnoreCase("null")){
                    if(options.equalsIgnoreCase("1")){
                        String category=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese categoría nueva:", "Registro de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                        if(!category.equalsIgnoreCase("null")){
                            if(dao.verifyCategoryMenuExists(category)==false){
                                String observation=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese observación de la categoría:", "Registro de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                                if(!observation.equalsIgnoreCase("null")){
                                    if(dao.insertDataTableRegisterCategoryMenu(category, observation)==true){
                                        JOptionPane.showMessageDialog(null, "Categoría registrada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                        SourceCodes.getInstance().addItemComboBox(varMain.jcbCategoryAllowedMenu, dao.getListCategoryMenus());
                                        new Thread(){@Override public void run(){try {Thread.sleep(100);varMain.jpMenu1.setLocation(13, varMain.jpMenu1.getY());} catch (Exception e) {e.printStackTrace();}}}.start();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: No se pudo registrar la categoría, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Observación no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Categoría ingresada ya existente, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Categoría a registrar no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else if(options.equalsIgnoreCase("2")){
                        String category=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese categoría a modificar:", "Actualización de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                        if(!category.equalsIgnoreCase("null")){
                            if(dao.verifyCategoryMenuExists(category)==true){
                                String observation=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese observación a actualizar:", "Actualización de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                                if(!observation.equalsIgnoreCase("null")){
                                    if(dao.updateDataTableRegisterCategoryMenu(category, observation)==true){
                                        JOptionPane.showMessageDialog(null, "Categoría actualizada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: No se pudo actualizar la categoría, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Observación no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Categoría ingresada no encontrada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Categoría a actualizar no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else if(options.equalsIgnoreCase("3")){
                        String category=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese categoría a eliminar:", "Remover categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                        if(!category.equalsIgnoreCase("null")){
                            if(dao.verifyCategoryMenuExists(category)==true){
                                if(dao.removeRowTableRegisterCategoryMenu(category)==true){
                                    JOptionPane.showMessageDialog(null, "Categoría removida con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                    this.varMain.jcbCategoryAllowedMenu.removeItem(category);
                                    new Thread(){@Override public void run(){try {Thread.sleep(50);varMain.jpMenu1.setLocation(13, varMain.jpMenu1.getY());} catch (Exception e) {e.printStackTrace();}}}.start();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Categoría no removida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Categoría ingresada no registrada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32xs32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Categoría a eliminar no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Opción ingresada no valida, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    status=true;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: MySQL no establecida.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonExamineMenu(){
        JFileChooser jfc=new JFileChooser();
        boolean status=false;
        while(status==false){
            if(jfc.showDialog(varMain, "Seleccione foto (JPG, PNG o GIF)")==JFileChooser.APPROVE_OPTION){
                File file=jfc.getSelectedFile();
                if(file.canRead()){
                    if(file.getName().endsWith("jpg") || file.getName().endsWith("png") || file.getName().endsWith("gif")){
                        new Thread(){
                            @Override
                            public void run(){
                                try {
                                    path1=jfc.getSelectedFile().getAbsolutePath();
                                    ImageIcon img=new ImageIcon(path1);
                                    JOptionPane.showMessageDialog(null, "Tamaño de la imagen "+img.getIconWidth()+"x"+img.getIconHeight()+"\nSe ajustará a 250x140", "Advertencia", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    varMain.jlImageMenu.setIcon(new ImageIcon(img.getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT)));
                                    Thread.sleep(100);
                                    varMain.jpMenu1.setLocation(13, varMain.jpMenu1.getY());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        status=true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Archivo seleccionado no admitido, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: No se puede leer el archivo seleccionado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                status=true;
            }
        }
    }
    
    private void buttonPrintDrink(){
        this.dao.printReportDrinks();
    }
    
    private void buttonNewDrink(){
        this.reset(5);
    }
    
    private void buttonCancelDrink(){
        this.reset(5);
    }
    
    private void buttonModifyDrink(){
        if(varMain.jcbCategoryAllowedDrink.getSelectedIndex()!=0){
            if(!varMain.jtfIDDrink.getText().equalsIgnoreCase("")){
                if(!varMain.jtfNameDrink.getText().equalsIgnoreCase("")){
                    if(Integer.parseInt(varMain.jsCantDrink.getValue().toString())>0){
                        if(!varMain.jtfCostDrink.getText().equalsIgnoreCase("")){
                            String category=varMain.jcbCategoryAllowedDrink.getSelectedItem().toString();
                            String id=varMain.jtfIDDrink.getText();
                            String name=varMain.jtfNameDrink.getText();
                            int cant=Integer.parseInt(varMain.jsCantDrink.getValue().toString());
                            double cost=Double.parseDouble(varMain.jtfCostDrink.getText());
                            
                            if(path==null){
                                int confirm=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere modificar la bebida sin modificar la imagen de la bebida?", "Confirmar", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                                if(confirm==0){
                                    confirm=JOptionPane.showConfirmDialog(null, "¿Deseas agregar la cantidad ingresada a la cantidad actual de bebidas?\nSi: Agregar.\nNo: Sustituir.", "Confirmar", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                                    if(confirm==0){
                                        cant=dao.getCantDrinksByID(id)+cant;
                                        ModelProductDrink mpd=new ModelProductDrink(category,id,name,cant,cost);
                                        if(dao.updateDataTableRegisterDrinks(0, mpd)==true){
                                            JOptionPane.showMessageDialog(null, "Bebida modificada con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                            this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
                                            this.dao.showDataFrame(5, varMain.jtTableListDrinksOrder, "");
                                            this.reset(5);
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error: No se pudo modificar la bebida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    }else if(confirm==1){
                                        ModelProductDrink mpd=new ModelProductDrink(category,id,name,cant,cost);
                                        if(dao.updateDataTableRegisterDrinks(0, mpd)==true){
                                            JOptionPane.showMessageDialog(null, "Bebida modificada con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                            this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
                                            this.dao.showDataFrame(5, varMain.jtTableListDrinksOrder, "");
                                            this.reset(5);
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error: No se pudo modificar la bebida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    }
                                }else if(confirm==1){
                                    JOptionPane.showMessageDialog(null, "Dato: Debe ubicar la imagen de la bebida para poder actualizar.\nPor favor de click en el boton 'Examinar' para buscar la imagen.", "Advertencia", 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                                }
                            }else{
                                try {
                                    File file=new File(path);
                                    FileInputStream fis=new FileInputStream(file);
                                    int confirm=JOptionPane.showConfirmDialog(null, "¿Deseas agregar la cantidad ingresada a la cantidad actual de bebidas?\nSi: Agregar.\nNo: Sustituir.", "Confirmar", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                                    if(confirm==0){
                                        cant=dao.getCantDrinksByID(id)+cant;
                                        ModelProductDrink mpd=new ModelProductDrink(category,id,name,cant,cost,fis);
                                        if(dao.updateDataTableRegisterDrinks(0, mpd)== true && dao.updateDataTableRegisterDrinks(1, mpd)==true){
                                            JOptionPane.showMessageDialog(null, "Bebida modificada con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                            this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
                                            this.dao.showDataFrame(5, varMain.jtTableListDrinksOrder, "");
                                            this.reset(5);
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error: No se pudo modificar la bebida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    }else if(confirm==1){
                                        ModelProductDrink mpd=new ModelProductDrink(category,id,name,cant,cost,fis);
                                        if(dao.updateDataTableRegisterDrinks(0, mpd)== true && dao.updateDataTableRegisterDrinks(1, mpd)==true){
                                            JOptionPane.showMessageDialog(null, "Bebida modificada con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                            this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
                                            this.dao.showDataFrame(5, varMain.jtTableListDrinksOrder, "");
                                            this.reset(5);
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error: No se pudo modificar la bebida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Costo no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Cantidad ingresada no valida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Nombre de la bebida no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: ID no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Categoría no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonRegisterDrink(){
        if(varMain.jcbCategoryAllowedDrink.getSelectedIndex()!=0){
            if(!varMain.jtfIDDrink.getText().equalsIgnoreCase("")){
                if(!varMain.jtfNameDrink.getText().equalsIgnoreCase("")){
                    if(Integer.parseInt(varMain.jsCantDrink.getValue().toString())>0){
                        if(!varMain.jtfCostDrink.getText().equalsIgnoreCase("")){
                            if(varMain.jlImageDrink.getIcon()!=null){
                                if(!path.equalsIgnoreCase("")){
                                    try {
                                        String id=varMain.jtfIDDrink.getText();
                                        String category=varMain.jcbCategoryAllowedDrink.getSelectedItem().toString();
                                        String name=varMain.jtfNameDrink.getText();
                                        int cant=Integer.parseInt(varMain.jsCantDrink.getValue().toString());
                                        double cost=Double.parseDouble(varMain.jtfCostDrink.getText());
                                        File file=new File(path);
                                        FileInputStream fis=new FileInputStream(file);
                                        ModelProductDrink mpd=new ModelProductDrink(category, id, name, cant, cost, fis);
                                        if(CreateFile.getInstance().isMySQLStatus()==true){
                                            if(dao.verifyDrinkIfExistsByID(id)==false){
                                                if(dao.insertDataTableRegisterDrinks(mpd)==true){
                                                    JOptionPane.showMessageDialog(null, "Bebida registrada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                                    this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
                                                    this.dao.showDataFrame(5, varMain.jtTableListDrinksOrder, "");
                                                    this.reset(5);
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Error: No se pudo registrar la bebida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Error: ID de la bebida ya ha sido registrada anteriormente, vuelva a intentarlo o modifique ubicandolo en la tabla.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Erro: MySQL no registrado.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Imagen de la bebida no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }    
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Imagen de la bebida no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Costo no ingresado, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Cantidad ingresada no valida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Nombre de la bebida no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: ID no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: Categoría no seleccionada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonRegisterCategoryDrink(){
        boolean status=false;
        if(CreateFile.getInstance().isMySQLStatus()==true){
            while(status==false){
                String options=String.valueOf(JOptionPane.showInputDialog(null, "Seleccione una opción:\n1.- Agregar nueva categoría.\n2.- Actualizar observación de una categoría.\n3.- Remover categoría.", "Registro de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                if(!options.equalsIgnoreCase("null")){
                    if(options.equalsIgnoreCase("1")){
                        String category=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese categoría nueva:", "Registro de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                        if(!category.equalsIgnoreCase("null")){
                            if(dao.verifyCategoryDrinksExists(category)==false){
                                String observation=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese observación de la categoría:", "Registro de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));                                
                                if(!observation.equalsIgnoreCase("null")){
                                    if(dao.insertDataTableRegisterCategoryDrinks(category, observation)==true){
                                        JOptionPane.showMessageDialog(null, "Categoría registrada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                        SourceCodes.getInstance().addItemComboBox(varMain.jcbCategoryAllowedDrink, dao.getListCategoryDrinks());
                                        new Thread(){@Override public void run(){try {Thread.sleep(50);varMain.jpMenu5.setLocation(13, varMain.jpMenu5.getY());} catch (Exception e) {e.printStackTrace();}}}.start();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: No se pudo registrar la categoría, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Observación no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Categoría ingresada ya existente, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Categoría a registrar no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else if(options.equalsIgnoreCase("2")){
                        
                        String category=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese categoría a modificar:", "Actualización de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                        if(!category.equalsIgnoreCase("null")){
                            if(dao.verifyCategoryDrinksExists(category)==true){
                                String observation=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese observación a actualizar:", "Actualización de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                                if(!observation.equalsIgnoreCase("null")){
                                    if(dao.updateDataTableRegisterCategoryDrinks(category, observation)==true){
                                        JOptionPane.showMessageDialog(null, "Categoría actualizada con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error: No se pudo actualizar la categoría, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Observación no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Categoría ingresada no encontrada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Categoría a actualizar no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else if(options.equalsIgnoreCase("3")){
                        
                        String category=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese categoría a eliminar:", "Actualización de categoría", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
                        if(!category.equalsIgnoreCase("null")){
                            if(dao.verifyCategoryDrinksExists(category)==true){
                                if(dao.removeRowTableRegisterCategoryDrinks(category)==true){
                                    JOptionPane.showMessageDialog(null, "Categoría removida con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                                    this.varMain.jcbCategoryAllowedDrink.removeItem(category);
                                    new Thread(){@Override public void run(){try {Thread.sleep(50);varMain.jpMenu5.setLocation(13, varMain.jpMenu5.getY());} catch (Exception e) {e.printStackTrace();}}}.start();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error: Categoría no removida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: Categoría ingresada no registrada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: Categoría no ingresada, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Opción ingresada no valida, vuelva a intentarlo", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    status=true;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: MySQL no establecida.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
    
    private void buttonExamineDrink(){
        JFileChooser jfc=new JFileChooser();
        boolean status=false;
        while(status==false){
            if(jfc.showDialog(varMain, "Seleccione foto (JPG, PNG o GIF)")==JFileChooser.APPROVE_OPTION){
                File file=jfc.getSelectedFile();
                if(file.canRead()){
                    if(file.getName().endsWith("jpg") || file.getName().endsWith("png") || file.getName().endsWith("gif")){
                        new Thread(){
                            @Override
                            public void run(){
                                try {
                                    path=jfc.getSelectedFile().getAbsolutePath();
                                    ImageIcon img=new ImageIcon(path);
                                    JOptionPane.showMessageDialog(null, "Tamaño de la imagen "+img.getIconWidth()+"x"+img.getIconHeight()+"\nSe ajustará a 250x140", "Advertencia", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                                    varMain.jlImageDrink.setIcon(new ImageIcon(img.getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT)));
                                    Thread.sleep(100);
                                    varMain.jpMenu5.setLocation(13, varMain.jpMenu5.getY());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        status=true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Archivo seleccionado no admitido, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: No se puede leer el archivo seleccionado, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                }
            }else{
                status=true;
            }
        }
    }
    
    private void buttonMenu(){
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu5);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu4);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu3);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu2);
        
        Animations.getInstance().setComponentXRight(-930, 13, 5, 15, varMain.jpMenu1);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu1);
    }
    
    private void buttonOrders(){
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu5);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu4);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu3);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu1);
        
        Animations.getInstance().setComponentXRight(-930, 13, 5, 15, varMain.jpMenu2);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu2);
    }
    
    private void buttonMakeOrder(){
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu5);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu4);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu2);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu1);
        
        Animations.getInstance().setComponentXRight(-930, 13, 5, 15, varMain.jpMenu3);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu3);
    }
    
    private void buttonStatistics(){
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu5);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu3);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu2);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu1);
        
        Animations.getInstance().setComponentXRight(-930, 13, 5, 15, varMain.jpMenu4);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu4);
    }
    
    private void buttonBeverageWerehouse(){
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu4);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu3);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu2);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu1);
        
        Animations.getInstance().setComponentXRight(-930, 13, 5, 15, varMain.jpMenu5);
        Animations.getInstance().setComponentXLeft(13, -930, 5, 15, varMain.jpMenu5);
    }
    
    private void buttonRegisterMySQL(){
        try {
            ControllerRegisterMySQL.getInstance(new ViewRegisterMySQL()).setAccount(account,rol);
            this.varMain.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void buttonLogout(){
        try {
            if(CreateFile.getInstance().isRememberStatus()==true){
                CreateFile.getInstance().saveAccount("", "", false);
                ControllerLogin.getInstance(new ViewLogin());
            }else{
                ControllerLogin.getInstance(new ViewLogin());
            }
            this.varMain.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void buttonRegisterEmployee(){
        try {
            ControllerRegisterEmployee.getInstance(new ViewRegisterEmployee()).setAccount(account,rol);
            this.varMain.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*CLICK TABLES*/
    private void clickTableListDrinkOrder(MouseEvent e){
        int click=varMain.jtTableListDrinksOrder.rowAtPoint(e.getPoint());
        String id=varMain.jtTableListDrinksOrder.getValueAt(click, 0).toString();
        String name=varMain.jtTableListDrinksOrder.getValueAt(click, 1).toString();
        double cost=Double.parseDouble(varMain.jtTableListDrinksOrder.getValueAt(click, 3).toString());
        
        int column=varMain.jtTableListDrinksOrder.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/varMain.jtTableListDrinksOrder.getRowHeight();
        if(row<varMain.jtTableListDrinksOrder.getRowCount() && row>=0 && column<varMain.jtTableListDrinksOrder.getColumnCount() && column>=0){
            Object value=varMain.jtTableListDrinksOrder.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("select")){
                    String cantString=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese la cantidad de "+name+" desea pedir:", "Cantidad", 0, SourceCodes.getInstance().getImage("archivos32x32.png"),null,null)).replaceAll("[^0-9]", "");
                    if(!cantString.isEmpty()){
                        int cant=Integer.parseInt(cantString);
                        cost=cost*cant;
                        ModelRegisterOrder mro=new ModelRegisterOrder(id,name,cant,cost);
                        this.updateTableListOrder(mro);
                        this.varMain.jtTableListDrinksOrder.getSelectionModel().clearSelection();
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Cantidad no admitida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }
            }
        }
    }
    
    private void clickTableListMenusOrder(MouseEvent e){
        int click=varMain.jtTableListMenusOrder.rowAtPoint(e.getPoint());
        String id=varMain.jtTableListMenusOrder.getValueAt(click, 0).toString();
        String menu=varMain.jtTableListMenusOrder.getValueAt(click, 1).toString();
        double cost=Double.parseDouble(varMain.jtTableListMenusOrder.getValueAt(click, 2).toString());
        int column=varMain.jtTableListMenusOrder.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/varMain.jtTableListMenusOrder.getRowHeight();
        if(row<varMain.jtTableListMenusOrder.getRowCount() && row>=0 && column<varMain.jtTableListMenusOrder.getColumnCount() && column>=0){
            Object value=varMain.jtTableListMenusOrder.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("select")){
                    String cantString=String.valueOf(JOptionPane.showInputDialog(null, "Ingrese la cantidad de "+menu+" desea pedir:", "Cantidad", 0, SourceCodes.getInstance().getImage("archivos32x32.png"),null,null)).replaceAll("[^0-9]", "");
                    if(!cantString.isEmpty()){
                        int cant=Integer.parseInt(cantString);
                        cost=cost*cant;
                        ModelRegisterOrder mro=new ModelRegisterOrder(id,menu,cant,cost);
                        this.updateTableListOrder(mro);
                        this.varMain.jtTableListMenusOrder.getSelectionModel().clearSelection();
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Cantidad no admitida, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                    }
                }
            }
        }
    }
    
    private void clickTableDrink(MouseEvent e){
        int click=varMain.jtTableDrinks.rowAtPoint(e.getPoint());
        String category=varMain.jtTableDrinks.getValueAt(click, 0).toString();
        String id=varMain.jtTableDrinks.getValueAt(click, 1).toString();
        String name=varMain.jtTableDrinks.getValueAt(click, 2).toString();
        String cant=varMain.jtTableDrinks.getValueAt(click, 3).toString();
        String cost=varMain.jtTableDrinks.getValueAt(click, 4).toString();
        int column=varMain.jtTableDrinks.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/varMain.jtTableDrinks.getRowHeight();
        if(row<varMain.jtTableDrinks.getRowCount() && row>=0 && column<varMain.jtTableDrinks.getColumnCount() && column>=0){
            Object value=varMain.jtTableDrinks.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("modify")){
                    this.varMain.jcbCategoryAllowedDrink.setSelectedItem(category);
                    this.varMain.jtfIDDrink.setText(id);
                    this.varMain.jtfNameDrink.setText(name);
                    this.varMain.jsCantDrink.setValue(Integer.parseInt(cant));
                    this.varMain.jtfCostDrink.setText(cost);
                    this.varMain.jlImageDrink.setIcon(dao.getImageDrinkByID(id));
                    this.varMain.jbtRegisterDrink.setEnabled(false);
                    this.varMain.jbtModifyDrink.setEnabled(true);
                    this.varMain.jbtCancelDrink.setEnabled(true);
                    this.varMain.jtfIDDrink.setEnabled(false);
                    new Thread(){
                        @Override
                        public void run(){
                            try {
                                Thread.sleep(50);
                                varMain.jpMenu5.setLocation(13, varMain.jpMenu5.getY());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }else if(button.getName().equals("remove")){
                    int confirm=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover la bebida "+name+"?", "Confirmar", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                    if(confirm==0){
                        ModelProductDrink mpd=new ModelProductDrink(id);
                        if(dao.removeRowTableRegisterDrinks(mpd)==true){
                            JOptionPane.showMessageDialog(null, "Bebida removida con éxito.", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                            this.dao.showDataFrame(2, varMain.jtTableDrinks, "");
                            new Thread(){
                                @Override
                                public void run(){
                                    try {
                                        Thread.sleep(50);
                                        varMain.jpMenu5.setLocation(13, varMain.jpMenu5.getY());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }.start();
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: No se pudo remover el producto, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }
                }
            }
        }
    }
    
    private void clickTableMenu(MouseEvent e){
        int click=varMain.jtTableMenu.rowAtPoint(e.getPoint());
        String category=varMain.jtTableMenu.getValueAt(click, 0).toString();
        String id=varMain.jtTableMenu.getValueAt(click, 1).toString();
        String name=varMain.jtTableMenu.getValueAt(click, 2).toString();
        String cost=varMain.jtTableMenu.getValueAt(click, 3).toString();
        boolean status=Boolean.valueOf(varMain.jtTableMenu.getValueAt(click, 5).toString());
        int column=varMain.jtTableMenu.getColumnModel().getColumnIndexAtX(e.getX());
        int row=e.getY()/varMain.jtTableMenu.getRowHeight();
        if(row<varMain.jtTableMenu.getRowCount() && row>=0 && column<varMain.jtTableMenu.getColumnCount() && column>=0){
            Object value=varMain.jtTableMenu.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button=(JButton)value;
                if(button.getName().equals("modify")){
                    this.varMain.jcbCategoryAllowedMenu.setSelectedItem(category);
                    this.varMain.jtfIDMenu.setText(id);
                    this.varMain.jtfNameMenu.setText(name);
                    this.varMain.jtfCostMenu.setText(cost);
                    if(status==true){
                        this.varMain.jrbEnabledMenu.setSelected(true);
                    }else{
                        this.varMain.jrbDisabledMenu.setSelected(true);
                    }
                    this.varMain.jlImageMenu.setIcon(dao.getImageMenuByID(id));
                    this.varMain.jbtRegisterMenu.setEnabled(false);
                    this.varMain.jbtModifyMenu.setEnabled(true);
                    this.varMain.jbtCancelMenu.setEnabled(true);
                    this.varMain.jtfIDMenu.setEnabled(false);
                    new Thread(){
                        @Override
                        public void run(){
                            try {
                                Thread.sleep(50);
                                varMain.jpMenu1.setLocation(13, varMain.jpMenu1.getY());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }else if(button.getName().equals("remove")){
                    int confirm=JOptionPane.showConfirmDialog(null, "¿Seguro que quiere remover el menu "+name+"?", "Confirmar", 0, 0, SourceCodes.getInstance().getImage("archivos32x32.png"));
                    if(confirm==0){
                        ModelProductMenu mpm=new ModelProductMenu(id);
                        if(dao.removeRowTableRegisterMenu(mpm)==true){
                            JOptionPane.showMessageDialog(null, "Menú removido con éxito!", "Éxito", 0, SourceCodes.getInstance().getImage("exito32x32.png"));
                            this.dao.showDataFrame(0, varMain.jtTableMenu, "");
                            new Thread(){
                                @Override
                                public void run(){
                                    try {
                                        Thread.sleep(50);
                                        varMain.jpMenu1.setLocation(13, varMain.jpMenu1.getY());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }.start();
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: No se pudo remover el menú, vuelva a intentarlo.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
                        }
                    }
                }
            }
        }
    }
    /*FIN CLICK TABLES*/
    
    public ControllerMain setAccount(String account,int rol){
        this.account=account;
        this.rol=rol;
        this.runnable();
        return this;
    }
    
    public int getRol(){
        return this.rol;
    }
    
    private void clear(int num){
        if(num==5){
            this.varMain.jcbCategoryAllowedDrink.setSelectedIndex(0);
            this.varMain.jtfIDDrink.setText(null);
            this.varMain.jtfNameDrink.setText(null);
            this.varMain.jsCantDrink.setValue(0);
            this.varMain.jtfCostDrink.setText(null);
            this.varMain.jlImageDrink.setIcon(null);
        }else if(num==1){
            this.varMain.jcbCategoryAllowedMenu.setSelectedIndex(0);
            this.varMain.jtfIDMenu.setText(null);
            this.varMain.jtfNameMenu.setText(null);
            this.varMain.jtfCostMenu.setText(null);
            this.varMain.jlImageMenu.setIcon(null);
            this.varMain.jrbEnabledMenu.setSelected(false);
            this.varMain.jrbDisabledMenu.setSelected(false);
        }
    }
    
    private void updateTableListOrder(ModelRegisterOrder mro){
        JButton bt1=new JButton("Remover");
        bt1.setName("remove");
        Object[] row=new Object[varMain.jtTableListOrder.getColumnCount()];
        if(!list.contains(mro.getId())){
            list.add(mro.getId());
            listOrders.add(mro);
        }else{
            String options=String.valueOf(JOptionPane.showInputDialog(null, "Pedido ya ha sido registrado anteriormente\n¿Desea agregar la nueva cantidad a la cantidad anterior o reemplazarla?\n1.- Si (Agregar)\n2.- No (Reemplazar)", "Confirmación", 0, SourceCodes.getInstance().getImage("archivos32x32.png"), null, null));
            for(int i=0;i<listOrders.size();i++){
                ModelRegisterOrder mroTest=listOrders.get(i);
                if(mroTest.getId().equalsIgnoreCase(mro.getId())){
                    if(options.equalsIgnoreCase("1")){
                        mroTest.setCant(mroTest.getCant()+mro.getCant());
                        mroTest.setCost(mroTest.getCost()+mro.getCost());
                    }else if(options.equalsIgnoreCase("2")){
                        mroTest.setCant(mro.getCant());
                        mroTest.setCost(mro.getCost());
                    }
                }
            }
        }
        ((DefaultTableModel)varMain.jtTableListOrder.getModel()).getDataVector().removeAllElements();
        ((DefaultTableModel)varMain.jtTableListOrder.getModel()).fireTableDataChanged();
        double count=0;
        for(int i=0;i<listOrders.size();i++){
            ModelRegisterOrder mroTest=listOrders.get(i);
            count=count+mroTest.getCost();
            row[0]=mroTest.getId();
            row[1]=mroTest.getName();
            row[2]=mroTest.getCant();
            row[3]=mroTest.getCost();
            row[4]=bt1;
            dtm.addRow(row);
        }
        DecimalFormat df=new DecimalFormat("#.00");
        this.costTotal=df.format(count);
        this.varMain.jtfCostTotalOrder.setText(df.format(count));
        this.varMain.jtTableListOrder.setModel(dtm);
    }
    
    private void loadDefaultTableModel(){
        this.varMain.jtTableListOrder.setDefaultRenderer(Object.class, new AccesoryTable());
        String[] columns=new String[varMain.jtTableListOrder.getColumnCount()];
        for(int i=0;i<columns.length;i++){
            columns[i]=varMain.jtTableListOrder.getModel().getColumnName(i);
        }
        dtm=new DefaultTableModel(null,columns){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column==0){
                    return false;
                }else{
                    return false;
                }
            }
        };
    }
    
    private void reset(int num){
        if(num==1){
            this.clear(num);
            this.varMain.jtfIDMenu.setEnabled(true);
            this.varMain.jbtModifyMenu.setEnabled(false);
            this.varMain.jbtCancelMenu.setEnabled(false);
            this.varMain.jbtRegisterMenu.setEnabled(true);
            this.path1=null;
            new Thread(){@Override public void run(){try {Thread.sleep(50);varMain.jpMenu1.setLocation(13, varMain.jpMenu1.getY());} catch (Exception e) {e.printStackTrace();}}}.start();
        }else if(num==5){
            this.clear(num);
            this.path=null;
            this.varMain.jbtRegisterDrink.setEnabled(true);
            this.varMain.jbtModifyDrink.setEnabled(false);
            this.varMain.jbtCancelDrink.setEnabled(false);
            this.varMain.jtfIDDrink.setEnabled(true);
            new Thread(){@Override public void run(){try {Thread.sleep(50);varMain.jpMenu5.setLocation(13, varMain.jpMenu5.getY());} catch (Exception e) {e.printStackTrace();}}}.start();
        }
    }
}
