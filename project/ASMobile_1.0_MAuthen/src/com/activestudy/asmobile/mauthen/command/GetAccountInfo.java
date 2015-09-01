package com.activestudy.asmobile.mauthen.command;

import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author PC
 */
public class GetAccountInfo extends ASBaseCommand {

    String sessionId;

    public GetAccountInfo(String sessionId, AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo) {
        this.sessionId = sessionId;
        this.accountInfo = accountInfo;
        this.deviceInfo = deviceInfo;
    }

    public GetAccountInfo() {

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

   
}
