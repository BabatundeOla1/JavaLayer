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

    public void deletIteme(int id) {
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

    public Item update(Item sampleItem) {
        for (Item item : items) {
            if (items.size() > 0) {
                Item sampleItems = items.get(0);
            }
        }
        return null;
    }


}