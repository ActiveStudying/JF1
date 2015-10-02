package vn.edu.activestudy.activestudy.task.addtaskteam;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResultDataAddTaskTeam {

    @SerializedName("taskId")
    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
