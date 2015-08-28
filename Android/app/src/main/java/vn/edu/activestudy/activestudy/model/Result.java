package vn.edu.activestudy.activestudy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 8/26/2015.
 */
public class Result {

    @SerializedName("code")
    private int code;

    @SerializedName("description")
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
