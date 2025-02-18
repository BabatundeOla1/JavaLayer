package data.repositories;

import data.model.TrackingInfo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackingInfosTest {

    @Test
    public void checkThatTrackingInfoIsEmpty(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatCountIncreaseWhenYouCanSaveTrackingInfo(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfos.save(trackingInfo);
        assertEquals(1, trackingInfos.count());
    }
    @Test
    public void testThatYouCanFindTrackingInfoById(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfos.save(trackingInfo);
        assertEquals(1, trackingInfos.count());

        int trackingInfoId = trackingInfo.getId();
        assertEquals(trackingInfo, trackingInfos.findTrackingInfoById(trackingInfoId));
    }

    @Test
    public void testThatItReturnsTrueIfItemExistsByIdInTrackingInfo(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfos.save(trackingInfo);
        assertEquals(1, trackingInfos.count());

        int trackingInfoId = trackingInfo.getId();
        assertTrue(trackingInfos.existById(trackingInfoId));
    }

    @Test
    public void testThatYouCanDeleteTrackingInfoById(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfos.save(trackingInfo);

        TrackingInfo secondTrackingInfo = new TrackingInfo();
        trackingInfos.save(secondTrackingInfo);

        assertEquals(2, trackingInfos.count());

        int trackingInfoId = trackingInfo.getId();
        trackingInfos.deleteById(trackingInfoId);

        assertEquals(1, trackingInfos.count());
    }

    @Test
    public void testThatYouCanSaveMultiplyTrackingInfo(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();

        TrackingInfo secondTrackingInfo = new TrackingInfo();
        TrackingInfo thirdTrackingInfo = new TrackingInfo();
        trackingInfos.saveAll(trackingInfo, secondTrackingInfo, thirdTrackingInfo);

        assertEquals(3, trackingInfos.count());
    }

    @Test
    public void testThatYouCanSaveAndDeleteTrackingInfo(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
        TrackingInfo secondTrackingInfo = new TrackingInfo();
        trackingInfos.saveAll(trackingInfo, secondTrackingInfo);
        assertEquals(2, trackingInfos.count());

        trackingInfos.delete(trackingInfo);
        assertEquals(1, trackingInfos.count());
    }

    @Test
    public void testThatYouCanSaveMultipleTrackingInfos_AndDeleteAll(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
        TrackingInfo secondTrackingInfo = new TrackingInfo();
        TrackingInfo thirdTrackingInfo = new TrackingInfo();
        trackingInfos.saveAll(trackingInfo, secondTrackingInfo, thirdTrackingInfo);
        assertEquals(3, trackingInfos.count());

        int firstTrackingInfoID = trackingInfo.getId();
        int secondTrackingInfoID = secondTrackingInfo.getId();
        int thirdTrackingInfoID = thirdTrackingInfo.getId();

        trackingInfos.deleteAllById(firstTrackingInfoID, secondTrackingInfoID, thirdTrackingInfoID);
        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatYouCanUpdateTrackingInfoAfterItHasBeenSaved(){
        TrackingInfos trackingInfos = new TrackingInfos();
        assertEquals(0, trackingInfos.count());

        TrackingInfo trackingInfo = new TrackingInfo();
         trackingInfos.save(trackingInfo);
        assertEquals(1, trackingInfos.count());

        TrackingInfo updatedTrackingInfo = trackingInfos.updateTrackingInfo(trackingInfo);
        updatedTrackingInfo.setDescription("Green Book");

        assertEquals(1, trackingInfo.getId());
    }
}