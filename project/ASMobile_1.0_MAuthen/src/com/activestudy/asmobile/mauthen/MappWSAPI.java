/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//comment
package com.activestudy.asmobile.mauthen;

import com.activestudy.Utility.JSONUtility;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mauthen.command.ActiveCmd;
import com.activestudy.asmobile.mauthen.command.ActiveCodeCmd;
import com.activestudy.asmobile.mauthen.command.CheckUserCmd;
import com.activestudy.asmobile.mauthen.command.GetAccountInfoCmd;
import com.activestudy.asmobile.mauthen.command.GetServiceAddressCmd;
import com.activestudy.asmobile.mauthen.command.LogInCmd;
import com.activestudy.asmobile.mauthen.command.LogOutCmd;
import com.activestudy.asmobile.mauthen.command.UpdateAccountInfoCmd;
import com.sun.jersey.spi.resource.Singleton;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
@Produces("application/json")

@Path("/mapp")
@Singleton
public class MappWSAPI {

    private Log logger = null;

    public MappWSAPI() {
        System.out.print("MappWSAPI INIT \n");

        Processor.getInstance();
       logger = LogFactory.getLog("mauthen");

    }

    @POST
    @Path("activate")
    public String activate(String content) {

        String email = "";
        String deviceID = "";
        String deviceName = "";
        String osName = "";
        String osVersion = "";
        String cloudKey = "";
        String devOther = "";
        AccountInfoEntity accountInfo = null;
        DeviceInfoEntity deviceInfo = null;

        try {
            JSONObject inJsonObj = new JSONObject(content);

            email = inJsonObj.getString("accountId");            
            accountInfo = new AccountInfoEntity(email, email, "");
            deviceInfo = new DeviceInfoEntity(deviceID, deviceName, osName, osVersion, cloudKey, devOther);
            JSONUtility.GetJSONData(inJsonObj.getString("deviceInfo"), deviceInfo);
        } catch (JSONException ex) {
            logger.error("Error Parse Json: " + ex.getMessage());
        }

        ActiveCmd activeCmdObj = new ActiveCmd(accountInfo, deviceInfo,logger);
        activeCmdObj.execute();

        logger.debug("[" + email + "," + deviceID
                + "] - Activate response = " + activeCmdObj.getResponse());

        return activeCmdObj.getResponse();
    }

