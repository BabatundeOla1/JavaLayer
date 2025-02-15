package service;

import data.model.Item;
import data.repositories.Items;
import data.repositories.TrackingInfos;

public class ItemServicesImplementation implements ItemServices{

    private Items itemRepository = new Items();
    private TrackingInfos trackingInfoRepository = new TrackingInfos();
    @Override
    public Item createItem(Item item) {
        Item saveItem = itemRepository.save(item);
        return null;
    }
}
