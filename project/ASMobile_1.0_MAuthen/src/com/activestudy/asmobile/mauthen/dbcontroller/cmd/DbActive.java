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
 * @author tanhai
 */
public class DbActive extends DbProcess {
    String activationId;
    AccountInfoEntity accountInfo;
    DeviceInfoEntity deviceInfo;
    String otpCode ;
    
    
    @Override
    public void execute(DbConnectionExtra conn)  {
        CallableStatement cStmt = null;
        try {
            cStmt = ((OracleConnection) conn).getStmActiveSubs();
            //set parametter dau vao 
            cStmt.setString(2, accountInfo.getAccountId());
            cStmt.setString(3, deviceInfo.getDeviceId());
            cStmt.setString(4, activationId);
            cStmt.setString(5, otpCode);
           // lay dau ra
            cStmt.registerOutParameter(1, Types.INTEGER);
            ResultSet rs = cStmt.executeQuery();
            
             result = cStmt.getInt(1);
            if (rs != null) {
                result = AbsDefine.KEY_SUCCESS;            
                rs.close();
            }else{
                 logger.error("LoadCategory UnSuccess, ResultSet is Null");
            }
        } catch (SQLException se) {
            logger.error("LoadCategory ErrorCode: " +se.getErrorCode() + " Error: " + se.getMessage() + " STACK: " + se);
        } 
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

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }
    

}
