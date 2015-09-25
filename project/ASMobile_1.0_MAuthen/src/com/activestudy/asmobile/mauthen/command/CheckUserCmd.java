package com.activestudy.asmobile.mauthen.command;

/**
 *
 * @author PC
 */
public class CheckUserCmd extends ASBaseCommand {

    String sessionId;

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

   


}
