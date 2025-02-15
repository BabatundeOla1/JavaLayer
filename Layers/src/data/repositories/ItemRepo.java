package data.repositories;

import data.model.Item;

public interface ItemRepo {

    Item save(Item item);
    void deleteItem(Item secondItem);
    void deleteAllItem();
    void deleteItemsById(int id);
    Item findItemById(int id);
    Item findItem(Item item);
    Item updateItem(Item item);
}
