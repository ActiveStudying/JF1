package vn.edu.activestudy.activestudy.task.getlistmemberongroup;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.Result;
import vn.edu.activestudy.activestudy.task.getlistcourse.ResultDataGetListCourse;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResponseGetListMemberOnGroup {

    @SerializedName("result")
    private Result result;

    @SerializedName("resultData")
    private ResultDataGetListCourse resultData;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultDataGetListCourse getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataGetListCourse resultData) {
        this.resultData = resultData;
    }
}
