package vn.edu.activestudy.activestudy.task.activateOTP;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataActivateOtp {

    @SerializedName("authenId")
    private String authenId;

    public void setAuthenId(String authenId) {
        this.authenId = authenId;
    }

    public String getAuthenId() {
        return authenId;
    }
}
