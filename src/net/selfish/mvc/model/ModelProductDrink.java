package net.selfish.mvc.model;

import java.io.FileInputStream;

public class ModelProductDrink {
    
    private String category;
    private String id;
    private String name;
    private int cant;
    private double cost;
    private FileInputStream image;
    
    public ModelProductDrink(String id){
        this.id=id;
    }

    public ModelProductDrink(String id,FileInputStream image){
        this.id=id;
        this.image=image;
    }
    
    public ModelProductDrink(String category, String id, String name, int cant, double cost, FileInputStream image) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.cant = cant;
        this.cost = cost;
        this.image = image;
    }
    
    public ModelProductDrink(String category, String id, String name, int cant, double cost) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.cant = cant;
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public FileInputStream getImage() {
        return image;
    }

    public void setImage(FileInputStream image) {
        this.image = image;
    }
    
    
}
