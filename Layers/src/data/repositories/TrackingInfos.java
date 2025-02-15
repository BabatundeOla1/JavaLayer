package data.repositories;

import data.model.TrackingInfo;

import java.util.ArrayList;

public class TrackingInfos implements TrackingInfoRepo{

    private ArrayList<TrackingInfo> trackingInfos = new ArrayList<>();
    int count = 0;
    @Override
    public int count() {
        return trackingInfos.size();
    }

    @Override
    public TrackingInfo save(TrackingInfo trackingInfo) {
        trackingInfos.add(trackingInfo);
        trackingInfo.setId(generateId());
        return trackingInfo;
    }

    @Override
    public TrackingInfo findTrackingInfoById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos){
            if (trackingInfo.getId() == id){
                return trackingInfo;
            }
        }
        return null;
    }

    private int generateId(){
        count++;
        return count;
    }
    @Override
    public boolean existById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos){
            if (trackingInfo.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos){
            if (trackingInfo.getId() == id){
                trackingInfos.remove(trackingInfo);
            }
        }
    }

    @Override
    public ArrayList<TrackingInfo> saveAll(TrackingInfo... trackingInfo) {
        ArrayList<TrackingInfo> returnTrackingInfo = new ArrayList<>();
        for (TrackingInfo myTrackingInfo : trackingInfo){
            save(myTrackingInfo);
            returnTrackingInfo.add(myTrackingInfo);
        }
        return returnTrackingInfo;
    }

    @Override
    public void delete(TrackingInfo trackingInfo) {
        deleteById(trackingInfo.getId());
    }

    @Override
    public void deleteAllById(int... ids) {
        for (int id : ids){
            deleteById(id);
        }
    }

    @Override
    public TrackingInfo updateTrackingInfo(TrackingInfo trackingInfo) {
        return null;
    }
}
