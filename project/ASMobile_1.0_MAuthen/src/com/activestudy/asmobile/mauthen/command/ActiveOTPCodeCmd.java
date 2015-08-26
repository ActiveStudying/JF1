/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.asmobile.mauthen.command;

import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;

/**
 *
 * @author PC
 */
public class ActiveOTPCodeCmd extends ActiveCmd {
    
    // khai bao dau vao

    public ActiveOTPCodeCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo) {
        super(accountInfo, deviceInfo);
        //setOtpCode(otpCode);
        new ActiveOTPCodeCmd(accountInfo, deviceInfo).getOtpCode();
    }
    
    public void excuteOTP(){
        
    }
    
}
