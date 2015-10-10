package vn.edu.activestudy.activestudy.task.login;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.getserviceaddress.ResultDataGetServiceAddress;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseLogin {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataLogin resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataLogin getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataLogin resultData) {
        this.resultData = resultData;
    }
}
