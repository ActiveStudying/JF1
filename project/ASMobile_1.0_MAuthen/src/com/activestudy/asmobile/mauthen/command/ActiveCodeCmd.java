/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;

import com.activestudy.Utility.MCommonUtils;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.ResultNumber;

import com.activestudy.asmobile.mauthen.CoreConfig;

import com.activestudy.asmobile.mauthen.Processor;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbActiveCode;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author tanhai
 */
public class ActiveCodeCmd extends ASBaseCommand {

    String otpCode;
    String activationId;
    String authenId;

    private Log logger = null;
    public ActiveCodeCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo,Log logger) {
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
        this.logger = logger;
    }

    public ActiveCodeCmd(Log logger) {
        this.logger = logger;
    }

    @Override
    public void execute() {
        // check mail 

        if (false == MCommonUtils.is_Email(accountInfo.getAccountId())) {
            result.setErrorCode(ResultNumber.MAUTHEN_ACCOUNTID_INVALIDFORMAT);
            return;
        }
        DbActiveCode dbActiveCodeCmd = new DbActiveCode();
        try {
            authenId = RandomStringUtils.randomAlphanumeric(20);
            dbActiveCodeCmd.setAutheId(authenId);

            dbActiveCodeCmd.setActivationId(activationId);
            dbActiveCodeCmd.setAccountInfo(accountInfo);
            dbActiveCodeCmd.setOtpCode(otpCode);
            dbActiveCodeCmd.setDeviceId(deviceId);
            dbActiveCodeCmd.setMaxRetry(5);
            dbActiveCodeCmd.setMaxTimeOut(50000);
            logger.debug("Initial dbActiveCodeCmd success");
            Processor.getInstance().getDbCtrl().execute(dbActiveCodeCmd);
            //set result 
            logger.debug("dbActiveCodeCmd result: " + dbActiveCodeCmd.getResult() );
            if (dbActiveCodeCmd.getResult() == ResultNumber.SUCCESS) {
                result.setErrorCode(ResultNumber.SUCCESS);
            } else {
                result.setErrorCode(ResultNumber.SYSTEM_ERROR);
            }


        } catch (DBException ex) {
            Logger.getLogger(ActiveCodeCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getResponse() {
        try {
            super.getResponse();
            jsonResultData.put("authenId", authenId);
            jsonResponse.put("resultData", jsonResultData);
        } catch (JSONException ex) {
            Logger.getLogger(ActiveCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonResponse.toString();
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {

        this.otpCode = otpCode;
    }

    @Override
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


    public String getAuthenId() {
        return authenId;
    }

    public void setAuthenId(String authenId) {
        this.authenId = authenId;
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
