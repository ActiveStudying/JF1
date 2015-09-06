package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utitity.db.DbConnectionExtra;
import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnection;
import java.sql.CallableStatement;

/**
 *
 * @author PC
 */
public class dbLogin extends DbProcess {

    AccountInfoEntity accountId;
    DeviceInfoEntity deviceId;
    String authenId;
    String cloudKey;
    String sessionId;

    @Override
    public void execute(DbConnectionExtra dce) {
      CallableStatement cStmtLogin = null;
      
      cStmtLogin = ((OracleConnection)  dce).getStmLogin();
      // setdau vao
      
    }

    public AccountInfoEntity getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountInfoEntity accountId) {
        this.accountId = accountId;
    }

    public DeviceInfoEntity getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(DeviceInfoEntity deviceId) {
        this.deviceId = deviceId;
    }

    public String getAuthenId() {
        return authenId;
    }

    public void setAuthenId(String authenId) {
        this.authenId = authenId;
    }

    public String getCloudKey() {
        return cloudKey;
    }

    public void setCloudKey(String cloudKey) {
        this.cloudKey = cloudKey;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
