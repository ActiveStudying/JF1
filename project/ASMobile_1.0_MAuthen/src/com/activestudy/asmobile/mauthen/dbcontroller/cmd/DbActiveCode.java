/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utility.Define.AbsDefine;
import com.activestudy.Utitity.db.DbConnectionExtra;
import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author PC
 */
public class DbActiveCode extends DbProcess {

    AccountInfoEntity accountInfo;
    DeviceInfoEntity deviceInfo;
    String activationId;
    String otpCode;
    String authenId;
    int maxTimeOut;
    int maxRetry;

    @Override
    public void execute(DbConnectionExtra dce) {
        CallableStatement cSmtActiveCode = null;
//        FUNCTION activatewithcode (p_accountid          IN VARCHAR,
//                               p_devid              IN VARCHAR,
//                               p_activationid       IN VARCHAR,
//                               p_otpcode            IN VARCHAR,
//                               p_authenticationid   IN VARCHAR,
//                               p_maxtimeout         IN INTEGER,
//                               p_maxretry           IN INTEGER)
//        RETURN INTEGER;

        try {
            cSmtActiveCode = ((OracleConnection) dce).getStmActivateWithCode();
            // set parameter dau vao
            //cSmtActiveCode.setString(result, autheId); xem duoi db
            cSmtActiveCode.setString(2, accountInfo.getAccountId()); //xem duoi db vi tri cua accountId la dau vao thu may
            cSmtActiveCode.setString(3, deviceInfo.getDeviceId());
            cSmtActiveCode.setString(4, activationId);
            cSmtActiveCode.setString(5, otpCode);
            cSmtActiveCode.setString(6, authenId);
            cSmtActiveCode.setInt(maxTimeOut, 7);
            cSmtActiveCode.setInt(maxRetry, 8);
            
            // lay dau ra
            cSmtActiveCode.registerOutParameter(1, Types.INTEGER);
            ResultSet re = cSmtActiveCode.executeQuery();
            result   = cSmtActiveCode.getInt(1);
            if (re!= null) {
               result  = AbsDefine.KEY_SUCCESS; 
            }else{
                 logger.error("LoadCategory UnSuccess, ResultSet is Null");
            }
        } catch (SQLException ex) {
            logger.error("LoadCategory ErrorCode: "+ ex.getErrorCode() + "Error" + ex.getMessage() + " STACK" + ex);
        }

    }

    public String getAutheId() {
        return authenId;
    }

    public void setAutheId(String authenId) {
        this.authenId = authenId;
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
