/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice.command;

import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mservice.Processor;
import com.activestudy.asmobile.mservice.dbcontroller.cmd.DbActive;
import com.activestudy.pattern.behavioral.command.*;
import com.activestudy.pattern.entity.result.Result;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
public class RequestCreateCourseCmd extends ASBaseCommand {

    String courseName;
    String description;

    public RequestCreateCourseCmd() {

    }

    @Override
    public void parse(String content) {
        try {
            super.parse(content); //To change body of generated methods, choose Tools | Templates.
            courseName = inJsonObj.getString("courseName");
            description = inJsonObj.getString("description");
        } catch (JSONException ex) {
            Logger.getLogger(RequestCreateCourseCmd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void execute() {
        DbActive dbActiveCmd = new DbActive();
        try {
//            activationId = RandomSt/ringUtils.randomAlphanumeric(20);
//            dbActiveCmd.setActivationId(activationId);
            Processor.getInstance().getDbCtrl().execute(dbActiveCmd);

        } catch (DBException ex) {
            Logger.getLogger(RequestCreateCourseCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getResponse() {
        return  super.getResponse(); //To change body of generated methods, choose Tools | Templates.
    }   

}
