package net.selfish.mvc.model;

public class ModelRegisterOrder {
    
    private String id,name;
    private int cant;
    private double cost;
    
    public ModelRegisterOrder(String id){
        this.id=id;
    }

    public ModelRegisterOrder(String id, String name, int cant, double cost) {
        this.id = id;
        this.name = name;
        this.cant = cant;
        this.cost = cost;
    }
    
    public boolean contains(Object data){
        boolean status=false;
        if(id.equalsIgnoreCase(data.toString())){
            status=true;
        }else{
            status=false;
        }
        return status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
}
