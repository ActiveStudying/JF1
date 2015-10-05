package vn.edu.activestudy.activestudy.task.getlistcourse;

import com.google.gson.annotations.SerializedName;

import vn.edu.activestudy.activestudy.model.entity.CourseEntity;

/**
 * Created by dell123 on 02/10/2015.
 */
public class ResultDataGetListCourse {

    @SerializedName("courseList")
    private CourseEntity courseList;


    public CourseEntity getCourseList() {
        return courseList;
    }

    public void setCourseList(CourseEntity courseList) {
        this.courseList = courseList;
    }
}
