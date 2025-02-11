package data.model;

import java.util.ArrayList;
public class TrackingInfo {

    ArrayList<TrackingInfo> trackingInfos = new ArrayList<>();

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int count = 0;
    public int count() {
        return trackingInfos.size();
    }

    public void setCount(int count) {
    }

    public TrackingInfo save(TrackingInfo trackingInfo) {
        if(isNew(trackingInfo)) {
            trackingInfo.setId(generateId());
            trackingInfos.add(trackingInfo);
        }
        return trackingInfo;

    }

    private boolean isNew(TrackingInfo trackingInfo) {
        return trackingInfo.getId() == 0;
    }

    public TrackingInfo findtrackingInfoById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getId() == id) {
                return trackingInfo;
            }
        }
        return null;

    }

    public boolean existById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if(trackingInfo.getId() == id) return true;
        }
        return false;
    }

    public void deleteById(int id) {
        trackingInfos.removeIf(trackingInfo -> trackingInfo.getId() == id);
    }
    public int generateId(){
        return count++;
    }

}
