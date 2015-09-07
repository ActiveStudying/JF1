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
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class dbLogin extends DbProcess {

    AccountInfoEntity accountInfo;
    DeviceInfoEntity deviceInfo;
    String authenId;
    String cloudKey;
    String sessionId;
    int maxTime;
    String accountId;
    String deviceId;
// FUNCTION login (p_accountid          IN     VARCHAR,
//                    p_devid              IN     VARCHAR,
//                    p_authenticationid   IN     VARCHAR,
//                    p_password           IN     VARCHAR,
//                    p_cloudkey           IN     VARCHAR,
//                    p_sessionid          IN     VARCHAR,
//                    p_maxtime            IN     INTEGER,
//                    p_devinfo               OUT sys_refcursor)
//        RETURN INTEGER;

    public void execute(DbConnectionExtra dce) {
        CallableStatement cStmtLogin = null;
        try {
            // setdau vao
            cStmtLogin = ((OracleConnection) dce).getStmLogin();
            cStmtLogin.setString(2, accountInfo.getAccountId());
            cStmtLogin.setString(3, deviceInfo.getDeviceId());
            cStmtLogin.setString(4, authenId);
            cStmtLogin.setString(5, accountInfo.getPassword());
            cStmtLogin.setString(6, cloudKey);
            cStmtLogin.setString(7, sessionId);
            cStmtLogin.setInt(maxTime, 8);
            cStmtLogin.setString(9, deviceInfo.toString());
            // lay dau ra 
            cStmtLogin.registerOutParameter(1, Types.INTEGER);
            ResultSet rs = cStmtLogin.executeQuery();
            result = cStmtLogin.getInt(1);

            if (rs != null) {
                result = AbsDefine.KEY_SUCCESS;
                rs.close();
            } else {
                logger.error("LoadCategory UnSuccess, ResultSet is Null");
            }

        } catch (SQLException ex) {
            Logger.getLogger("LoadCategory ErrorCode: " + ex.getErrorCode() + " Error: " + ex.getMessage() + " STACK: " + ex);
            result = -1;
        }

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public DeviceInfoEntity getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
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
