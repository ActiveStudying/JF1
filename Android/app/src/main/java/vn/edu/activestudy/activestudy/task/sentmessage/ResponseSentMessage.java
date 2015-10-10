package vn.edu.activestudy.activestudy.task.sentmessage;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.sentconfestionmessage.ResultDataSentConfestionMessage;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResponseSentMessage {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataSentMessage resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataSentMessage getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataSentMessage resultData) {
        this.resultData = resultData;
    }
}
