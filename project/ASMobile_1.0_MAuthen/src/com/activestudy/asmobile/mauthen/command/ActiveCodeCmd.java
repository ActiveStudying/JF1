/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
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
public class ActiveCodeCmd extends ASBaseCommand{
    
    String otpCode;
    DeviceInfoEntity deviceInfo;
    String activationId;
    
    public ActiveCodeCmd(AccountInfoEntity accountInfo ,DeviceInfoEntity deviceInfo) {        
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
    }
    
    @Override
    public void execute() {
        DbActive dbActiveCmd = new DbActive();
        try {
            activationId = RandomStringUtils.randomAlphanumeric(20);
            dbActiveCmd.setActivationId(activationId);
            Processor.getInstance().getDbCtrl().execute(dbActiveCmd);  
            
        } catch (DBException ex) {
            Logger.getLogger(ActiveCodeCmd.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
}
