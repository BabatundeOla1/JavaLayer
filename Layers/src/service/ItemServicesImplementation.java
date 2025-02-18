package service;

import data.model.Item;
import data.repositories.Items;
import data.repositories.TrackingInfos;

public class ItemServicesImplementation implements ItemServices{
    private Items itemsRepository;
    private TrackingInfos trackingInfos = new TrackingInfos();
    TrackingInfoImplementation trackingInfoImplementation = new TrackingInfoImplementation(trackingInfos);

    public ItemServicesImplementation(Items itemsRepository) {
        this.itemsRepository = itemsRepository;
    }
    @Override
    public Item createItem(String itemDescription, int itemWeight) {
        Item newItem = new Item();
        newItem.setDescription(itemDescription);
        newItem.setWeightInGram(itemWeight);
        Item savedItem = itemsRepository.save(newItem);
        trackingInfoImplementation.createTrackingInfo(savedItem);
        return savedItem;
    }
}
