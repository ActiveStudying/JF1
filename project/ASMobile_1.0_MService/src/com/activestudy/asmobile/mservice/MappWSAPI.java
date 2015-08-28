/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//comment
package com.activestudy.asmobile.mservice;

import com.activestudy.Utility.JSONUtility;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mservice.command.*;
import javax.ws.rs.*;
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
        String sessionId = "";
        AccountInfoEntity accountInfo = null;
        DeviceInfoEntity deviceInfo = null;

        try {
            JSONObject inJsonObj = new JSONObject(content);
            email = inJsonObj.getString("accountId");
            accountInfo = new AccountInfoEntity(email, email, "");
            deviceInfo = new DeviceInfoEntity(deviceID, deviceName, osName, osVersion, cloudKey, devOther);
            sessionId = inJsonObj.getString("sessionId");
            JSONUtility.GetJSONData(inJsonObj.getString("Device_Info"), deviceInfo);
        } catch (JSONException ex) {
            logger.error("Error Parse Json: " + ex.getMessage());
        }
        CreateGroupCmd activeCmdObj = new CreateGroupCmd(accountInfo, deviceInfo);
        activeCmdObj.execute();

        logger.debug("[" + email + "," + deviceID
                + "] - Activate response = " + activeCmdObj.getResponse());

        return activeCmdObj.getResponse();
    }

    @POST
    @Path("create-event")
    public String createEvent(String content) {
    }

    @POST
    @Path("add-member-on-class")
    public String addMemberOnClass(String content) {

    }

    @POST
    @Path("create-group")
    public String createGroup(String content) {
        CreateGroupCmd createGroupCmdObj = new CreateGroupCmd();
        createGroupCmdObj.parse(content);
        createGroupCmdObj.execute();
        return createGroupCmdObj.getResponse();
    }

    @GET
    @Path("add-member-by-email")
    public String getMemberByEmail(String content) {
    }

    @GET
    @Path("get-group-contact")
    public String getGroupContact(String content) {
    }

    @GET
    @Path("get-list-course")
    public String getListCourse(String content) {
    }

    @POST
    @Path("create-course")
    public String createCourse(String content) {
    }

    @POST
    @Path("add-member-on-group")
    public String addMemberOnGroup(String content) {
    }

    @POST
    @Path("add-task-team")
    public String addTaskTeam(String content) {
    }

    @GET

    @GET
    @Path("get-list-member-on-group")
    public String getListMemberOnGroup(String content) {
    }

    @GET
    @Path("get-history-message")
    public String getHistoryMessage(String content) {
    }

    @GET
    @Path("get-history-confestion")
    public String getHistoryConfestion(String content) {
    }

    @GET
    @Path("get-calendar-study")
    public String getCalendarStudy(String content) {
    }

    @GET
    @Path("get-user-group")
    public String getUserGroup(String content) {
    }

    @POST
    @Path("synch-login")
    public String synchLogin(String content) {
        SynchLoginCmd synchLoginCmdObj = new SynchLoginCmd();
        synchLoginCmdObj.parse(content);
        synchLoginCmdObj.execute();
        return synchLoginCmdObj.getResponse();
    }

    @DELETE
    @Path("synch-logout")
    public String synchLogout(String content) {
        SynchLogoutCmd synchLogoutObj = new SynchLogoutCmd();
        synchLogoutObj.parse(content);
        synchLogoutObj.execute();
        return synchLogoutObj.getResponse();
    }

    @GET
    @Path("get-list-class")
    public String getListClass(String content) {
        GetListClassCmd requestJoinClassCmdObj = new GetListClassCmd();
        requestJoinClassCmdObj.parse(content);
        requestJoinClassCmdObj.execute();
        return requestJoinClassCmdObj.getResponse();

    }

    @POST
    @Path("send-confestion-message")
    public String sendConfestionMessage(String content) {
        SendConfestionMessageCmd sendConfestionMessageCmdObj = new SendConfestionMessageCmd();
        sendConfestionMessageCmdObj.parse(content);
        sendConfestionMessageCmdObj.execute();
        return sendConfestionMessageCmdObj.getResponse();
    }

    @POST
    @Path("send-message")
    public String sendMessage(String content) {
        SendMessageCmd sendMessageCmd = new SendMessageCmd();
        sendMessageCmd.parse(content);
        sendMessageCmd.execute();
        return sendMessageCmd.getResponse();
    }

    @POST
    @Path("request-join-class")
    public String requestJoinClass(String content) {
        RequestJoinClassCmd requestJoinClassCmdObj = new RequestJoinClassCmd();
        requestJoinClassCmdObj.parse(content);
        requestJoinClassCmdObj.execute();
        return requestJoinClassCmdObj.getResponse();
    }

    @POST
    @Path("request-create-course")
    public String requestCreateCourse(String content) {
        RequestCreateCourseCmd requestCreateCourseCmdObj = new RequestCreateCourseCmd();
        requestCreateCourseCmdObj.parse(content);
        requestCreateCourseCmdObj.execute();
        return requestCreateCourseCmdObj.getResponse();
    }

    @POST
    @Path("register-course")
    public String registerCourse(String content) {
        RegisterCourseCmd registerCourseCmdObj = new RegisterCourseCmd();
        registerCourseCmdObj.parse(content);
        registerCourseCmdObj.execute();
        return registerCourseCmdObj.getResponse();
    }

}
