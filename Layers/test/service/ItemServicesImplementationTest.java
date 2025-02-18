package service;

import data.model.Item;
import data.repositories.Items;
import data.repositories.TrackingInfos;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemServicesImplementationTest {

    private Items items = new Items();
    private TrackingInfos trackingInfos = new TrackingInfos();
    TrackingInfoImplementation trackingInfoImplementation = new TrackingInfoImplementation(trackingInfos);

//    @Test
//    public void testThatYouItemsIsEmpty(){
//        assertEquals(0, items.count());
//    }
    @Test
    public void testThatYouCanCreateAnItem(){
        ItemServicesImplementation itemServicesImplementation = new ItemServicesImplementation(items);
        itemServicesImplementation.createItem("Blue Book", 10);
        assertEquals(1, items.count());
    }

    @Test
    public void testThatTrackingInfoGeneratesIdAfterCreatingItem(){
        ItemServicesImplementation itemServicesImplementation = new ItemServicesImplementation(items);
        itemServicesImplementation.createItem("Blue Book", 10);
        assertEquals(1, trackingInfoImplementation.getTrackingInfoCount());
    }




}