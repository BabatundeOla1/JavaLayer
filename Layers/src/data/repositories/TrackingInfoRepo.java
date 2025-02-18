package data.repositories;

import data.model.TrackingInfo;

import java.util.ArrayList;

public interface TrackingInfoRepo {
    int count();
    TrackingInfo save(TrackingInfo trackingInfo);
    TrackingInfo findTrackingInfoById(int id);
    boolean existById(int id);
    void deleteById(int id);
    ArrayList<TrackingInfo> saveAll(TrackingInfo ... trackingInfos);
    void delete(TrackingInfo trackingInfo);
    void deleteAllById(int ... ids);
    TrackingInfo updateTrackingInfo(TrackingInfo trackingInfo);

}
