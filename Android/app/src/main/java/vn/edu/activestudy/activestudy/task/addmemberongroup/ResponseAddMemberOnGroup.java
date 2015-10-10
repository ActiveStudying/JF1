package vn.edu.activestudy.activestudy.task.addmemberongroup;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.addmemberonclass.ResultDataAddMemberOnClass;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseAddMemberOnGroup {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataAddMemberOnGroup resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataAddMemberOnGroup getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataAddMemberOnGroup resultData) {
        this.resultData = resultData;
    }
}
