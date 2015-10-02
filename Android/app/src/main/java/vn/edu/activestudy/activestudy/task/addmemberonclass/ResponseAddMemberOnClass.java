package vn.edu.activestudy.activestudy.task.addmemberonclass;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.createevent.ResultDataCreateEvent;

/**
 * Created by dell123 on 30/09/2015.
 */
public class ResponseAddMemberOnClass {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataAddMemberOnClass resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataAddMemberOnClass getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataAddMemberOnClass resultData) {
        this.resultData = resultData;
    }
}
