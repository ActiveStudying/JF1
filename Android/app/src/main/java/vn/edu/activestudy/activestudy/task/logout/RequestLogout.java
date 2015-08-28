package vn.edu.activestudy.activestudy.task.logout;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/28/2015.
 */
public class RequestLogout {
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

    public String getSessionId() {
        return sessionId;
    }

    public String getAccountId() {
        return accountId;
    }
}
