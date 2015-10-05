package vn.edu.activestudy.activestudy.task.requestcreatecourse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 05/10/2015.
 */
public class RequestRequestCreateCourse {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("nameCouse")
    private String nameCouse;

     @SerializedName("content")
    private String content;

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

    public String getNameCouse() {
        return nameCouse;
    }

    public void setNameCouse(String nameCouse) {
        this.nameCouse = nameCouse;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
