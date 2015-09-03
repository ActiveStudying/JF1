/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//comment
package com.activestudy.asmobile.mauthen;

import com.activestudy.Utility.JSONUtility;
import com.activestudy.Utility.StringUtility;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mauthen.command.ActiveCmd;
import com.activestudy.asmobile.mauthen.command.ActiveCodeCmd;
import com.activestudy.asmobile.mauthen.command.GetAccountInfoCmd;
import com.activestudy.asmobile.mauthen.command.LogInCmd;
import com.activestudy.asmobile.mauthen.command.LogOutCmd;
import com.sun.jersey.spi.resource.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
@Produces("application/json")
@Path("mapp")
@Singleton
public class MappWSAPI {

    private Log logger = null;

    public MappWSAPI() {
        System.out.print("MappWSAPI INIT \n");
        logger = LogFactory.getLog(this.getClass());
        logger.info("Started Web Service for Mapp !!!!");

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
        ActiveCmd activeCmdObj = new ActiveCmd(accountInfo, deviceInfo);
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
        try {
            JSONObject jsonOBj = new JSONObject(content);
            accountId = jsonOBj.getString("accountId");
            otpCode = jsonOBj.getString("otpCode");
            activationId = jsonOBj.getString("activationId");
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        ActiveCodeCmd activeCodeCmdObj = new ActiveCodeCmd();
        activeCodeCmdObj.setOtpCode(otpCode);

        activeCodeCmdObj.setActivationId(activationId);
        AccountInfoEntity accountInfo = new AccountInfoEntity(accountId, accountId, "");
        activeCodeCmdObj.setAccountInfo(accountInfo);

        activeCodeCmdObj.execute();
        logger.debug("[" + accountId + "," + activationId + "," + otpCode
                + "] - Activate response = " + activeCodeCmdObj.getResponse());

        return activeCodeCmdObj.getResponse();
    }

    @PUT
    @Path("Login")
    public String login(String contents) {
        String authenId = "";
        String accountId = "";
        String deviceId = "";
        String deviceName = "";
        String osName = "";
        String osVersion = "";
        String cloudKey = "";
        String devOther = "";

        AccountInfoEntity accountInfo = null;
        DeviceInfoEntity deviceInfo = null;

        try {
            JSONObject jsonObj = new JSONObject(contents);

            authenId = jsonObj.getString("authenId");
            accountId = jsonObj.getString("accountId");
            deviceId = jsonObj.getString("deviceId");
            cloudKey = jsonObj.getString("cloudKey"); // bo sung trong tai lieu giao tiep 
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        LogInCmd loginOBj = new LogInCmd();
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
        logoutOBj.setEmail(accountId);

        logoutOBj.execute();
        logger.debug("[" + sessionId + "," + accountId + ","
                + "] - Activate response = " + logoutOBj.getResponse());
        return logoutOBj.getResponse();
    }

    @GET
    @Path("GetAccountInfo")
    public String getAccountInfo(String Contents) {
        String accountId = "";
        String deviceId = "";
        String sessionId = "";
        String deviceName = "";
        String osName = "";
        String osVersion = "";
        String cloudKey = "";
        String devOther = "";
        AccountInfoEntity accountInfo = null;
        DeviceInfoEntity deviceInfo = null;

        try {
            JSONObject jsonObj = new JSONObject(Contents);
            sessionId = jsonObj.getString("sessionId");
            accountId = jsonObj.getString("accountId");
            deviceId = jsonObj.getString("deviceId");
        } catch (JSONException ex) {
            Logger.getLogger(MappWSAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        GetAccountInfoCmd getAccountObj = new GetAccountInfoCmd();
        getAccountObj.setSessionId(sessionId);
        getAccountObj.setEmail(accountId);
        getAccountObj.setDeviceId(deviceId);

        getAccountObj.execute();
        logger.debug("[" + accountId + "," + sessionId + ","
                + "] - Activate response = " + getAccountObj.getResponse());

        return getAccountObj.getResponse();

    }
    @PUT
    @Path("chec-validate-user")
    public void checkValideUser(){
        
    }
    

}
