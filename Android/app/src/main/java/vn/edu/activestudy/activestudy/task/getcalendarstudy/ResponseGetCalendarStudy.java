package vn.edu.activestudy.activestudy.task.getcalendarstudy;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.getaccountinfo.ResultDataGetAccountInfo;

/**
 * Created by dell123 on 8/28/2015.
 */
public class ResponseGetCalendarStudy {
    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetCalendarStudy resultData;

    public Result getResult() {
        return result;
    }

    public ResultDataGetCalendarStudy getResultData() {
        return resultData;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setResultData(ResultDataGetCalendarStudy resultData) {
        this.resultData = resultData;
    }
}
