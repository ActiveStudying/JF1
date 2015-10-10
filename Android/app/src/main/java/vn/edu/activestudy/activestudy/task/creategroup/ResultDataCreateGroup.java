package vn.edu.activestudy.activestudy.task.creategroup;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 01/10/2015.
 */
public class ResultDataCreateGroup {

    @SerializedName("groupId")
    private int groupId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
