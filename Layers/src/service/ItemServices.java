package service;

import data.model.Item;

public interface ItemServices {

    Item createItem(String itemDescription, int itemWeight);
}
