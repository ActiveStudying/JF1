/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;

import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author PC
 */
public class LogInCmd extends ASBaseCommand {

    String authenId;
    String cloudKey;
    String sessionId;

    public LogInCmd(String authenId, AccountInfoEntity accountInfo) {
        this.authenId = authenId;
        this.accountInfo = accountInfo;
    }

    public LogInCmd() {

    }

    @Override
    public void execute() {
    }

    @Override
    public String getResponse() {
        super.getRequest();
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

    public AccountInfoEntity getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfoEntity accountInfo) {
        this.accountInfo = accountInfo;
    }

    public DeviceInfoEntity getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCloudKey() {
        return cloudKey;
    }

    public void setCloudKey(String cloudKey) {
        this.cloudKey = cloudKey;
    }

}
