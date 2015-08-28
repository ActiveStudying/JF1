package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.ResponseData;
import vn.edu.activestudy.activestudy.model.Resultdata;

/**
 * Created by dell123 on 8/27/2015.
 */
public class ResultDataActivate extends Resultdata {

    @SerializedName("activation-id")
    private String activationId;

    public String getActivationId() {
        return activationId;
    }
}
