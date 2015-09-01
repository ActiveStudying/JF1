/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;

import com.activestudy.Utility.StringUtility;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.ResultNumber;
import com.activestudy.asmobile.mauthen.Processor;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbActive;
import com.activestudy.pattern.behavioral.command.*;
import com.sun.jersey.core.spi.scanning.FilesScanner;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author tanhai
 */
public class ActiveCodeCmd extends ASBaseCommand {

    String otpCode;
    String activationId;
    String authenId;

    public ActiveCodeCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
    }

    public ActiveCodeCmd() {

    }

    @Override
    public void execute() {

        // kiem tra otpcode
        if (false == StringUtility.is_OTPCODE(new ActiveCodeCmd().getOtpCode())) {
            ((ResultNumber) result).setErrorCode(ResultNumber.MAUTHEN_OTPCODE_INVALIDFORMAT);

        } else {
            ((ResultNumber) result).setErrorCode(ResultNumber.OVER_NUMBERRETRY_OTPCODE);
            return;
        }

        DbActive dbActiveCmd = new DbActive();
        try {
            authenId = RandomStringUtils.randomAlphanumeric(20);
            dbActiveCmd.setActivationId(authenId);
            Processor.getInstance().getDbCtrl().execute(dbActiveCmd);

        } catch (DBException ex) {
            Logger.getLogger(ActiveCodeCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getResponse() {
        return "";
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public DeviceInfoEntity getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
