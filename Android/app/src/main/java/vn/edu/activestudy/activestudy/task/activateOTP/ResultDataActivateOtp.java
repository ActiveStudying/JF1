package vn.edu.activestudy.activestudy.task.activateOTP;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Resultdata;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataActivateOtp extends Resultdata {

    @SerializedName("authen-id")
    private String authenId;

    public String getAuthenId() {
        return authenId;
    }
}
