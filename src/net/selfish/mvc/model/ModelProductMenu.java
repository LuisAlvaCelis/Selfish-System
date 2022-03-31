package net.selfish.mvc.model;

import java.io.FileInputStream;

public class ModelProductMenu {

    private String name,category,id;
    private double cost;
    private FileInputStream image;
    private boolean status;

    public ModelProductMenu(String id, String name, String category, double cost, boolean status) {
        this.id=id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.status=status;
    }
    
    public ModelProductMenu(String id, String name, String category, double cost, FileInputStream image,boolean status) {
        this.id=id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.image = image;
        this.status=status;
    }
    
    public ModelProductMenu(String id,boolean status){
        this.id=id;
        this.status=status;
    }
    
    public ModelProductMenu(String id){
        this.id=id;
    }

    public ModelProductMenu(String id, double cost) {
        this.id=id;
        this.cost = cost;
    }
    
    public ModelProductMenu(String id, FileInputStream image){
        this.id=id;
        this.image=image;
    }
    
    public void setStatus(boolean status){
        this.status=status;
    }
    
    public boolean isStatus(){
        return this.status;
    }
    
    public void setId(String id){
        this.id=id;
    }
    
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
