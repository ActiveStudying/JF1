/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.behavioral.command;

import com.activestudy.pattern.entity.request.IRequest;
import com.activestudy.pattern.entity.result.IResult;

/**
 *
 * @author tanhai
 */
public abstract class AbsCommand implements ICommand{
    private long commandID = 0;
    private String commandName = "";    
    
    protected IResult result;
    protected IRequest request;
    
        
    public AbsCommand(){        
    }
    public AbsCommand(long commandID){        
        this.commandID = commandID;
    }
    public AbsCommand(long commandID, String commandName){        
        this.commandID = commandID;
        this.commandName = commandName;
    }
    @Override
    public long getCommandID() {
       return commandID;
    }

    @Override
    public void setCommandID(long commandID) {
        this.commandID = commandID;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
    public IResult getResult() {
        return result;
    }

    public void setResult(IResult result) {
        this.result = result;
    }

    public IRequest getRequest() {
        return request;
    }

    public void setRequest(IRequest request) {
        this.request = request;
    }
    
    @Override
    public String toString(){
        return " commandID: " + commandID + " commandName: " + commandName + " request: " + request + " result: " + result ;
    }
}
