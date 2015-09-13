package vn.edu.activestudy.activestudy.task.getaccountinfo;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.AccountInfo;
import vn.edu.activestudy.activestudy.model.Expect;
import vn.edu.activestudy.activestudy.model.Skill;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResultDataGetAccountInfo {

    @SerializedName("AccountInfo")
    private AccountInfo accountInfo;

    @SerializedName("Skill")
    private Skill skill;

    @SerializedName("Expect")
    private Expect expect;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public Skill getSkill() {
        return skill;
    }

    public Expect getExpect() {
        return expect;
    }
}
