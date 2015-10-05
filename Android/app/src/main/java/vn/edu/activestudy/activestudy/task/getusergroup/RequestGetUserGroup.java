package vn.edu.activestudy.activestudy.task.getusergroup;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class RequestGetUserGroup {
    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
