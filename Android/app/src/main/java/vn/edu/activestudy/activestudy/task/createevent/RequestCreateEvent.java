package vn.edu.activestudy.activestudy.task.createevent;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.EventEntity;

/**
 * Created by dell123 on 30/09/2015.
 */
public class RequestCreateEvent {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("eventData")
    private EventEntity eventData;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventEntity getEventData() {
        return eventData;
    }

    public void setEventData(EventEntity eventData) {
        this.eventData = eventData;
    }
}
