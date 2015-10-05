package vn.edu.activestudy.activestudy.task.getlistmemberongroup;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import vn.edu.activestudy.activestudy.model.entity.AccountInfoEntity;
import vn.edu.activestudy.activestudy.model.entity.CourseEntity;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResultDataGetListMemberOnGroup {

    @SerializedName("listMember")
    private List<AccountInfoEntity> listMember;

    public List<AccountInfoEntity> getListMember() {
        return listMember;
    }

    public void setListMember(List<AccountInfoEntity> listMember) {
        this.listMember = listMember;
    }
}
