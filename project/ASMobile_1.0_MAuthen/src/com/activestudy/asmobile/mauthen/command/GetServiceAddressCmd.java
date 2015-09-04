package com.activestudy.asmobile.mauthen.command;

/**
 *
 * @author PC
 */
public class GetServiceAddressCmd extends ASBaseCommand {

    String sessionId;
    int serviceId ;

    public GetServiceAddressCmd(String sessionId, String email, String deviceId,int serviceId ) {
        super(email, deviceId);
        this.sessionId = sessionId;
        this.serviceId = serviceId;
    }

    @Override
    public void execute() {
    }

    public String getResponse() {
        return "";

    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
