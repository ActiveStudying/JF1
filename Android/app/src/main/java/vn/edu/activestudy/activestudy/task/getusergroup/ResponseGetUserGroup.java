package vn.edu.activestudy.activestudy.task.getusergroup;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.getserviceaddress.ResultDataGetServiceAddress;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseGetUserGroup {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetUserGroup resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataGetUserGroup getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataGetUserGroup resultData) {
        this.resultData = resultData;
    }
}
