package vn.edu.activestudy.activestudy.task.getlistclass;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseGetListClass {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetListClass resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataGetListClass getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataGetListClass resultData) {
        this.resultData = resultData;
    }
}
