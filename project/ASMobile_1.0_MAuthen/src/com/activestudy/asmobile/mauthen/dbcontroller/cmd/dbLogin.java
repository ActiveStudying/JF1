package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utility.Define.AbsDefine;
import com.activestudy.Utitity.db.DbConnectionExtra;
import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;

import com.activestudy.asmobile.mauthen.common.Constants;

import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.SQLType;
import java.sql.Types;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author PC
 */
public class dbLogin extends DbProcess {

    AccountInfoEntity accountInfo;
    DeviceInfoEntity deviceInfo;

    String deviceId;
    String authenId;
    String cloudKey;
    String sessionId;
    String password = "";
    int maxTime = 1800;

    @Override
    public void execute(DbConnectionExtra dce) {
        try {
            CallableStatement cStmtLogin = null;

            cStmtLogin = ((OracleConnection) dce).getStmLogin();
            cStmtLogin.registerOutParameter(1, Types.INTEGER);
            cStmtLogin.setString(2, accountInfo.getAccountId());
            cStmtLogin.setString(3, deviceId);
            cStmtLogin.setString(4, authenId);
            cStmtLogin.setString(5, password);
            cStmtLogin.setString(6, cloudKey);
            cStmtLogin.setString(7, sessionId);
            cStmtLogin.setInt(8, maxTime);
            cStmtLogin.registerOutParameter(9, OracleTypes.CURSOR);
            cStmtLogin.execute();

            result = cStmtLogin.getInt(1);

            if (result == 0) {
                // Lay device info
                ResultSet rs = (ResultSet) cStmtLogin.getObject(9);
                if (rs.next()) {
                    deviceInfo = new DeviceInfoEntity(deviceId, rs.getString("devname"),
                            rs.getString("osname"), rs.getString("osversion"),
                            cloudKey, rs.getString("other"));
                } else {
                    deviceInfo = null;
                }
                if (rs != null) {
                    rs.close();
                }
            }
            // setdau vao
        } catch (SQLException ex) {
            result = AbsDefine.KEY_UNSUCCESS;
            logger.error("DbActiveCode ErrorCode: " + ex.getErrorCode() + "Error" + ex.getMessage() + " STACK" + ex);
        }
    }

    public void setAccountInfo(AccountInfoEntity accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;

    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
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
