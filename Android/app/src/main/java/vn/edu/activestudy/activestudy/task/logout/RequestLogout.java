package vn.edu.activestudy.activestudy.task.logout;

/**
 * Created by dell123 on 8/28/2015.
 */
public class RequestLogout {
    @SuppressWarnings("sessionId")
    private String sessionId;
    @SuppressWarnings("accountId")
    private String accountId;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
