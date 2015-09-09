package com.activestudy.asmobile.mauthen.command;

import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author PC
 */
public class GetAccountInfoCmd extends ASBaseCommand {

    String sessionId;

    public GetAccountInfoCmd(String sessionId, AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo) {
        this.sessionId = sessionId;
        this.accountInfo = accountInfo;
        this.deviceInfo = deviceInfo;
    }

    public GetAccountInfoCmd(String sessionId , String accountId, String deviceId) {
        super(deviceId, accountId);
        this.sessionId = sessionId;
    }
    

    public GetAccountInfoCmd() {

    }

    @Override
    public void execute() {
    }

    @Override
    public String getResponse() {
        return "";
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
   
}
