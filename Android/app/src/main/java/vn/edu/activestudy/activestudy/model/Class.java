package vn.edu.activestudy.activestudy.model;

/**
 * Created by dell123 on 8/31/2015.
 */
public class Class {

    private int picture;
    private String nameCourse;
    private String description;

    public Class(int picture, String nameCourse, String description) {
        this.picture = picture;
        this.nameCourse = nameCourse;
        this.description = description;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
