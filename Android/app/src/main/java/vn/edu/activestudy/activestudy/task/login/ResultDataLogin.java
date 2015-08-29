package vn.edu.activestudy.activestudy.task.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataLogin {
    @SerializedName("sessionId")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
