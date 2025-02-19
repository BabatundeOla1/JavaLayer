package data.repositories;

import data.model.Item;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ItemsTest {
    Items items = new Items();


    public void setItemValues(Item item){
        item.setName("Book");
        item.setDescription("b");
        item.setWeightInGram(2);
    }
    @Test
    public void testThatItemsListIsEmpty(){
        assertEquals(0, items.count());
    }

    @Test
    public void testThatYouCanSaveItem(){
        Item item = new Item();
        setItemValues(item);
        items.save(item);
        assertEquals(1, items.count());
    }
    @Test
    public void testThatYouCanDeleteItemAfterSaving(){
        Item item = new Item();
        Item secondItem = new Item();
        setItemValues(item);
        setItemValues(secondItem);
        items.save(item);
        items.save(secondItem);
        assertEquals(2, items.count());

        items.deleteItem(secondItem);
        assertEquals(1, items.count());
    }

    @Test
    public void testThatYouCanDeleteItemsById(){
        Item item = new Item();
        Item secondItem = new Item();
        setItemValues(item);
        setItemValues(secondItem);
        items.save(item);
        items.save(secondItem);
        assertEquals(2, items.count());

        items.deleteItemsById(secondItem.getId());
        assertEquals(1, items.count());
    }

    @Test
    public void testThatYouCanDeleteAllItems(){
        Item item = new Item();
        Item secondItem = new Item();
        items.save(item);
        items.save(secondItem);
        assertEquals(2, items.count());

        items.deleteAllItem();
        items.deleteAllItem();
        assertEquals(0, items.count());
    }

    @Test
    public void testThatYouCanFindItemsById(){
        Item item = new Item();
        Item secondItem = new Item();
        items.save(item);
        items.save(secondItem);
        assertEquals(2, items.count());


        assertEquals(item, items.findItemById(item.getId()));
    }
    @Test
    public void testThatYouCanFindItems(){
        Item item = new Item();
        Item secondItem = new Item();
        items.save(item);
        items.save(secondItem);
        assertEquals(2, items.count());


        assertEquals(item, items.findItem(item));
    }
    @Test
    public void testThatItemCanBeUpdated(){
         Item savedItem = new Item();
         items.save(savedItem);
         setItemValues(savedItem);
         assertEquals(1,items.count());

        Item itemToUpdate = items.updateItem(savedItem);
        itemToUpdate.setWeightInGram(10);
        itemToUpdate.setName("Pen");
        itemToUpdate.setDescription("Red Pen");

        assertEquals("Red Pen", savedItem.getDescription());
        System.out.println(savedItem);
    }
}