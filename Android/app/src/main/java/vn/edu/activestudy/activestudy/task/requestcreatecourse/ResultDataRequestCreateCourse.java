package vn.edu.activestudy.activestudy.task.requestcreatecourse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dell123 on 05/10/2015.
 */
public class ResultDataRequestCreateCourse {
    @SerializedName("couseID")
    private int couseID;

    public int getCouseID() {
        return couseID;
    }

    public void setCouseID(int couseID) {
        this.couseID = couseID;
    }
}
