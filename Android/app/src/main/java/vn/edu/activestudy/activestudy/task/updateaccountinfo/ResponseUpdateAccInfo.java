package vn.edu.activestudy.activestudy.task.updateaccountinfo;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.login.ResultDataLogin;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseUpdateAccInfo {
    @SerializedName("Result")
    private Result result;

    @SerializedName("ResultData")
    private ResultDataUpdateAccInfo resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataUpdateAccInfo getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataUpdateAccInfo resultData) {
        this.resultData = resultData;
    }
}