    @POST
    @Path("activeCode")
    public String activateCode(String content) {

        String accountId = "";
        String otpCode = "";
        String activationId = "";

        String deviceId = "";
        try {
            logger.debug("JSON content: " + content);
            JSONObject jsonOBj = new JSONObject(content);
            accountId = jsonOBj.getString("accountId");
            otpCode = jsonOBj.getString("otpCode");
            activationId = jsonOBj.getString("activationId");

            deviceId =  jsonOBj.getString("deviceId");
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        ActiveCodeCmd activeCodeCmdObj = new ActiveCodeCmd(logger);
        activeCodeCmdObj.setOtpCode(otpCode);

        activeCodeCmdObj.setActivationId(activationId);
        AccountInfoEntity accountInfo = new AccountInfoEntity(accountId, accountId, "");
        activeCodeCmdObj.setAccountInfo(accountInfo);

        activeCodeCmdObj.setDeviceId(deviceId);
        activeCodeCmdObj.execute();
        logger.debug("[" + accountId + "," + activationId + "," + otpCode
                + "] - Activate response = " + activeCodeCmdObj.getResponse());

        return activeCodeCmdObj.getResponse();
    }

    @PUT

    @Path("/login")
    public String login(String contents) {
        String authenId = "";
        String accountId = "";
        String deviceId = "";
        String cloudKey = "";
        AccountInfoEntity accountInfo = null;

        try {
            JSONObject jsonObj = new JSONObject(contents);

            authenId = jsonObj.getString("authenId");
            accountId = jsonObj.getString("accountId");
            deviceId = jsonObj.getString("deviceId");
            cloudKey = jsonObj.getString("cloudKey");
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        LogInCmd loginOBj = new LogInCmd(logger);
        loginOBj.setAuthenId(authenId);
        accountInfo = new AccountInfoEntity(accountId, accountId, "");
        loginOBj.setAccountInfo(accountInfo);
        loginOBj.setDeviceId(deviceId);
        loginOBj.setCloudKey(cloudKey);

        loginOBj.execute();
        logger.debug("[" + accountId + "," + authenId + "," + deviceId
                + "," + cloudKey
                + "] - Activate response = " + loginOBj.getResponse());

        return loginOBj.getResponse();

    }

    @DELETE
    @Path("logout")
    public String logOut(String Contents) {
        String sessionId = "";
        String accountId = "";
        AccountInfoEntity accountInfo = null;

        try {
            JSONObject jsonObj = new JSONObject(Contents);
            sessionId = jsonObj.getString("sessionId");
            accountId = jsonObj.getString("accountId");

        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        LogOutCmd logoutOBj = new LogOutCmd();
        logoutOBj.setSessionId(sessionId);

        logoutOBj.setAccountId(accountId);        

        logoutOBj.execute();
        logger.debug("[" + sessionId + "," + accountId + ","
                + "] - Activate response = " + logoutOBj.getResponse());
        return logoutOBj.getResponse();
    }

    @GET
    @Path("/get-account-info")
    public String getAccountInfo(String Contents, @QueryParam("accountId") String accountId) {
        
        String deviceId = "";
        String sessionId = "";
        try {
            JSONObject jsonObj = new JSONObject(Contents);
            sessionId = jsonObj.getString("sessionId");

            //accountId = jsonObj.getString("accountId");
            deviceId = jsonObj.getString("deviceId");
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        GetAccountInfoCmd getAccountObj = new GetAccountInfoCmd(sessionId, accountId, deviceId);
        getAccountObj.execute();
        logger.debug("[" + accountId + "," + sessionId + ","
                + "] - Activate response = " + getAccountObj.getResponse());

        return getAccountObj.getResponse();

    }

    @PUT
    @Path("update-account-info")
    public String updateaccountinfo(String content) {
        String sessionId = "";
        String deviceId = "";
        String accountId = "";
        String email = "";
        String password = "";
        String msisdn = "";
        String fullname = "";

        Date birthday = null;
        String job = "";
        String gender = "";

        AccountInfoEntity accountInfo = null;

        try {
            JSONObject jsonObj = new JSONObject(content);
            sessionId = jsonObj.getString("sessionId");
            deviceId = jsonObj.getString("deviceId");
            accountInfo = new AccountInfoEntity(accountId, email, password, msisdn, fullname, birthday, job, gender);
            JSONUtility.GetJSONData(jsonObj.getString("accountInfo"), accountInfo);
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        UpdateAccountInfoCmd updateaccountinfoObj = new UpdateAccountInfoCmd(sessionId, accountInfo, deviceId);
        updateaccountinfoObj.execute();

        logger.debug(
                "[" + sessionId + "," + accountInfo + "," + deviceId
                + "] - Activate response = " + updateaccountinfoObj.getResponse());

        return updateaccountinfoObj.getResponse();
    }

    @GET

    @Path("/get-service-address")
    public String getServiceAddress(String contents) {
        String sessionId = "";
        String accountId = "";
        String deviceId = "";
        int serviceId = 0;

        try {
            JSONObject jsonObj = new JSONObject(contents);
            sessionId = jsonObj.getString("sessionId");
            accountId = jsonObj.getString("accountId");
            deviceId = jsonObj.getString("deviceId");
            serviceId = jsonObj.getInt("serviceId");

        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        GetServiceAddressCmd getServiceAddressCmdObj = new GetServiceAddressCmd(sessionId, accountId, deviceId, serviceId);
        getServiceAddressCmdObj.execute();
        logger.debug("[" + accountId + "," + sessionId + "," + "," + deviceId + "," + serviceId
                + "] - Activate response = " + getServiceAddressCmdObj.getResponse());

        return getServiceAddressCmdObj.getResponse();

    }

    @DELETE
    @Path("check-validate-user")
    public String checkValideUser(String contents) {
        String sessionId = "";
        String accountId = "";

        try {
            JSONObject jsonObj = new JSONObject(contents);

            sessionId = jsonObj.getString("sessionId");
            accountId = jsonObj.getString("accountId");

        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        CheckUserCmd checkUserObj = new CheckUserCmd();

        checkUserObj.setAccountId(accountId);
        checkUserObj.setSessionId(sessionId);

        checkUserObj.execute();
        logger.debug("[" + accountId + "," + sessionId + ","
                + "] - Activate response = " + checkUserObj.getResponse());

        return checkUserObj.getResponse();

    }

}
