package vn.edu.activestudy.activestudy.task.gethistoryconfestion;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.gethistorymessage.ResultDataGetHistoryMessage;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseGetHistoryConfestion {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetHistoryConfestion resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataGetHistoryConfestion getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataGetHistoryConfestion resultData) {
        this.resultData = resultData;
    }
}
