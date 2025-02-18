package service;

import data.model.Item;
import data.model.TrackingInfo;
import data.repositories.TrackingInfos;

public interface TrackingInfoServices {

    TrackingInfo createTrackingInfo(Item item);
    int getTrackingInfoCount();
}
