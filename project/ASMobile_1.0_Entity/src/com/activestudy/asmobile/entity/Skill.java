package com.activestudy.asmobile.entity;

/**
 *
 * @author PC
 */
public class Skill {

    protected String Language;
    protected Integer Level;
    protected String Experience;
    protected String Other;

    public Skill() {
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer Level) {
        this.Level = Level;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String Other) {
        this.Other = Other;
    }

}
