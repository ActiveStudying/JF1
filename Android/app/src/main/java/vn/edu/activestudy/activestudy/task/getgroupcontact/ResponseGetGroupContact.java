package vn.edu.activestudy.activestudy.task.getgroupcontact;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseGetGroupContact {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetGroupContact resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataGetGroupContact getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataGetGroupContact resultData) {
        this.resultData = resultData;
    }
}
