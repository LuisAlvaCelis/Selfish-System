package net.selfish.mvc.model;

public class ModelRegisterUser {
    
    private String dni,lastnames,names,tel_cel,username,password,email;
    private int idRol;
    
    public ModelRegisterUser(String dni, int idRol,String lastnames,String names,String tel_cel,String username, String password,String email){
        this.dni=dni;
        this.idRol=idRol;
        this.lastnames=lastnames;
        this.names=names;
        this.tel_cel=tel_cel;
        this.username=username;
        this.password=password;
        this.email=email;
    }
    
    public ModelRegisterUser(String dni){
       this.dni=dni;
    }
    
    public ModelRegisterUser(String dni, int idRol){
        this.idRol=idRol;
       this.dni=dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTel_cel() {
        return tel_cel;
    }

    public void setTel_cel(String tel_cel) {
        this.tel_cel = tel_cel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    
}
