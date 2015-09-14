package vn.edu.activestudy.activestudy.model.entity;

import java.util.Date;

/**
 * Created by dell123 on 8/26/2015.
 */
public class AccountInfo {
    private String acountID;
    private String email;
    private String password;
    private String fullname;
    private String msisdn;
    private Date birthday;
    private String job;
    private String gender;

    public String getAcountID() {
        return acountID;
    }

    public void setAcountID(String acountID) {
        this.acountID = acountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
