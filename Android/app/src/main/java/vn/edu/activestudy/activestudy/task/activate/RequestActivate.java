package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.DeviceInfo;

/**
 * Created by dell123 on 8/24/2015.
 */
public class RequestActivate {

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceInfo")
    private DeviceInfo deviceInfo;

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
