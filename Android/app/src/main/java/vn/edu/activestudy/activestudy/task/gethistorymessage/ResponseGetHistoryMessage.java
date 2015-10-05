package vn.edu.activestudy.activestudy.task.gethistorymessage;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.getlistclass.ResultDataGetListClass;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseGetHistoryMessage {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetHistoryMessage resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataGetHistoryMessage getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataGetHistoryMessage resultData) {
        this.resultData = resultData;
    }
}
