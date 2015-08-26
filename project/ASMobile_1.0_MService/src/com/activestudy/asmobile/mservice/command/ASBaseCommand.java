/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice.command;

import com.activestudy.Utility.JSONUtility;
import com.activestudy.Utitity.db.IDBModule;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.pattern.behavioral.command.AbsCommand;
import com.activestudy.pattern.entity.result.Result;
import com.sun.net.httpserver.Authenticator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
public abstract class ASBaseCommand extends AbsCommand {

    String email;
    String deviceId;
    AccountInfoEntity accountInfo;
    String sessionId;
    protected IDBModule dbCtrl;
    JSONObject inJsonObj;

    public ASBaseCommand() {
        result = new Result();
    }
    
    public void parse(String content) {
        try {
            inJsonObj = new JSONObject(content);
            email = inJsonObj.getString("accountId");
            accountInfo = new AccountInfoEntity(email, email, "");
            deviceId = inJsonObj.getString("deviceId");
            sessionId = inJsonObj.getString("sessionId");
        } catch (JSONException ex) {
            Logger.getLogger(ASBaseCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IDBModule getDbCtrl() {
        return dbCtrl;
    }

    public void setDbCtrl(IDBModule dbCtrl) {
        this.dbCtrl = dbCtrl;
    }

    public String getResponse() {

        JSONObject outJson = new JSONObject();
        JSONObject resultJson = new JSONObject();
        resultJson.put("code",result);
        
        outJson.put("result",result);
        
        
        return "";
    }

}
