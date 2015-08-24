package vn.edu.activestudy.activestudy.task.activate;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dell123 on 8/24/2015.
 */
public class ResponseActivate {

    @SerializedName("response")
    private int response;

    @SerializedName("info")
    private List<Info> listInfo;

    public List<Info> getListInfo() {
        return listInfo;
    }

    public void setListInfo(List<Info> listInfo) {
        this.listInfo = listInfo;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
