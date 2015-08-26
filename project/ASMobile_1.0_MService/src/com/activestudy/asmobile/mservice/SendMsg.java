/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//comment
package com.activestudy.asmobile.mservice;

import com.activestudy.asmobile.mservice.command.SendConfestionCmd;
import com.activestudy.Utility.JSONUtility;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.entity.MessageEntity;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.resource.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SendMsg {

    private Log logger = null;

    public SendMsg() {
        System.out.print("MappWSAPI INIT \n");
        logger = LogFactory.getLog(this.getClass());
        logger.info("Started Web Service for Mapp !!!!");

    }

    @POST
    @Path("activate")
    public String getListClass(String content) {

        String email = "";
        String deviceID = "";
        String deviceName = "";
        String osName = "";
        String osVersion = "";
        String cloudKey = "";
        String devOther = "";
        int messageId;
        String data;
        AccountInfoEntity accountInfo = null;
        DeviceInfoEntity deviceInfo = null;
        MessageEntity  msg = new MessageEntity();
        try {
            JSONObject inJsonObj = new JSONObject(content);
            email = inJsonObj.getString("accountId");
            accountInfo = new AccountInfoEntity(email, email, "");
            deviceInfo = new DeviceInfoEntity(deviceID, deviceName, osName, osVersion, cloudKey, devOther);
            messageId = inJsonObj.getInt("messageId");
            data= inJsonObj.getString("data");
            msg.setMessageId(messageId);
            msg.setData(data);
            JSONUtility.GetJSONData(inJsonObj.getString("Device_Info"), deviceInfo);
        } catch (JSONException ex) {
            logger.error("Error Parse Json: " + ex.getMessage());
        }
    //goi no ra de no thuc hien
        SendConfestionCmd sendConfestionCmdObj = new SendConfestionCmd(accountInfo, deviceInfo,msg);
        sendConfestionCmdObj.execute();

        logger.debug("[" + email + "," + deviceID
                + "] - Activate response = " + sendConfestionCmdObj.getResponse());

        return sendConfestionCmdObj.getResponse();
    }

}
