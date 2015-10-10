package vn.edu.activestudy.activestudy.task.sentmessage;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.ConfestionEntity;
import vn.edu.activestudy.activestudy.model.entity.MessageEntity;

/**
 * Created by dell123 on 05/10/2015.
 */
public class RequestSentMessage {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("messageData")
    private MessageEntity messageData;

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

    public MessageEntity getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageEntity messageData) {
        this.messageData = messageData;
    }
}
