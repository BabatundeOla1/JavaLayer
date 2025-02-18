package service;

import data.model.Item;
import data.model.TrackingInfo;
import data.repositories.Items;
import data.repositories.TrackingInfos;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackingInfoImplementationTest {
    private TrackingInfos trackingInfos = new TrackingInfos();
    TrackingInfoImplementation trackingInfoImplementation = new TrackingInfoImplementation(trackingInfos);
    private Items items = new Items();


    private void setItemsValues(Item item){
        item.setWeightInGram(10);
        item.setName("Book");
        item.setDescription("Blue book");
    }
    @Test
    public void testThatTrackingInfosListIsEmpty(){
        assertEquals(0, trackingInfos.count());
    }
    @Test
    public void testThatYouCanCreateTrackingInfo(){
        Item item = new Item();
        setItemsValues(item);
        items.save(item);
        trackingInfoImplementation.createTrackingInfo(item);
        assertEquals(1, trackingInfos.count());
    }

}