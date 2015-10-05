package vn.edu.activestudy.activestudy.task.registercourse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 05/10/2015.
 */
public class RequestRegisterCourse {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("couseId")
    private int couseId;

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

    public int getCouseId() {
        return couseId;
    }

    public void setCouseId(int couseId) {
        this.couseId = couseId;
    }
}
