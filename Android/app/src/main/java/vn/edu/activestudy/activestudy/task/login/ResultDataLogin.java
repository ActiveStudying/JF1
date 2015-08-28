package vn.edu.activestudy.activestudy.task.login;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Resultdata;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataLogin extends Resultdata {
    @SerializedName("session-id")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }
}
