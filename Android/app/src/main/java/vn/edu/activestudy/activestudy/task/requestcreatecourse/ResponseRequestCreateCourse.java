package vn.edu.activestudy.activestudy.task.requestcreatecourse;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.requestjoinclass.ResultDataRequestJoinClass;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResponseRequestCreateCourse {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataRequestCreateCourse resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataRequestCreateCourse getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataRequestCreateCourse resultData) {
        this.resultData = resultData;
    }
}
