package vn.edu.activestudy.activestudy.task.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class RequestLogin {
    @SerializedName("authenId")
    private String authenId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("cloudKey")
    private String cloudKey;

    public String getCloudKey() {
        return cloudKey;
    }

    public void setCloudKey(String cloudKey) {
        this.cloudKey = cloudKey;
    }

    public void setAuthenId(String authenId) {
        this.authenId = authenId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAuthenId() {
        return authenId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
