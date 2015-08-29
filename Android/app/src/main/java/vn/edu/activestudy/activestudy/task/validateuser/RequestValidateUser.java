package vn.edu.activestudy.activestudy.task.validateuser;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class RequestValidateUser {
    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
