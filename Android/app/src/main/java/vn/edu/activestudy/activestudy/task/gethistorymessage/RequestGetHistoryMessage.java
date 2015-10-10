package vn.edu.activestudy.activestudy.task.gethistorymessage;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.MessageEntity;

/**
 * Created by dell123 on 02/10/2015.
 */
public class RequestGetHistoryMessage {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("groupID")
    private String groupID;

    @SerializedName("messageId")
    private MessageEntity messageId;

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

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public MessageEntity getMessageId() {
        return messageId;
    }

    public void setMessageId(MessageEntity messageId) {
        this.messageId = messageId;
    }
}
