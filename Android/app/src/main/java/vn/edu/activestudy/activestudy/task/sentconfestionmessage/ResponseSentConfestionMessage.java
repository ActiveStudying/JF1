package vn.edu.activestudy.activestudy.task.sentconfestionmessage;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseSentConfestionMessage {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataSentConfestionMessage resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataSentConfestionMessage getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataSentConfestionMessage resultData) {
        this.resultData = resultData;
    }
}
