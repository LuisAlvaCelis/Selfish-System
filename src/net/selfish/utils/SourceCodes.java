package net.selfish.utils;

import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class SourceCodes {
    
    private static SourceCodes instance;
    private SecureRandom sr;
    
    public SourceCodes(){
        this.sr=new SecureRandom();
    }
    
    public static SourceCodes getInstance(){
        if(instance==null){
            instance=new SourceCodes();
        }
        return instance;
    }
    
    public String getWordRandom(){
        return new BigInteger(50,sr).toString(32);
    }
    
    public void addItemComboBox(JComboBox jcb,List<String> list){
        jcb.removeAllItems();
        jcb.addItem("-- Seleccione --");
        for(int i=0;i<list.size();i++){
            jcb.addItem(list.get(i));
        }
    }
    
    public ImageIcon getImage(String name){
        return new ImageIcon(getClass().getResource("/net/selfish/images/"+name));
    }
    
    public void justNum(KeyEvent e){
        char valid=e.getKeyChar();
        if(Character.isLetter(valid)){
            e.consume();
            JOptionPane.showMessageDialog(null, "Error: Debe colocar solo números, ejemplo: (+51) 987654321.", "Error", 0, SourceCodes.getInstance().getImage("error32x32.png"));
        }
    }
}
