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
import com.activestudy.asmobile.entity.ResultNumber.*;
import com.activestudy.asmobile.mauthen.Processor;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbActive;
import com.activestudy.pattern.behavioral.command.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author tanhai
 */
public class ActiveCmd extends ASBaseCommand {

    String otpCode;
    DeviceInfoEntity deviceInfo;
    String activationId;

    public ActiveCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
        result = new ResultNumber();
    }

    @Override
    public void execute() {
        // kiem tra mail 
        if (false == StringUtility.is_Email(accountInfo.getEmail())) {
            ((ResultNumber) result).setErrorCode(ResultNumber.MAUTHEN_ACCOUNTID_INVALIDFORMAT);
            return;
        }
        // kiem tra deviceID
        if (deviceInfo.getDeviceId().isEmpty()) {
            ((ResultNumber) result).setErrorCode(ResultNumber.MAUTHEN_DEVICEID_EMPTY);
            return ;
        }
        

        DbActive dbActiveCmd = new DbActive();
        try {
            activationId = RandomStringUtils.randomAlphanumeric(20);
            dbActiveCmd.setActivationId(activationId);
            Processor.getInstance().getDbCtrl().execute(dbActiveCmd);
        } catch (DBException ex) {
            Logger.getLogger(ActiveCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public String getResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
