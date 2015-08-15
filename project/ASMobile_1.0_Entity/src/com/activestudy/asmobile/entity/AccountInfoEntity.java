/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.entity;

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

    public AccountInfoEntity(String accountId,String email, String password) {
        this.email = email;
        this.password = password;
        this.accountId = accountId;
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
    
}
