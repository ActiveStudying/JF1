package com.activestudy.asmobile.mauthen.command;

/**
 *
 * @author PC
 */
public class GetServiceAddressCmd extends ASBaseCommand {

    String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void execute() {
    }

    public String getResponse() {
        return "";

    }

    public GetServiceAddressCmd(String sessionId, String email, String deviceId) {
        super(email, deviceId);
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
