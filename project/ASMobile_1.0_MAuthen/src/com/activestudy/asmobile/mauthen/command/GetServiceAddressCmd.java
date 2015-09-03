package com.activestudy.asmobile.mauthen.command;

/**
 *
 * @author PC
 */
public class GetServiceAddressCmd extends ASBaseCommand {

    String sessionId;

    

    @Override
    public void execute() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
