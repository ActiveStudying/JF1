package vn.edu.activestudy.activestudy.task.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class RequestLogin {
    @SerializedName("authen-id")
    private String authenId;

    @SerializedName("account-id")
    private String accountId;

    @SerializedName("device-id")
    private String deviceId;

    public void setAuthenId(String authenId) {
        this.authenId = authenId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
