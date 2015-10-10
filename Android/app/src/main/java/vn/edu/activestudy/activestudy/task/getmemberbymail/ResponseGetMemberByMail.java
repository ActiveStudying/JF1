package vn.edu.activestudy.activestudy.task.getmemberbymail;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 01/10/2015.
 */
public class ResponseGetMemberByMail {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetMemberByMail resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataGetMemberByMail getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataGetMemberByMail resultData) {
        this.resultData = resultData;
    }
}
