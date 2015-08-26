/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice.command;

import com.activestudy.asmobile.mservice.dbcontroller.cmd.DbGetListClass;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.ClassInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mservice.Processor;
import com.activestudy.pattern.behavioral.command.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
public class GetListClassCmd extends ASBaseCommand {

    String otpCode;
    DeviceInfoEntity deviceInfo;
    String activationId;
    DbGetListClass dbGetListClassCmd = new DbGetListClass();

    public GetListClassCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo, String sessionId) {
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;

    }

    @Override
    public void execute() {

        try {
            Processor.getInstance().getDbCtrl().execute(dbGetListClassCmd);

          //lay dc lstClass roi sau gui di ntn? Đóng vào Json.
            //dong response
        } catch (DBException ex) {
            Logger.getLogger(GetListClassCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DeviceInfoEntity getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    @Override
    public String getResponse() {
        String content = null;
        try {
            ArrayList<ClassInfoEntity> lstClass = dbGetListClassCmd.getListClass();
            JSONObject json = new JSONObject("listClass");

            for (int i = 0; i < lstClass.size(); i++) {
                json.put("class_" + i, lstClass.get(i));
            }
             content = json.toString();
        } catch (JSONException ex) {
            Logger.getLogger(GetListClassCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
}
