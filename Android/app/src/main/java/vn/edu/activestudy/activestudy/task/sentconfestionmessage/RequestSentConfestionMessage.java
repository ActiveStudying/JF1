package vn.edu.activestudy.activestudy.task.sentconfestionmessage;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.ConfestionEntity;

/**
 * Created by dell123 on 02/10/2015.
 */
public class RequestSentConfestionMessage {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("dataConfestionMessage")
    private ConfestionEntity dataConfestionMessage;

    public ConfestionEntity getDataConfestionMessage() {
        return dataConfestionMessage;
    }

    public void setDataConfestionMessage(ConfestionEntity dataConfestionMessage) {
        this.dataConfestionMessage = dataConfestionMessage;
    }

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
}
