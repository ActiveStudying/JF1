package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.DeviceInfo;

/**
 * Created by dell123 on 8/24/2015.
 */
public class RequestActivate {

    @SerializedName("account-id")
    private String accountId;

    @SerializedName("device-info")
    private DeviceInfo deviceInfo;

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
