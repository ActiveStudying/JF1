/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utitity.db.DbConnectionExtra;
import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;

/**
 *
 * @author PC
 */
public class DbActiveCode extends DbProcess {

    String autheId;
    AccountInfoEntity accountInfo;
    DeviceInfoEntity deviceInfo;

    @Override
    public void execute(DbConnectionExtra dce) throws Exception {
    }

    public String getAutheId() {
        return autheId;
    }

    public void setAutheId(String autheId) {
        this.autheId = autheId;
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

}
