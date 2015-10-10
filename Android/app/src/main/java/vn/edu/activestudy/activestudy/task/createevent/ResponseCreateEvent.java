package vn.edu.activestudy.activestudy.task.createevent;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.activate.ResultDataActivate;

/**
 * Created by dell123 on 30/09/2015.
 */
public class ResponseCreateEvent {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataCreateEvent resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataCreateEvent getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataCreateEvent resultData) {
        this.resultData = resultData;
    }
}
