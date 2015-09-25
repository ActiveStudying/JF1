package com.activestudy.asmobile.mauthen.command;

import com.activestudy.Utility.MCommonUtils;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.ResultNumber;
import com.activestudy.asmobile.mauthen.Processor;

import com.activestudy.asmobile.mauthen.common.Constants;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbActive;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbCheckAcountDevice;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbCreateAccountDevice;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbDisableAcountDevice;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;

import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author tanhai
 */
public class ActiveCmd extends ASBaseCommand {

    String otpCode;

    DeviceInfoEntity deviceInfo;    
    String activationId;
    Log logger = null;

    public ActiveCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo, Log logger) {
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
        this.logger = logger;
        result = new ResultNumber();
    }

    @Override
    public void execute() {
        // kiem tra mail 
        if (false == MCommonUtils.is_Email(accountInfo.getEmail())) {

            result.setErrorCode(ResultNumber.MAUTHEN_ACCOUNTID_INVALIDFORMAT);
            return;
        }
        // kiem tra deviceID
        if (deviceInfo.getDeviceId().isEmpty()) {

            result.setErrorCode(ResultNumber.MAUTHEN_DEVICEID_EMPTY);
            return;
        }
        //-------------------------------------------------------------------------------------------
        boolean isOK = false;
        try {
            DbCheckAcountDevice dbCheckAccDev = new DbCheckAcountDevice(
                    this.accountInfo.getAccountId(), this.deviceInfo.getDeviceId());
            Processor.getInstance().getDbCtrl().execute(dbCheckAccDev);
            int checkAccountResult = dbCheckAccDev.getResult();

            switch (checkAccountResult) {
                case Constants.ACCCOUNT_STATUS.DEACTIVATED:
                    isOK = true;
                    break;
                case Constants.ACCCOUNT_STATUS.ACTIVATED:
                    // Neu da ton tai
                    // - Disable thiet bi nay
                    DbDisableAcountDevice dbDisAccDev = new DbDisableAcountDevice(
                            this.accountInfo.getAccountId(),
                            this.deviceInfo.getDeviceId());
                    Processor.getInstance().getDbCtrl().execute(dbDisAccDev);

                    isOK = true;
                    break;
                case Constants.ACCCOUNT_STATUS.ACC_NOT_EXIST:
                    // Neu chua ton tai
                    // - Tao moi thong tin account, device se tao sau
                    DbCreateAccountDevice dbCreateAccDev = new DbCreateAccountDevice(
                            this.accountInfo.getAccountId(), "",
                            this.accountInfo.getMsisdn(), this.deviceInfo.getDeviceId());
                    Processor.getInstance().getDbCtrl().execute(dbCreateAccDev);

                    isOK = true;
                    break;
                case Constants.ACCCOUNT_STATUS.DEV_NOT_ACTIVATE:
                    // Neu chua ton tai
                    // Tao moi thong tin device trong db o ham ActivateAccountDevice
                    isOK = true;
                    break;
                case Constants.ACCCOUNT_STATUS.UNKNOW:
                default:
                    result.setErrorCode(ResultNumber.SYSTEM_ERROR);

                    isOK = false;
                    break;
            }

        } catch (DBException ex) {
            logger.error("DbCheckAcountDevice error: " + ex.getMessage(), ex);
        }
        //-------------------------------------------------------------------------------------------
        if (isOK) {
            DbActive dbActiveCmd = new DbActive(); // tao ket noi duoi db..
            try {
                activationId = RandomStringUtils.randomAlphanumeric(20);
                otpCode = RandomStringUtils.randomNumeric(5);
                dbActiveCmd.setActivationId(activationId); // 
                dbActiveCmd.setAccountInfo(accountInfo);
                dbActiveCmd.setDeviceInfo(deviceInfo);
                dbActiveCmd.setOtpCode(otpCode);

                Processor.getInstance().getDbCtrl().execute(dbActiveCmd);
                // set result
                if (dbActiveCmd.getResult() == ResultNumber.SUCCESS) {
                    result.setErrorCode(ResultNumber.SUCCESS);
                } else {
                    // nghi them cac ma loi khac thi implement o day
                    result.setErrorCode(ResultNumber.SYSTEM_ERROR);
                }
                // gui mail

            } catch (DBException ex) {
                Logger.getLogger(ActiveCmd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getResponse() {
        try {
            super.getResponse();
            jsonResultData.put("activationId", activationId);
            jsonResponse.put("resultData", jsonResultData);


        } catch (JSONException ex) {
            Logger.getLogger(ActiveCmd.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return jsonResponse.toString();
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

    public void move() {
        System.out.println("oanh git ");
    }
}
