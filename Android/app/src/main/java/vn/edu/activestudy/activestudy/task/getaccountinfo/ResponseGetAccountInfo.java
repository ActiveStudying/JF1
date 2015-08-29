package vn.edu.activestudy.activestudy.task.getaccountinfo;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.activateOTP.ResultDataActivateOtp;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseGetAccountInfo {
    @SerializedName("Result")
    private Result result;

    @SerializedName("ResultData")
    private ResultDataGetAccountInfo resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataGetAccountInfo getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataGetAccountInfo resultData) {
        this.resultData = resultData;
    }
}
