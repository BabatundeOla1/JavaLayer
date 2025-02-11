package data.model;

import java.util.ArrayList;

public class Item {
    private String name;
    private int weightInGram;
    private int Id;
    private String description;
    private int count;
    private ArrayList<Item> items = new ArrayList<>();

    public Item(String name, int id) {
        this.name = name;
        Id = id;
    }

    public int getWeightInGram() {
        return weightInGram;
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

    public int count() {
        return count;
    }

    public Item save(Item item) {
        count++;
        items.add(item);
        return item;
    }

    public void deletItem(int id) {
        for (Item item : items) {
            if (item.getId() == id)
                items.remove(id);
                count--;
        }
    }

    public Item findItemById(int targetId) {
        for (Item item : items) {
            if (item.getId() == targetId) {
                return item;
            }
        }
        return null;
    }

    public void deleteAllItem(int ... args) {
        for (int id : args){
            deletItem(id);
        }
    }

    public Item updateItem(Item item) {
        if(isNew(item)) {
            item.setId(generateId());
            items.add(item);
            return item;
        }
        Item existingItem = findItemById(item.getId());
        existingItem.setWeightInGram(item.getWeightInGram());
        existingItem.setDescription(item.getDescription());
        return existingItem;
    }

    private boolean isNew(Item item) {
        return item.getId() == 0;
    }

    private int generateId(){
        return ++count;
    }
}