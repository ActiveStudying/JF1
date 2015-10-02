package vn.edu.activestudy.activestudy.task.getmemberbymail;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.AccountInfoEntity;

/**
 * Created by dell123 on 01/10/2015.
 */
public class ResultDataGetMemberByMail {

    @SerializedName("accountInfo")
    private AccountInfoEntity accountInfo;

    public AccountInfoEntity getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfoEntity accountInfo) {
        this.accountInfo = accountInfo;
    }
}
