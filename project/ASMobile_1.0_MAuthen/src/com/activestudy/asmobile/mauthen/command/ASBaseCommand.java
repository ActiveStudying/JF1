/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;

import com.activestudy.Utitity.db.IDBModule;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.pattern.behavioral.command.AbsCommand;
import com.activestudy.pattern.entity.result.Result;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
public abstract class ASBaseCommand extends AbsCommand {


    
    String deviceId;
    String accountId;
    AccountInfoEntity accountInfo;
    DeviceInfoEntity deviceInfo;

    JSONObject jsonResponse;
    JSONObject jsonResultData;
    // String device ;

    protected IDBModule dbCtrl;

    // private Object AccountInfoEntity;
    public ASBaseCommand() {
        result = new Result();

    }
    public ASBaseCommand(String deviceId, AccountInfoEntity accountInfo) {
        this.deviceId = deviceId;
        this.accountInfo = accountInfo;
    }
    // constructor email and device id

    public ASBaseCommand(String accountId, String deviceId) {
        this.accountId = accountId;
        this.deviceId = deviceId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    

    public IDBModule getDbCtrl() {
        return dbCtrl;
    }

    public void setDbCtrl(IDBModule dbCtrl) {
        this.dbCtrl = dbCtrl;
    }

  

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public String getResponse() {
        // khai bao doi tuong json
        // dong du lieu de tra ra dung put(key, value)
        jsonResponse = new JSONObject();
        try {
            JSONObject jsonResultObj = new JSONObject();
            jsonResultObj.put("code", result.getErrorCode());
            jsonResultObj.put("description", result.getErrorDesc());
            jsonResponse.put("result", jsonResultObj);
            jsonResultData = new JSONObject();
        } catch (JSONException ex) {
            Logger.getLogger(ASBaseCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonResponse.toString();
    }
}
