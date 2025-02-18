package data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
public class TrackingInfo {

    private int itemId;
    private int id;
    private String description;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "Date And Time = " + getLocalDateTime() + " \n" +
                " Item Id = " + getItemId() + " \n" +
                " Description =  " + getDescription() + " \n" +
                " Item Tracking Id = " + getId() +
                " \n";
    }
}
