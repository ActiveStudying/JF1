package vn.edu.activestudy.activestudy.task.createcourse;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseCreateCourse {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataCreateCourse resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataCreateCourse getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataCreateCourse resultData) {
        this.resultData = resultData;
    }
}
