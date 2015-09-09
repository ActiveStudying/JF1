/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;

import com.activestudy.asmobile.entity.AccountInfoEntity;

/**
 *
 * @author PC
 */
public class UpdateAccountInfoCmd extends ASBaseCommand {

    String sessionId;

    public UpdateAccountInfoCmd(String sessionId, AccountInfoEntity accountInfo, String deviceId) {
        this.sessionId = sessionId;
        this.deviceId = deviceId;
        this.accountInfo = accountInfo;

    }

    @Override
    public void execute() {
    }

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

    public AccountInfoEntity getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfoEntity accountInfo) {
        this.accountInfo = accountInfo;
    }
}
