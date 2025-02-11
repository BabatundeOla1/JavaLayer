package data.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
 public class ItemTest {

    @Test
    public void testThatItemIsEmpty(){
        Item item =new Item("Item", 01);
        assertEquals(0, item.count());
    }

     @Test
     public void testThatISaveItem(){
         Item item = new Item("Item", 01);
         Item savedItem = item.save(new Item("Item", 01));
         assertNotNull(savedItem);
     }



     @Test
     public void testThatICanDeleteItem(){
         Item item = new Item("Item", 01);
         Item item2= new Item("Item", 02);
         item.save(item);
         item.save(item2);
         assertEquals(2, item.count());

         item.deletItem(item.getId());
         assertEquals(1, item.count());
     }

     @Test
     public void testFindItemById() {
         Item item = new Item("Item", 01);
         Item savedItem = item.save(item);
         Item foundItem = item.findItemById(1);
         assertEquals(savedItem, foundItem);
     }

     @Test
     public void testThatAllItemsCanBeDeleted(){
         Item item = new Item("Item", 01);
         Item item1 = new Item("Item", 02);
         Item savedItem = item.save(item);
         Item savedItem2 = item.save(item1);
         assertEquals(2, item.count());

         item.deleteAllItem(item.getId(), item1.getId());
         assertEquals(0, item.count());

     }

//     @Test
//     public void addItem_findItemById_UpdateItemTest() {
//         Item items = new Item("Item", 01);
//         assertEquals(0,items.count());
//
//         Item savedItem = items.save(new Item("phone",50));
//         assertEquals(1,items.count());
//
//         int savedItemId = savedItem.getId();
//         int saveItemWeight = savedItem.getWeightInGram();
//
//         Item foundItem = items.findItemById(savedItem.getId());
//         foundItem.setWeightInGram(100);
//         items.save(foundItem);
//         assertEquals(1,items.count());
//         assertEquals(savedItemId,foundItem.getId());
//     }

}