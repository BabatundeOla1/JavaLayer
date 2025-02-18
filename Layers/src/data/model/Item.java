package data.model;

import java.util.ArrayList;

public class Item {
    private String name;
    private int weightInGram;
    private int Id;
    private String description;
//    public Item(String name, int id) {
//        this.name = name;
//        Id = id;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightInGram() {
        return weightInGram;
    }
    public String getName() {
        return name;
    }
    public void setWeightInGram(int weightInGram) {
        this.weightInGram = weightInGram;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Name = " + getName() + " \n" +
                " Weight = " + getWeightInGram() + " \n" +
                " Description =  " + getDescription() + " \n" +
                " Item Id = " + getId() +
                " \n";
    }
}