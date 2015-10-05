package vn.edu.activestudy.activestudy.task.registercourse;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.requestcreatecourse.ResultDataRequestCreateCourse;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResponseRegisterCourse {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataRegisterCourse resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataRegisterCourse getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataRegisterCourse resultData) {
        this.resultData = resultData;
    }
}
