package vn.edu.activestudy.activestudy.task.activateOTP;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/26/2015.
 */
public class RequestActivateOTP {

    @SerializedName("otpCode")
    private String otpCode;

    @SerializedName("activationId")
    private String activationId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    public RequestActivateOTP() {
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
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
}
