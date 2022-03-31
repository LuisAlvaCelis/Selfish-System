package net.selfish.main;

import net.selfish.mvc.controller.ControllerLogin;
import net.selfish.mvc.view.ViewLogin;
import net.selfish.utils.CreateFile;

public class MainClass {

    public static void main(String[] args) throws Exception{
        if(CreateFile.getInstance().createFile()==true){
            ControllerLogin.getInstance(new ViewLogin());
        }else{
            System.out.println("Error: No se pudo crear los archivos, vuelva a intentarlo.");
        }
    }
    
}
