package com.activestudy.asmobile.mauthen.command;

import com.activestudy.Utility.MCommonUtils;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.ResultNumber;
import com.activestudy.asmobile.mauthen.Processor;
import com.activestudy.asmobile.mauthen.dbcontroller.cmd.DbActive;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author tanhai
 */
public class ActiveCmd extends ASBaseCommand {

    String otpCode;
    DeviceInfoEntity deviceInfo;
    AccountInfoEntity accountId;
    String activationId;

    public ActiveCmd(AccountInfoEntity accountInfo, DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
        this.accountInfo = accountInfo;
        result = new ResultNumber();
    }

    @Override
    public void execute() {
        // kiem tra mail 
        if (false == MCommonUtils.is_Email(accountInfo.getEmail())) {
            ((ResultNumber) result).setErrorCode(ResultNumber.MAUTHEN_ACCOUNTID_INVALIDFORMAT);
            return;
        }
        // kiem tra deviceID
        if (deviceInfo.getDeviceId().isEmpty()) {
            ((ResultNumber) result).setErrorCode(ResultNumber.MAUTHEN_DEVICEID_EMPTY);
            return;
        }

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

    public String getResponse() {
        try {
            super.getResponse();
            jsonResultData.put("activeId", activationId);
            jsonResponse.put("resultData", jsonResultData);
        } catch (JSONException ex) {
            Logger.getLogger(ActiveCmd.class.getName()).log(Level.SEVERE, null, ex);
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
