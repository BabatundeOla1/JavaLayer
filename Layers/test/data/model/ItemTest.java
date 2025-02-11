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
         Item item = new Item("Item2", 01);
         Item savedItem = item.save(new Item("Item2", 02));
         assertNotNull(savedItem);
     }



     @Test
     public void testThatICanDeleteItem(){
         Item item = new Item("Item3", 01);
         Item item2= new Item("Item3", 02);
         item.save(item);
         item.save(item2);
         assertEquals(2, item.count());

         item.deletIteme(item.getId());
         assertEquals(1, item.count());
     }

     @Test
     public void testFindItemById() {
         Item item = new Item("Item4", 01);
         Item savedItem = item.save(item);
         Item foundItem = item.findItemById(1);
         assertEquals(savedItem, foundItem);
     }
     @Test
     public void testThatYouCanUpdateItem() {
         Item item = new Item("Item5", 01);
         Item item1 = new Item("Item6", 02);
         Item updateItem = item.update(item1);
     }

}