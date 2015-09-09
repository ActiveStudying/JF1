package com.activestudy.asmobile.mauthen.dbcontroller;

import com.activestudy.Utitity.db.DbConnectionExtra;
import java.sql.SQLException;
import com.elcom.db.DbConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;


/**
 *
 */
public class OracleConnection extends DbConnectionExtra {

   

    private final CallableStatement stmActiveSubs;

    private final CallableStatement stmCheckAcountDevice;
    private final CallableStatement stmDisableAcountDevice;
    private final CallableStatement stmCreateAcountDevice;

    private final CallableStatement stmUpdateDeviceInfo;
    private final CallableStatement stmUpdateAccountInfo;
    private final CallableStatement stmGetAccountInfo;

    private final CallableStatement stmActivateAcountDevice;
    private final CallableStatement stmActivateWithCode;
    private final CallableStatement stmDeactivate;

    private final CallableStatement stmLogin;
    private final CallableStatement stmLogout;

    private final CallableStatement stmGetServiceAddr;

    private final CallableStatement stmLike;
    private final CallableStatement stmGetLikes;
    private final CallableStatement stmFeedBack;

    // For MSS
    private final CallableStatement stmValidate;
    private final CallableStatement stmGetDevicesInfo;

    public OracleConnection(int index, DbConnection conn) throws SQLException {
        super(index, conn);
        
        //   goi cai ham aactivateaccountdevice da dinh nghia duoi db trong goi PKB_ACCOUNT
        String sqlActiveSub = "{? = call PKG_ACCOUNT.activateaccountdevice(?,?,?,?)}";
        // tao ket noi, va lay preparestatement 
        stmActiveSubs = conn.connection().prepareCall(sqlActiveSub);

        String sqlCheckAccountDevice = "{? = call pkg_account.checkAccountDevice(?,?)}";
        stmCheckAcountDevice = conn.connection().prepareCall(
                sqlCheckAccountDevice);

        String sqlDisableAccountDevice = "{? = call pkg_account.disableAccountDevice(?,?)}";
        stmDisableAcountDevice = conn.connection().prepareCall(
                sqlDisableAccountDevice);

        String sqlCreateAccountDevice = "{? = call pkg_account.createAccountDevice(?,?,?,?)}";
        stmCreateAcountDevice = conn.connection().prepareCall(
                sqlCreateAccountDevice);

        String sqlUpdateDeviceInfo = "{? = call pkg_account.updateDeviceInfo(?,?,?,?,?,?)}";
        stmUpdateDeviceInfo = conn.connection()
                .prepareCall(sqlUpdateDeviceInfo);

        String sqlUpdateAccountInfo = "{? = call pkg_account.updateAccountInfo(?,?,?,?,?,?,?,?,?)}";
        stmUpdateAccountInfo = conn.connection().prepareCall(
                sqlUpdateAccountInfo);

        String sqlGetAccInfo = "{? = call pkg_account.getaccountinfo(?,?,?,?)}";
        stmGetAccountInfo = conn.connection().prepareCall(sqlGetAccInfo);


        String sqlActivateAccountDevice = "{? = call pkg_account.activateAccountDevice(?,?,?,?)}";
        stmActivateAcountDevice = conn.connection().prepareCall(
                sqlActivateAccountDevice);

        String sqlActivateWithCode = "{? = call pkg_account.activatewithcode(?,?,?,?,?,?,?)}";
        stmActivateWithCode = conn.connection()
                .prepareCall(sqlActivateWithCode);

        String sqlDeactivate = "{? = call pkg_account.deactivateaccountdevice(?,?,?)}";
        stmDeactivate = conn.connection().prepareCall(sqlDeactivate);

        String sqlLogin = "{? = call pkg_prov.login(?,?,?,?,?,?,?,?)}";
        stmLogin = conn.connection().prepareCall(sqlLogin);

        String sqlLogout = "{? = call pkg_prov.logoutcmd(?,?,?)}";
        stmLogout = conn.connection().prepareCall(sqlLogout);

        String sqlGetServiceAddr = "{? = call pkg_prov.getServiceAddr(?,?,?,?,?)}";
        stmGetServiceAddr = conn.connection().prepareCall(sqlGetServiceAddr);

        String sqlLike = "{? = call pkg_prov.likemapp(?,?,?,?,?)}";
        stmLike = conn.connection().prepareCall(sqlLike);

        String sqlGetLike = "{? = call pkg_prov.getLikes(?,?,?,?,?)}";
        stmGetLikes = conn.connection().prepareCall(sqlGetLike);

        String sqlFeedBack = "{? = call pkg_prov.feedback(?,?,?,?,?)}";
        stmFeedBack = conn.connection().prepareCall(sqlFeedBack);

        // For MSS
        String sqlValidate = "{? = call pkg_prov.validateSession(?,?)}";
        stmValidate = conn.connection().prepareCall(sqlValidate);

        String sqlGetDevsInfo = "{? = call pkg_account.getDevicesInfo(?,?)}";
        stmGetDevicesInfo = conn.connection().prepareCall(sqlGetDevsInfo);
    }

    public CallableStatement getStmActiveSubs() {
        return stmActiveSubs;
    }

    public CallableStatement getStmCheckAcountDevice() {
        return stmCheckAcountDevice;
    }

    public CallableStatement getStmDisableAcountDevice() {
        return stmDisableAcountDevice;
    }

    public CallableStatement getStmCreateAcountDevice() {
        return stmCreateAcountDevice;
    }

    public CallableStatement getStmUpdateDeviceInfo() {
        return stmUpdateDeviceInfo;
    }

    public CallableStatement getStmUpdateAccountInfo() {
        return stmUpdateAccountInfo;
    }

    public CallableStatement getStmActivateAcountDevice() {
        return stmActivateAcountDevice;
    }

    public CallableStatement getStmActivateWithCode() {
        return stmActivateWithCode;
    }

    public CallableStatement getStmLogin() {
        return stmLogin;
    }

    public CallableStatement getStmLogout() {
        return stmLogout;
    }

    public CallableStatement getStmValidate() {
        return stmValidate;
    }

    public CallableStatement getStmGetServiceAddr() {
        return stmGetServiceAddr;
    }

    public CallableStatement getStmDeactivate() {
        return stmDeactivate;
    }

    public CallableStatement getStmLike() {
        return stmLike;
    }

    public CallableStatement getStmGetLikes() {
        return stmGetLikes;
    }

    public CallableStatement getStmFeedBack() {
        return stmFeedBack;
    }

    public CallableStatement getStmGetAccountInfo() {
        return stmGetAccountInfo;
    }

    public CallableStatement getStmGetDevicesInfo() {
        return stmGetDevicesInfo;
    }
}
