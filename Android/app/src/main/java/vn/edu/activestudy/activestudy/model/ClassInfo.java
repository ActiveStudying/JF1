package vn.edu.activestudy.activestudy.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by dell123 on 8/31/2015.
 */
public class ClassInfo extends SugarRecord<ClassInfo> {
    private String name;
//    private CourseInfo course;
//    private long dateStart;
//    private String schedulerOfWeed; //2 4 6
//    private String schedulerOfDay; //6h30 - 8h30
    private String teacher;
    private int numberOfDay;

    public ClassInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public CourseInfo getCourse() {
//        return course;
//    }
//
//    public void setCourse(CourseInfo course) {
//        this.course = course;
//    }

//    public long getDateStart() {
//        return dateStart;
//    }
//
//    public void setDateStart(long dateStart) {
//        this.dateStart = dateStart;
//    }
//
//    public String getSchedulerOfWeed() {
//        return schedulerOfWeed;
//    }
//
//    public void setSchedulerOfWeed(String schedulerOfWeed) {
//        this.schedulerOfWeed = schedulerOfWeed;
//    }
//
//    public String getSchedulerOfDay() {
//        return schedulerOfDay;
//    }
//
//    public void setSchedulerOfDay(String schedulerOfDay) {
//        this.schedulerOfDay = schedulerOfDay;
//    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }
}
