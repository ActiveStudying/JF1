package vn.edu.activestudy.activestudy.task.createcourse;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.CourseEntity;

/**
 * Created by dell123 on 02/10/2015.
 */
public class RequestCreateCourse {

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("courseData")
    private CourseEntity courseData;

    public CourseEntity getCourseData() {
        return courseData;
    }

    public void setCourseData(CourseEntity courseData) {
        this.courseData = courseData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
