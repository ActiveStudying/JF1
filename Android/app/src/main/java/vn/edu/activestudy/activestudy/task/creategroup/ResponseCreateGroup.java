package vn.edu.activestudy.activestudy.task.creategroup;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 01/10/2015.
 */
public class ResponseCreateGroup {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataCreateGroup resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataCreateGroup getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataCreateGroup resultData) {
        this.resultData = resultData;
    }
}
