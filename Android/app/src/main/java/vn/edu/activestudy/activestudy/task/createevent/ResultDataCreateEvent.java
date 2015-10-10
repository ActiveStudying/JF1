package vn.edu.activestudy.activestudy.task.createevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 30/09/2015.
 */
public class ResultDataCreateEvent {

    @SerializedName("eventId")
    private int eventId;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
