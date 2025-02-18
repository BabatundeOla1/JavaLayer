package service;

import data.model.Item;
import data.model.TrackingInfo;
import data.repositories.TrackingInfos;

public class TrackingInfoImplementation implements TrackingInfoServices{

    private TrackingInfos trackingInfos;

    public TrackingInfoImplementation(TrackingInfos trackingInfosRepository) {
        this.trackingInfos = trackingInfosRepository;
    }
    @Override
    public TrackingInfo createTrackingInfo(Item item) {
        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfo.setItemId(item.getId());
//        trackingInfo.setDescription(item.getDescription());
        trackingInfos.save(trackingInfo);
        return trackingInfo;
    }

    @Override
    public int getTrackingInfoCount() {
        return trackingInfos.count();
    }

}