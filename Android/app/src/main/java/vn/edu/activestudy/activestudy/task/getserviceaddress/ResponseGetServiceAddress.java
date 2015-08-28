package vn.edu.activestudy.activestudy.task.getserviceaddress;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.activateOTP.ResultDataActivateOtp;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseGetServiceAddress {
    @SerializedName("Result")
    private Result result;

    @SerializedName("ResultData")
    private ResultDataGetServiceAddress resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataGetServiceAddress getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataGetServiceAddress resultData) {
        this.resultData = resultData;
    }
}
