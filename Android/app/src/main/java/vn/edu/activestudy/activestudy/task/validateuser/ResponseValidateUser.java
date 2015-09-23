package vn.edu.activestudy.activestudy.task.validateuser;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.updateaccountinfo.ResultDataUpdateAccInfo;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseValidateUser {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataValidateUser resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataValidateUser getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataValidateUser resultData) {
        this.resultData = resultData;
    }
}
