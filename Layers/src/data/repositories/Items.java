package data.repositories;

import data.model.Item;

import java.util.ArrayList;

public class Items implements ItemRepo{
   private ArrayList<Item> items = new ArrayList<>();
    int count = 0;
    public int count() {
        return items.size();
    }
    public int generateId(){
        count++;
        return count;
    }


    @Override
    public Item save(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    @Override
    public void deleteItem(Item secondItem) {
        items.remove(secondItem);
    }
    @Override
    public void deleteAllItem() {
        items.clear();
    }

    @Override
    public void deleteItemsById(int id) {
        findItemById(id);
        items.remove(id);
    }
    @Override
    public Item findItemById(int id) {
        for (Item myItem : items){
            if (myItem.getId() == (id)){
                return myItem;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
    @Override
    public Item findItem(Item item) {
        for (Item myItem : items){
            if (items.contains(item)){
                return myItem;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
    @Override
    public Item updateItem(Item item){
        Item foundItem = findItem(item);
        foundItem.setWeightInGram(item.getWeightInGram());
        foundItem.setDescription(item.getDescription());
        save(foundItem);
        return foundItem;
    }
}
