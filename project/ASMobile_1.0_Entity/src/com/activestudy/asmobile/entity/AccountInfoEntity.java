package com.activestudy.asmobile.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tanhai
 */
public class AccountInfoEntity {

    private final String accountId;
    private final String email;
    private final String password;
    private String msisdn;

    private String fullname;
    private Date birthday;
    private String job;
    private String gender;

    private ArrayList<Skill> skills;
    private ArrayList<Expects> expects;

    public AccountInfoEntity(String accountId, String email, String password) {
        this.email = email;
        this.password = password;
        this.accountId = accountId;
    }

    public AccountInfoEntity(String accountId, String email, String password, String msisdn, String fullname, Date birthday, String job, String gender) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.msisdn = msisdn;
        this.fullname = fullname;
        this.birthday = birthday;
        this.job = job;
        this.gender = gender;
    }

    public AccountInfoEntity(String accountId, String email, String password, String msisdn, String fullname, Date birthday, String job, String gender, ArrayList<Skill> skills, ArrayList<Expects> expects) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.msisdn = msisdn;
        this.fullname = fullname;
        this.birthday = birthday;
        this.job = job;
        this.gender = gender;
        this.skills = skills;
        this.expects = expects;
    }

    public String getPassword() {
        return password;
    }
    
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Expects> getExpects() {
        return expects;
    }

    public void setExpects(ArrayList<Expects> expects) {
        this.expects = expects;
    }
    
}
