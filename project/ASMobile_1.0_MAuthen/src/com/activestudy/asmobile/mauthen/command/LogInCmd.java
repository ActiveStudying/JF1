/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;


import com.activestudy.Utility.Define.AbsDefine;
import com.activestudy.Utility.MCommonUtils;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.ResultNumber;

import com.activestudy.asmobile.mauthen.CoreConfig;
import com.activestudy.asmobile.mauthen.Processor;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.dbLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author PC
 */
public class LogInCmd extends ASBaseCommand {


    String authenId;
    String cloudKey;
    String sessionId;
    
    String password;
    int maxTime = 1800;
    Log logger;

    public LogInCmd(String authenId, AccountInfoEntity accountInfo, Log logger) {
        this.authenId = authenId;
        this.accountInfo = accountInfo;
        this.logger = logger;
    }


    public LogInCmd(Log logger) {
        this.logger = logger;

    }

    @Override
    public void execute() {
        // kiem tra mail 
        if (false == MCommonUtils.is_Email(accountInfo.getEmail())) {

            result.setErrorCode(ResultNumber.MAUTHEN_ACCOUNTID_INVALIDFORMAT);
            return;
        }
        // kiem tra deviceID
        if (deviceId.isEmpty()) {
            result.setErrorCode(ResultNumber.MAUTHEN_DEVICEID_EMPTY);
            return;
        }
        // kiem tra authen // viet ham kiem tra authen
//        if (false == MCommonUtils.) {
//            
//        }

        dbLogin dbLoginCmd = new dbLogin();
        try {
            sessionId = RandomStringUtils.randomAlphanumeric(20);
            dbLoginCmd.setAccountInfo(accountInfo);
            dbLoginCmd.setDeviceId(deviceId);
            dbLoginCmd.setAuthenId(authenId);
            dbLoginCmd.setCloudKey(cloudKey);
            dbLoginCmd.setSessionId(sessionId);
            dbLoginCmd.setMaxTime(CoreConfig.getInstance().getSessionTimeOut());
            Processor.getInstance().getDbCtrl().execute(dbLoginCmd);
            // set result             
            if (dbLoginCmd.getResult() == AbsDefine.KEY_SUCCESS) {
                result.setErrorCode(ResultNumber.SUCCESS);
            } else if (dbLoginCmd.getResult() == 1) {// Acc chua dang ky
                result.setErrorCode(ResultNumber.MAUTHEN_ACCOUNTID_NOTEXIST);
            } else if (dbLoginCmd.getResult() == 2) {// Sai authentication id
                result.setErrorCode(ResultNumber.MAUTHEN_AUTHENID_INVALIDFORMAT);
            } else {
                result.setErrorCode(ResultNumber.SYSTEM_ERROR);
            }

        } catch (DBException ex) {
            Logger.getLogger(LogInCmd.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public String getResponse() {

        super.getResponse();
        try {
            jsonResultData.put("sessionID", sessionId);

            jsonResponse.put("resultData", jsonResultData);
        } catch (JSONException ex) {
            Logger.getLogger(LogInCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonResponse.toString();
    }

    public String getAuthenId() {
        return authenId;
    }

    public void setAuthenId(String authenId) {
        this.authenId = authenId;
    }

    public String getCloudKey() {
        return cloudKey;
    }

    public void setCloudKey(String cloudKey) {
        this.cloudKey = cloudKey;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

 


}
