package vn.edu.activestudy.activestudy.model;

/**
 * Created by Administrator on 31/08/2015.
 */
public class StudentItem {

    private int picture;
    private String nameStudent;

    public StudentItem(int picture, String nameStudent) {
        this.picture = picture;
        this.nameStudent = nameStudent;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

}
