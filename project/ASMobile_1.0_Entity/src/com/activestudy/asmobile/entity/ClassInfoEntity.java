/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Soth
 */
public class ClassInfoEntity {

    private int classId;
    private String className;
    private String courseName;
    private Date timeStart;
    private ArrayList<String> lstCalendarStudy;
    private String timeStudy;
    private ArrayList<String> lstNameTeach;
    private String description;

    public ClassInfoEntity() {
    }

    public ClassInfoEntity(int classId, String className, CourseEntity Course, Date timeStart, ArrayList<String> lstCalendarStudy, String timeStudy, ArrayList<String> lstNameTeach, String description) {
        this.classId = classId;
        this.className = className;
        this.Course = Course;
        this.timeStart = timeStart;
        this.lstCalendarStudy = lstCalendarStudy;
        this.timeStudy = timeStudy;
        this.lstNameTeach = lstNameTeach;
        this.description = description;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public CourseEntity getCourse() {
        return Course;
    }

    public void setCourse(CourseEntity Course) {
        this.Course = Course;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public ArrayList<String> getLstCalendarStudy() {
        return lstCalendarStudy;
    }

    public void setLstCalendarStudy(ArrayList<String> lstCalendarStudy) {
        this.lstCalendarStudy = lstCalendarStudy;
    }

    public String getTimeStudy() {
        return timeStudy;
    }

    public void setTimeStudy(String timeStudy) {
        this.timeStudy = timeStudy;
    }

    public ArrayList<String> getLstNameTeach() {
        return lstNameTeach;
    }

    public void setLstNameTeach(ArrayList<String> lstNameTeach) {
        this.lstNameTeach = lstNameTeach;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
