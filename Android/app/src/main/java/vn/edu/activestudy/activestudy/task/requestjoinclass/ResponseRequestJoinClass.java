package vn.edu.activestudy.activestudy.task.requestjoinclass;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResponseRequestJoinClass {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataRequestJoinClass resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataRequestJoinClass getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataRequestJoinClass resultData) {
        this.resultData = resultData;
    }
}
