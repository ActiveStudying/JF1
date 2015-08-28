package vn.edu.activestudy.activestudy.task.activateOTP;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.activate.ResultDataActivate;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseActivateOTP {
    @SerializedName("Result")
    private Result result;

    @SerializedName("ResultData")
    private ResultDataActivateOtp resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataActivateOtp getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataActivateOtp resultData) {
        this.resultData = resultData;
    }
}
