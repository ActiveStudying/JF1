package vn.edu.activestudy.activestudy.task.addtaskteam;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.TaskEntity;

/**
 * Created by dell123 on 02/10/2015.
 */
public class RequestAddTaskTeam {
    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("task")
    private TaskEntity task;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }
}
