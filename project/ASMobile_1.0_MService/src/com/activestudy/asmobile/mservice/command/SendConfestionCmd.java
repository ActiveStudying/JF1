/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice.command;
import com.activestudy.asmobile.mservice.dbcontroller.cmd.DbStoreMsg;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.ClassInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.MessageEntity;
import com.activestudy.asmobile.mservice.Processor;
import com.activestudy.pattern.behavioral.command.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
/**
 *
 * @author tanhai
 */
public class SendConfestionCmd extends ASBaseCommand{
    
    String otpCode;
    DeviceInfoEntity deviceInfo;
    String activationId;
    MessageEntity msg ;
    public SendConfestionCmd(AccountInfoEntity accountInfo ,DeviceInfoEntity deviceInfo,MessageEntity msg) {        
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
        this.msg = msg;
    }
    
    @Override
    public void execute() {
        DbStoreMsg dbStoreMsgCmd = new DbStoreMsg(msg);
        //check sesionId . Nhưng chưa biết check.
        //set result.
       try {
          Processor.getInstance().getDbCtrl().execute(dbStoreMsgCmd);  
           //Sau khi luu message thi gui
          // hay la he 
        } catch (DBException ex) {
            Logger.getLogger(SendConfestionCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DeviceInfoEntity getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
    
    
}
