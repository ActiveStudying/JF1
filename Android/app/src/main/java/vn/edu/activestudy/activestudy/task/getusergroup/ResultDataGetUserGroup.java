package vn.edu.activestudy.activestudy.task.getusergroup;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.GroupEntity;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataGetUserGroup {
    @SerializedName("listGroupUser")
    private GroupEntity listGroupUser;

    public GroupEntity getListGroupUser() {
        return listGroupUser;
    }

    public void setListGroupUser(GroupEntity listGroupUser) {
        this.listGroupUser = listGroupUser;
    }
}
