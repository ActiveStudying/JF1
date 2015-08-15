/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.entity.request;

import com.activestudy.Utility.ActionQueue;
import com.activestudy.Utility.Define.AbsDefine;
import com.activestudy.pattern.entity.response.IResponse;
import java.util.Date;

/**
 *
 * @author tanhai
 */
public abstract class AbsRequest implements IRequest{
    protected static final long nLimit = Long.parseLong("1000000000000");
    protected static long moduleID = 1;
    protected static int sequentID = 0;
    
    long        requestID = AbsDefine.KEY_NO_DEFINE;
    String      requestName = AbsDefine.NAME_NO_DEFINE;    
    ActionQueue queue;      //queue de chua cac request tam thoi
    IResponse   response;   // Ket qua thuc hien result;
    private int requestTimeOut = 15000; //minisecon giay. thoi gian request toi da
    
    public AbsRequest(ActionQueue queue, int requestTimeOut){        
        this.queue = queue;
        this.requestTimeOut = requestTimeOut;
    }
    public synchronized boolean invoke() throws InterruptedException{
        if(queue == null){
            return false;
        }
        queue.add(this);
        wait(requestTimeOut);
        return true;
    }
    

    /**
     *
     * @param response
     * @return
     */
    public synchronized boolean setResponse(IResponse response){
        this.response = response;
        notifyAll();
        return true;
    }
    
    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }    

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }
    
     private synchronized static long  generateRequestID(){                 
        sequentID = (sequentID+1)%0x64;
        return (new Date().getTime())%nLimit + (((moduleID%0x64)*0x64) + sequentID)*nLimit;        
    }     
    public synchronized static long  generateRequestID(int moduleID){          
        sequentID = (sequentID+1)%0x64;
        return (new Date().getTime())%nLimit + (((moduleID%0x64)*0x64) + sequentID)*nLimit;        
    }  
    public  long getModuleID() {
        return moduleID;
    }

    /**
     *
     * @param moduleID
     */
    public synchronized void setModuleID(int moduleID) {///ModuleID (0-99)
        AbsRequest.moduleID = moduleID%0x64;
        requestID = generateRequestID();
    }
    @Override
    public String toString(){
        return " requestID: " + requestID + " requestName: "  + requestName;
    }
    
}
