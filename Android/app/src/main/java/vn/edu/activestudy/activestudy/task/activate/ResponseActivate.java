package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseActivate {

    @SerializedName("Result")
    private Result result;

    @SerializedName("ResultData")
    private ResultDataActivate resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataActivate getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
