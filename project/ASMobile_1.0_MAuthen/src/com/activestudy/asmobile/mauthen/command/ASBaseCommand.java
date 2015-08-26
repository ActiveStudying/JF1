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
import java.io.StringWriter;
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
    DeviceInfoEntity deviceInfo;
    
    JSONObject jsonObj = new JSONObject();
    // String device ;

    protected IDBModule dbCtrl;
    // private Object AccountInfoEntity;

    public IDBModule getDbCtrl() {
        return dbCtrl;
    }

    public void setDbCtrl(IDBModule dbCtrl) {
        this.dbCtrl = dbCtrl;
    }

    public String getResponse() {
        // khai bao doi tuong json
        // dong du lieu de tra ra dung put(key, value)
        String contents = ""; // chuoi json
        try {
            
          //  jsonObj.put("code",);
            
            

            StringWriter out = new StringWriter();
            jsonObj.write(out);
            contents = jsonObj.toString();
            return contents;

        } catch (JSONException ex) {
            Logger.getLogger(ASBaseCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        ActiveCmd activeCmdObj = new ActiveCmd(accountInfo, deviceInfo);
        activeCmdObj.execute();
        return contents;

    }

}
