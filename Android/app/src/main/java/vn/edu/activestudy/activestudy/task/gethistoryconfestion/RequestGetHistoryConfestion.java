package vn.edu.activestudy.activestudy.task.gethistoryconfestion;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 02/10/2015.
 */
public class RequestGetHistoryConfestion {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("confestionVer")
    private int confestionVer;

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

    public int getConfestionVer() {
        return confestionVer;
    }

    public void setConfestionVer(int confestionVer) {
        this.confestionVer = confestionVer;
    }
}
