package vn.edu.activestudy.activestudy.task.addtaskteam;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseAddTaskTeam {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataAddTaskTeam resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataAddTaskTeam getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataAddTaskTeam resultData) {
        this.resultData = resultData;
    }
}
