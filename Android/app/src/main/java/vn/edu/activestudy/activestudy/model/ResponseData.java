package vn.edu.activestudy.activestudy.model;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.task.activate.ResultDataActivate;

/**
 * Created by dell123 on 8/27/2015.
 */
public class ResponseData {

    @SerializedName("result")
    private Result result;

    @SerializedName("result-data")
    private Resultdata resultData;

    public Result getResult() {
        return result;
    }

    public Resultdata getResultData() {
        return resultData;
    }


}
